package com.example.composedemo

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreen() {
    Text(text = "Sai kalyan", color = Color.Blue)
}

@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreenV2() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier =
        Modifier
            .background(Color.Red)
            .fillMaxSize(0.5f) // takes 0.5 for both height and width.
    ) {
        Text(text = "sai")
        Text(text = "kalyan")
        Text(text = "Android")
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreenV3() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically, modifier =
        Modifier
            .background(Color.Red)
            .width(250.dp)
            .fillMaxHeight(0.5f)
            .padding(10.dp)
    ) {
        Text(text = "sai", modifier = Modifier.offset(50.dp, 100.dp))
        Text(text = "kalyan")
        Text(text = "Android")
    }
}
/*
  requiredWidth --> takes exactly that much width ,even though it exceeds the screen.
 */

@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreenV4() {
    Column(
        modifier =
        Modifier
            .background(Color.Red)
            .fillMaxSize(0.5f)
            .border(2.dp, Color.Blue, RectangleShape)
            .padding(10.dp)
            .border(3.dp, Color.White, CircleShape)
    ) {
        Text(text = "sai", Modifier.offset(100.dp))
        Spacer(
            modifier = Modifier
                .height(30.dp)
                .width(100.dp)
        )
        Text(text = "kalyan")
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Android", modifier = Modifier
                .clickable {

                }
                .border(
                    3.dp, Color.Green, CircleShape
                )
                .padding(10.dp)
        )
    }
}