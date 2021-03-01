package com.example.androiddevchallenge

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.dogs
import com.example.androiddevchallenge.ui.theme.MyTheme

/**
 * pup detail
 */
@Composable
fun DogDetailView(dog: Dog, upPress: () -> Unit) {
    MyTheme() {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = dog.name!!,
                            style = MaterialTheme.typography.subtitle2,
                            color = LocalContentColor.current
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { upPress() }) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "back"
                            )
                        }
                    }
                )
            },
            content = { innerPadding ->
                val modifier = Modifier.padding(innerPadding)
                dogDetailCard(dog)
            },
        )

    }
}

@Composable
fun dogDetailCard(dog: Dog) {

    Surface(color = MaterialTheme.colors.background) {

        val image = ImageBitmap.imageResource(dog.imgResId)

        MaterialTheme {
            val typography = MaterialTheme.typography

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(onClick = {
                    })
                    .fillMaxWidth()
            ) {
                val imageModifier = Modifier
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(8.dp))
                    .padding(3.dp)

                Image(bitmap = image, contentDescription = dog.name, modifier = imageModifier)

                Text(
                    text = dog.name!!.toUpperCase(),
                    color = MaterialTheme.colors.primary,
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier
                        .padding(
                            top = 3.dp,
                            bottom = 3.dp
                        )
                )

                Text(
                    "No. " + dog.id,
                    style = typography.body2
                )
                Text(
                    dog.desc!!,
                    maxLines = 2, style = typography.body2
                )
            }
        }
    }


}


@Preview(name = "dog detail preview")
@Composable
private fun DetailPreview() {
    MyTheme() {
        DogDetailView(dogs.first(), {})
    }
}

