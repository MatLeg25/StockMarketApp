package com.plcoding.stockmarketapp.data.csv

import com.opencsv.CSVReader
import com.plcoding.stockmarketapp.data.mapper.toIntradayInfo
import com.plcoding.stockmarketapp.data.remote.dto.IntradayInfoDto
import com.plcoding.stockmarketapp.domain.model.IntradayInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.InputStream
import java.io.InputStreamReader
import java.time.LocalDate
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class IntradayInfoParser @Inject constructor(): CsvParser<IntradayInfo> {
    override suspend fun parse(stream: InputStream): List<IntradayInfo> {
        val csvReader = CSVReader(InputStreamReader(stream))

        //for weekend days there is no data from market
        val previousWorkingDayDelta = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            Calendar.SUNDAY -> 2
            Calendar.MONDAY -> 3
            else -> 1
        }

        return withContext(Dispatchers.IO) {
            csvReader
                .readAll()
                .drop(1) //drop header
                .mapNotNull { line ->
                    val timestamp = line.getOrNull(0) ?: return@mapNotNull null
                    val close = line.getOrNull(4) ?: return@mapNotNull null
                    val dto = IntradayInfoDto(timestamp, close.toDouble())
                    dto.toIntradayInfo()
                }
                //filter only date from previous working day (to be sure that all date(for each hour) available)
                .filter { it.date.dayOfMonth == LocalDate.now().minusDays(previousWorkingDayDelta.toLong()).dayOfMonth }
                .sortedBy { it.date.hour }
                .also {
                    csvReader.close()
                }
        }
    }
}