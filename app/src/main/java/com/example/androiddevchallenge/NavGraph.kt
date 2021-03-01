
package com.example.androiddevchallenge

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.MainDestinations.KEY_DOG_MODEL
import com.example.androiddevchallenge.model.Dog

/**
 * Destinations
 */
object MainDestinations {
    const val DOG_ITEM_SELECT_ROUTE = "dogSelect"
    const val DOG_DETAIL_ROUTE = "dogDetail"
    const val KEY_DOG_MODEL = "KEY_DOGMODEL"
}

@Composable
fun NavGraph(startDestination: String = MainDestinations.DOG_ITEM_SELECT_ROUTE) {

    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.DOG_ITEM_SELECT_ROUTE) {
            DogsListView(selectDog = actions.selectDog)
        }

        composable(MainDestinations.DOG_DETAIL_ROUTE) {

            val dog =
                navController.previousBackStackEntry?.arguments?.getParcelable<Dog>(KEY_DOG_MODEL)

            DogDetailView(
                dog!!,
                upPress = actions.upPress
            )
        }
    }
}

/**
 * Models the navigation actions in the app.
 */
class MainActions(navController: NavHostController) {
    val selectDog: (Dog) -> Unit = { dogModel: Dog ->

        navController.currentBackStackEntry
            ?.arguments?.putParcelable(KEY_DOG_MODEL, dogModel)
        navController.navigate(MainDestinations.DOG_DETAIL_ROUTE)
    }
    val upPress: () -> Unit = {
        navController.navigateUp()
    }
}
