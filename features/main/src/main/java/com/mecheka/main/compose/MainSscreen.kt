package com.mecheka.main.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mecheka.resource.JetRickMortyTheme

@Composable
fun MainScreen() {
    val scaffold = rememberScaffoldState()
    Scaffold(scaffoldState = scaffold,
        topBar = {
            TopAppBar(title = {
                Text(text = "Home", color = MaterialTheme.colors.onSecondary)
            })
        }) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Text("Character", modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp))
            CharacterList(
                characters = List(10) { "a" },
            )
        }
    }
}

@Composable
private fun CharacterItem() {
    Card(elevation = 4.dp, modifier = Modifier.padding(4.dp)) {
        Column {
            Image(
                painter = painterResource(id = com.mecheka.resource.R.drawable.ic_app_logo),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 8.dp)
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
            )
            Text(
                text = "Character",
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Composable
private fun CharacterList(characters: List<String>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 12.dp)
    ) {
        items(characters) {
            CharacterItem()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCharacterItem() {
    JetRickMortyTheme {
        CharacterItem()
    }
}

@Preview
@Composable
fun PreviewCharacterList() {
    JetRickMortyTheme {
        CharacterList(characters = List(10) { "a" })
    }
}

@Preview(showBackground = true, name = "Light mode")
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "Dark mode")
@Composable
fun PreviewTest() {
    JetRickMortyTheme {
        MainScreen()
    }
}