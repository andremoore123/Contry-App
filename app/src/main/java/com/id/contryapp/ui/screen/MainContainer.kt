package com.id.contryapp.ui.screen;

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.id.contryapp.domain.CountryModel
import com.id.contryapp.ui.screen.detail.DetailScreen
import com.id.contryapp.ui.screen.home.HomeScreen
import com.id.contryapp.ui.screen.home.HomeViewModel
import com.id.contryapp.ui.screen.home.TopBarContent
import com.id.contryapp.ui.theme.ContryAppTheme

enum class MainScreen {
    HOME,
    DETAIL
}

@Composable
fun MainContainer(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    var selectedDetail by remember { mutableStateOf(CountryModel.empty) }
    var currentScreen by remember { mutableStateOf(MainScreen.HOME) }

    Scaffold(
        modifier = modifier,
        topBar = { TopBarContent() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            when (currentScreen) {
                MainScreen.HOME -> {
                    HomeScreen(onClickListener = {
                        selectedDetail = it
                        currentScreen = MainScreen.DETAIL
                    })
                }

                MainScreen.DETAIL -> {
                    if (selectedDetail != CountryModel.empty) {
                        DetailScreen(
                            onBackClickListener = {
                                currentScreen = MainScreen.HOME
                                selectedDetail = CountryModel.empty
                            },
                            countryData = selectedDetail
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun ShowMainContainerPreview() {
    ContryAppTheme {
        MainContainer()
    }
}
