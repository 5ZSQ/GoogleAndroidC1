package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Dog
import com.example.androiddevchallenge.model.dogs
import com.example.androiddevchallenge.ui.theme.MyTheme

/**
 * pup list view
 */
@Composable
fun DogsListView(selectDog: (Dog) -> Unit) {

    MyTheme() {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.subtitle2,
                            color = LocalContentColor.current
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(
                                painter = painterResource(R.drawable.icon_bar_dog),
                                contentDescription = ""
                            )
                        }
                    }
                )
            },
            content = {

                //dog list
                dogsList(dogs, Modifier, selectDog)
//                Surface(color = MaterialTheme.colors.background) {
//                    //dog list
//                    dogsList(dogs, Modifier, selectDog)
//                }
            },
        )
    }
}


/**
 * dog list
 */
@Composable
fun dogsList(
    dogs: List<Dog>,
    modifier: Modifier = Modifier,
    selectDog: (Dog) -> Unit,
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        StaggeredVerticalGrid(
            maxColumnWidth = 220.dp,
            modifier = Modifier.padding(4.dp)
        ) {
            dogs.forEach { dog ->
                dogCard(dog, selectDog)
            }
        }
    }
}

/**
 * dog card
 */
@Composable
fun dogCard(dog: Dog, selectDog: (Dog) -> Unit) {

    val image = ImageBitmap.imageResource(dog.imgResId)

    MaterialTheme {
        val typography = MaterialTheme.typography

        Column(
            modifier = Modifier
                .padding(16.dp)
                .clickable(onClick = { selectDog(dog) })
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
                dog.desc.toString(),
                maxLines = 2, style = typography.body2
            )
        }
    }

}



@Preview(name = "dog list preview")
@Composable
private fun DogsListViewPreview() {
    DogsListView {}
}

