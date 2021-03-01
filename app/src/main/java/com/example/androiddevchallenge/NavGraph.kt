/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
