package com.id.contryapp.ui.screen.home;

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.id.contryapp.ui.components.card.CountryCard
import com.id.contryapp.ui.components.textfield.SearchTextField
import com.id.contryapp.ui.theme.ContryAppTheme
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.job


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val coroutineJob = rememberCoroutineScope()

    val uiState by viewModel.uiState.collectAsState()

    var searchValue by remember { mutableStateOf("") }

    LaunchedEffect(key1 = searchValue) {
        val job = coroutineJob.coroutineContext.job
        job.cancelAndJoin()
        delay(1000)
        viewModel.filterCountries(searchValue)
    }

    LaunchedEffect(key1 = Unit) {
        viewModel.fetchCountries()
    }

    Scaffold(
        modifier = modifier,
        topBar = { TopBarContent() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SearchTextField(
                value = searchValue
            ) {
                searchValue = it
            }
            when (val state = uiState.state) {
                is HomeState.Error -> {

                }
                HomeState.Loading -> {

                }
                is HomeState.Success -> {
                    LazyVerticalGrid(
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .padding(horizontal = 20.dp),
                        columns = GridCells.Adaptive(250.dp),
                        horizontalArrangement = Arrangement.spacedBy(20.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        if (state.filteredData.isEmpty()) {
                            items(state.data) {
                                CountryCard(countryData = it)
                            }
                        } else {
                            items(state.filteredData) {
                                CountryCard(countryData = it)
                            }
                        }
                    }
                }

                else -> {}
            }
        }
    }
}

@Composable
@Preview
fun ShowHomeScreenPreview() {
    ContryAppTheme {
        HomeScreen()
    }
}
