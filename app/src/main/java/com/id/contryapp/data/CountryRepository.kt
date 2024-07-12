package com.id.contryapp.data

import android.util.Log
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
            val result = response?.map {
                mapDataResponseToModel(it)
            } ?: listOf()
            Log.d("CR_SUCCESS", result.toString())
            Resource.Success(result)
        } catch (e: Exception) {
            Log.d("CR_ERROR", e.message.toString())
            Resource.Error(e.message.toString())
        }
    }
}