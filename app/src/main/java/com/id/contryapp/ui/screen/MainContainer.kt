package com.id.contryapp.ui.screen;

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import com.id.contryapp.ui.theme.ContryAppTheme

enum class MainScreen {
    HOME,
    DETAIL
}

@Composable
fun MainContainer(
    modifier: Modifier = Modifier
) {

}

@Composable
@Preview
fun ShowMainContainerPreview() {
    ContryAppTheme {
        MainContainer()
    }
}
