package com.plcoding.stockmarketapp.util

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ErrorInfo(dataSource: String) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState, enabled = true),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Cannot fetch $dataSource.",
            fontSize = 14.sp,
            color = MaterialTheme.colors.error,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Light
        )
        Text(
            text = "Please try again later.",
            fontSize = 14.sp,
            color = MaterialTheme.colors.error,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Light
        )
    }
}