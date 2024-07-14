package com.id.contryapp.domain

data class CountryModel(
    val name: String,
    val nativeName: String,
    val population: Int,
    val region: String,
    val capital: String,

    val flagUrl: String,
    val tld: String,
    val borderCountries: List<String>
) {
    companion object {
        val dummy = CountryModel(
            name = "Phyllis Pace",
            nativeName = "Kent Clarke",
            population = 2174,
            region = "viris",
            capital = "vix",
            flagUrl = "http://www.bing.com/search?q=tritani",
            tld = "dolor",
            borderCountries = listOf("France", "Germany")
        )
        val empty = CountryModel (
            name = "",
            nativeName = "",
            population = 0,
            region = "",
            capital = "",
            flagUrl = "",
            tld = "",
            borderCountries = listOf()

        )
    }
}
