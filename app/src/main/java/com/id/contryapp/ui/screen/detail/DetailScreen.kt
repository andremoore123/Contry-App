package com.id.contryapp.ui.screen.detail;

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.id.contryapp.domain.CountryModel
import com.id.contryapp.ui.theme.ContryAppTheme
import com.id.contryapp.ui.theme.Typography


@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    countryData: CountryModel,
    onBackClickListener: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .padding(16.dp)
    ) {
        OutlinedButton(onClick = onBackClickListener) {
            Row {
                Icon(imageVector = Icons.AutoMirrored.Default.ArrowBack, contentDescription = null)
                Text(text = "Back")
            }
        }
        AsyncImage(
            model = countryData.flagUrl, contentDescription = null,
            modifier = Modifier
                .aspectRatio(2f)
                .padding(20.dp)
        )
        Text(
            text = countryData.name, style = Typography.titleLarge.copy(
                fontWeight = FontWeight.Black
            ),
            modifier = Modifier.padding(vertical = 10.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(top = 5.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Native Name: ", style = Typography.titleMedium.copy(
                        fontWeight = FontWeight.Black
                    )
                )
                Text(text = countryData.nativeName)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Population: ", style = Typography.titleMedium.copy(
                        fontWeight = FontWeight.Black
                    )
                )
                Text(text = countryData.population.toString())
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Regin: ", style = Typography.titleMedium.copy(
                        fontWeight = FontWeight.Black
                    )
                )
                Text(text = countryData.region)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Capital: ", style = Typography.titleMedium.copy(
                        fontWeight = FontWeight.Black
                    )
                )
                Text(text = countryData.capital)
            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 10.dp)
            ) {
                Text(
                    text = "Top Level Domain: ", style = Typography.titleMedium.copy(
                        fontWeight = FontWeight.Black
                    )
                )
                Text(text = countryData.tld)
            }
        }
        if (countryData.borderCountries.isNotEmpty()) {
            Text(
                text = "Border Countries", style = Typography.titleLarge,
                modifier = Modifier.padding(top = 20.dp)
            )
            LazyRow(
                modifier = Modifier.padding(top = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(countryData.borderCountries) {
                    Column(
                        modifier = Modifier.border(2.dp, Color.Black, RoundedCornerShape(20.dp))
                    ) {
                        Text(
                            text = it,
                            modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ShowDetailScreenPreview() {
    ContryAppTheme {
        DetailScreen(countryData = CountryModel.dummy)
    }
}
