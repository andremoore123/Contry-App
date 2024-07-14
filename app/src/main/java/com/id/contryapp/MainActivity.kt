package com.id.contryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.id.contryapp.ui.screen.MainContainer
import com.id.contryapp.ui.screen.home.HomeScreen
import com.id.contryapp.ui.theme.ContryAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ContryAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   MainContainer(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}