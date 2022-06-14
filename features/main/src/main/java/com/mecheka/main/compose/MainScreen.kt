package com.mecheka.main.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mecheka.main.MainViewModel
import com.mecheka.main.UiState
import com.mecheka.resource.JetRickMortyTheme
import org.koin.androidx.compose.getViewModel

@Composable
fun MainScreen() {
    val viewModel = getViewModel<MainViewModel>()
    val scaffold = rememberScaffoldState()

    LaunchedEffect(key1 = viewModel) {
        viewModel.loadAllCharacter()
        viewModel.getAllLocation()
    }

    Scaffold(
        scaffoldState = scaffold,
        topBar = {
            TopAppBar(title = {
                Text(text = "Home", color = MaterialTheme.colors.onSecondary)
            })
        }
    ) {
        val showLoading = viewModel.isLoading.collectAsState().value
        val characters = viewModel.character.collectAsState().value
        val locations = viewModel.locations.collectAsState().value
        if (showLoading) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    color = MaterialTheme.colors.secondary,
                    modifier = Modifier.size(50.dp)
                )
            }
        } else {
            LazyColumn {
                if (characters is UiState.Success) {
                    item {
                        ItemTitle(title = "Character") {

                        }
                    }
                    item {
                        LazyRow(contentPadding = PaddingValues(horizontal = 16.dp)) {
                            items(characters.data) {
                                CharacterItem(character = it)
                            }
                        }

                    }
                }

                if (locations is UiState.Success) {
                    item {
                        ItemTitle(title = "Location") {

                        }
                    }
                    items(locations.data) {
                        LocationItem(location = it)
                    }
                }
            }
        }
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
