package com.id.contryapp.data.response

import com.google.gson.annotations.SerializedName

data class CountriesResponse(

	@field:SerializedName("ContriesResponse")
	val contriesResponse: List<CountriesDataResponse>? = null
)

