package com.example.composedemo.ui_blocks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composedemo.R

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ComposeCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight(Alignment.Top)
            .padding(10.dp)
            .border(1.dp, Color.LightGray), shape = RoundedCornerShape(10.dp),
        shadowElevation = 3.dp
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.2f)
                    .background(Color.Green)
                    .weight(0.2f),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ImageCompose()
                TextCompose("ABC")
                TextCompose("DEF")
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .weight(0.8f), verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TextCompose("Sai Kalyan Android", padding = 5)
                TextCompose("Compose", padding = 5)
                TextCompose("Kotlin", padding = 5)
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(1.0f),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BorderCircledText("Sai", 0.3f, 12, 5)
                    TextCompose("Compose", 0.3f, 12, 5)
                    Column(
                        modifier = Modifier.fillMaxWidth(0.3f),
                        horizontalAlignment = Alignment.End
                    ) {
                        TextCompose("Kotlin", 1f, 12, 0)
                        Spacer(modifier = Modifier.height(2.dp))
                        TextCompose("Studio", 1f, 12, 0)
                    }
                }
            }

        }
    }
}

@Composable
fun ImageCompose() {
    Box(
        modifier = Modifier
            .width(100.dp)
            .height(80.dp)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter = painterResource(R.drawable.pins_53)
        Image(
            painter = painter,
            contentDescription = "MY_IMAGE",
            contentScale = ContentScale.Inside
        )
    }
}

@Composable
fun TextCompose(content: String, width: Float = 1.0f, size: Int = 20, padding: Int = 10) {
    Text(
        text = content,
        color = Color.Red, textAlign = TextAlign.Center,
        fontSize = size.sp,
        modifier = Modifier
            .fillMaxWidth(width)
            .padding(padding.dp)
    )
}


@Composable
fun BorderCircledText(content: String, width: Float = 1.0f, size: Int = 20, padding: Int = 10) {
    Text(
        text = content,
        color = Color.Red, textAlign = TextAlign.Center,
        fontSize = size.sp,
        modifier = Modifier
            .fillMaxWidth(width)
            .padding(padding.dp)
            .drawBehind {
                drawCircle(Color.Yellow, radius = this.size.minDimension)
            }
    )
}