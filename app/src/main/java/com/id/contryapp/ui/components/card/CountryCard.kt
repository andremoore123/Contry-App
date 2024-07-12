package com.id.contryapp.ui.components.card;

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.id.contryapp.domain.CountryModel
import com.id.contryapp.ui.theme.ContryAppTheme
import com.id.contryapp.ui.theme.Typography


@Composable
fun CountryCard(
    modifier: Modifier = Modifier,
    countryData: CountryModel
) {
    Card(
        modifier = modifier,
    ) {
        AsyncImage(
            model = countryData.flagUrl, contentDescription = null,
            modifier = Modifier.height(250.dp).fillMaxWidth(), contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .padding(top = 30.dp, bottom = 40.dp)
                .padding(horizontal = 30.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = countryData.name,
                style = Typography.titleLarge.copy(fontWeight = FontWeight.Black),
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Population: ",
                    style = Typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(text = countryData.population.toString(), style = Typography.bodyMedium)
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Region: ",
                    style = Typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(text = countryData.region, style = Typography.bodyMedium)
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Capital: ",
                    style = Typography.bodyMedium.copy(fontWeight = FontWeight.Bold)
                )
                Text(text = countryData.capital, style = Typography.bodyMedium)
            }
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ShowCountryCardPreview() {
    ContryAppTheme {
        CountryCard(
            countryData = CountryModel.dummy
        )
    }
}
