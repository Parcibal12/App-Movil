package com.example.layouts2

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.layouts2.ui.theme.Layouts2Theme



//Componente genérico
@Composable
fun GenericTabbedView(
    tabs: List<String>,
    modifier: Modifier = Modifier,
    content: @Composable (index: Int) -> Unit
) {
    var selectedIndex by remember { mutableStateOf(0) }

    Column(modifier = modifier) {
        TabRow(selectedTabIndex = selectedIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = (index == selectedIndex),
                    onClick = { selectedIndex = index },
                    text = { Text(title) }
                )
            }
        }

        Box(modifier = Modifier.padding(16.dp)) {
            content(selectedIndex)
        }
    }
}

@Preview(showBackground = true, name = "Componente 1: Tabs")
@Composable
fun TabbedViewPreview() {
    Layouts2Theme {
        GenericTabbedView(
            tabs = listOf("Descripción", "Reseñas", "Envíos")
        ) { index ->
            when (index) {
                0 -> Text("descripción...")
                1 -> Text("reseñas")
                2 -> Text("envíos")
            }
        }
    }
}


