package com.plcoding.stockmarketapp.data.local

class StockDaoFake: StockDao {

    private var companyListings = emptyList<CompanyListingEntity>()
    private var companyInfos = emptyList<CompanyInfoEntity>()

    override suspend fun insertCompanyListings(companyListingEntities: List<CompanyListingEntity>) {
        companyListings += companyListingEntities
    }

    override suspend fun clearCompanyListings() {
        companyListings = emptyList()
    }

    override suspend fun searchCompanyListing(query: String): List<CompanyListingEntity> {
        return companyListings.filter {
            it.name.lowercase().contains(query.lowercase())
        }
    }

    override suspend fun insertCompanyInfo(companyInfoEntity: CompanyInfoEntity) {
        companyInfos += companyInfos
    }

    override suspend fun searchCompanyInfo(query: String): CompanyInfoEntity? {
        return companyInfos.find {
            it.symbol.lowercase() == query.lowercase()
        }
    }
}