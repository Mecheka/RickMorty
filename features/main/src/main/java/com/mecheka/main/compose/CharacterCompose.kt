package com.mecheka.main.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mecheka.domain.character.model.Character
import com.mecheka.domain.character.model.Location
import com.mecheka.domain.character.model.Origin
import com.mecheka.resource.JetRickMortyTheme
import com.mecheka.rickmorty.main.R

@Composable
fun CharacterItem(character: Character, onLikeClick: (Character) -> Unit = {}) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(4.dp)
            .width(110.dp)
    ) {
        Column {
            AsyncImage(
                model = character.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 8.dp)
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
                    .clip(CircleShape)
            )
            Image(painter = painterResource(id = if (character.isLike) R.drawable.ic_like else R.drawable.ic_unlike),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        onLikeClick(character)
                    }
            )
            Text(text = character.likeCount.toString(), modifier = Modifier.align(Alignment.CenterHorizontally))
            Text(
                text = character.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@Preview
@Composable
fun PreviewCharacterItem() {
    JetRickMortyTheme {
        CharacterItem(
            Character(
                created = "",
                episode = listOf(),
                gender = "",
                id = 0,
                image = "",
                locationEntity = Location(
                    name = "", url = "",
                    created = "",
                    dimension = "",
                    id = 0,
                    residents = listOf(),
                    type = ""
                ),
                name = "Character",
                originEntity = Origin(name = "", url = ""),
                species = "",
                status = "",
                type = "",
                url = ""
            )
        )
    }
}

@Preview
@Composable
fun PreviewCharacterList() {
    JetRickMortyTheme {
        LazyColumn {
            items(
                List(10) {
                    Character(
                        created = "",
                        episode = listOf(),
                        gender = "",
                        id = 0,
                        image = "",
                        locationEntity = Location(
                            name = "", url = "",
                            created = "",
                            dimension = "",
                            id = 0,
                            residents = listOf(),
                            type = ""
                        ),
                        name = "",
                        originEntity = Origin(name = "", url = ""),
                        species = "",
                        status = "",
                        type = "",
                        url = "",
                        isLike = it %2 == 0
                    )
                }
            ) {
                CharacterItem(character = it)
            }
        }
    }
}
