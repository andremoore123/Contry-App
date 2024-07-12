package com.id.contryapp.data

import com.id.contryapp.data.response.CountriesDataResponse
import com.id.contryapp.data.response.CountriesResponse
import retrofit2.http.GET

interface CountryApiService {
    @GET("all")
    suspend fun fetchCountries(): List<CountriesDataResponse>?
}