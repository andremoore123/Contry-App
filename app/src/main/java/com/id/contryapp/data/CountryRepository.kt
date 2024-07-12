package com.id.contryapp.data

import com.id.contryapp.data.CountryMapper.mapDataResponseToModel
import com.id.contryapp.domain.CountryModel
import com.id.contryapp.domain.ICountryRepository
import com.id.contryapp.domain.Resource
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val apiService: CountryApiService
) : ICountryRepository {
    override suspend fun fetchCountries(): Resource<List<CountryModel>> {
        return try {
            val response = apiService.fetchCountries()
            val result = response.contriesResponse?.map {
                mapDataResponseToModel(it)
            } ?: listOf()
            Resource.Success(result)
        } catch (e: Exception) {
            Resource.Error(e.message.toString())
        }
    }
}