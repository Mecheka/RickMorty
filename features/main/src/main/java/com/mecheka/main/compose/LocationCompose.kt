package com.mecheka.main.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mecheka.domain.character.model.Location
import com.mecheka.main.UiState
import com.mecheka.resource.JetRickMortyTheme

@Composable 
fun LocationItem(location: Location) {
    Card(elevation = 4.dp, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 4.dp)) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = location.name)
            Text(text = location.dimension)
            Text(text = location.type)
        }
    }
}

@Preview
@Composable
fun PreviewLocationItem() {
    JetRickMortyTheme {
        LocationItem(
            Location(
                created = "",
                dimension = "Dimension C-137",
                id = 0,
                name = "Earth",
                residents = listOf(),
                type = "Planet",
                url = ""
            )
        )
    }
}

@Preview
@Composable
fun PreviewLocationList() {
    JetRickMortyTheme {
        LazyColumn {
            items(List(5) {
                Location(
                    created = "",
                    dimension = "Dimension C-137",
                    id = 0,
                    name = "Earth",
                    residents = listOf(),
                    type = "Planet",
                    url = ""
                )
            }) {
                LocationItem(location = it)
            }
        }
    }
}
