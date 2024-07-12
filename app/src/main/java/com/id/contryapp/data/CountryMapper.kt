package com.id.contryapp.data

import com.id.contryapp.data.response.CountriesDataResponse
import com.id.contryapp.domain.CountryModel

object CountryMapper {
    fun mapDataResponseToModel(q: CountriesDataResponse) = CountryModel(
        name = q.name?.common ?: "",
        nativeName = q.name?.official ?: "",
        population = q.population ?: 0,
        region = q.region ?: "",
        capital = q.capital?.firstOrNull() ?: "",
        flagUrl = q.flags?.png ?: "",
        tld = q.tld?.firstOrNull() ?: "",
        borderCountries = q.borders ?: listOf()
    )
}