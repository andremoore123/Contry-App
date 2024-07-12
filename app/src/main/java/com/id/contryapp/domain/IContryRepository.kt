package com.id.contryapp.domain

interface ICountryRepository {
    suspend fun fetchCountries(): Resource<List<CountryModel>>
}