package com.id.contryapp.ui.screen.home;

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.id.contryapp.ui.theme.ContryAppTheme
import com.id.contryapp.ui.theme.Typography


@Composable
fun TopBarContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Where in the world?", style = Typography.titleLarge)
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Default.Menu, contentDescription = null, modifier = Modifier.padding(end = 10.dp))
                Text(text = "Dark Mode", style = Typography.bodyLarge)
            }
        }
        HorizontalDivider(Modifier.fillMaxWidth(), thickness = 2.dp)
    }
}

@Composable
@Preview
fun ShowTopBarContentPreview() {
    ContryAppTheme {
        TopBarContent()
    }
}
