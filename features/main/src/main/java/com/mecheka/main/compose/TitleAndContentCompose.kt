package com.mecheka.main.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mecheka.resource.JetRickMortyTheme

@Composable
fun TitleAndContent(
    title: String,
    onSeeMoreClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Column {
        ItemTitle(title, onClick = onSeeMoreClick)
        content()
    }
}

@Composable
fun ItemTitle(title: String, onClick: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.h2)
        Text("see more", modifier = Modifier.clickable(onClick = onClick))
    }
}

@Preview
@Composable
fun PreviewTileItem() {
    JetRickMortyTheme {
        ItemTitle(title = "Title") {
        }
    }
}
