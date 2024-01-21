package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                MainScreen()
            }
        }
    }
}

/*
    Jet pack navigation - transition between fragments.
    Jet pack compose navigation - transition between composable-screens.
 */
@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screenA") {
        composable(route = "screenA") {
            ComposableScreenOne(navController)
        }
        composable(
            route = "screenB/{text}", arguments =
            listOf(navArgument(name = "text") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            ComposableScreenTwo(navBackStackEntry.arguments?.getString("text") ?: "", navController)
        }
    }
}

@Composable
private fun ComposableScreenOne(navController: NavHostController) {
    val screenBData = "ScreenBContent"
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Green) {
        Text(text = "abc",
            Modifier
                .clickable {
                    navController.navigate(route = "screenB/${screenBData}")
                }
                .wrapContentSize(align = Alignment.Center))
    }
}

@Composable
private fun ComposableScreenTwo(content: String, navController: NavHostController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Color.Red) {
        Text(text = content,
            Modifier
                .clickable {
                    navController.navigateUp()
                }
                .wrapContentSize(align = Alignment.Center))
    }
}