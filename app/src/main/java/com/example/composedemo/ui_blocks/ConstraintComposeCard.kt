package com.example.composedemo.ui_blocks

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.composedemo.R

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ConstraintComposeCard() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .wrapContentHeight(align = Alignment.Top)
            .padding(10.dp)
    ) {

        val (imageRef, textView1, textView2, textView3, textView4, textView5, textView6, textView7, textView8,
            textView9) = createRefs()
        val painter = painterResource(R.drawable.pins_53)
        Image(
            painter = painter,
            contentDescription = "MY_IMAGE",
            contentScale = ContentScale.Fit, modifier = Modifier
                .fillMaxWidth(0.2f)
                .background(Color.Green)
                .height(100.dp)
                .constrainAs(imageRef) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start)
                }
        )
        TextComposeV2(content = "ABC", modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight()
            .constrainAs(textView1) {
                top.linkTo(imageRef.bottom, margin = 10.dp)
                start.linkTo(imageRef.start)
                end.linkTo(imageRef.end)
            })
        TextComposeV2(content = "DEF", modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight()
            .constrainAs(textView2) {
                top.linkTo(textView1.bottom, margin = 10.dp)
                start.linkTo(textView1.start)
                end.linkTo(textView1.end)
            })

        TextComposeV2(content = "Sai Kalyan Android", modifier = Modifier
            .fillMaxWidth(0.8f)
            .wrapContentHeight()
            .constrainAs(textView3) {
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(imageRef.end)
                end.linkTo(parent.end)
            })

        TextComposeV2(content = "Compose", modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight()
            .constrainAs(textView4) {
                top.linkTo(textView3.bottom, margin = 10.dp)
                start.linkTo(textView3.start)
                end.linkTo(textView3.end)
            })
        TextComposeV2(content = "Kotlin", modifier = Modifier
            .fillMaxWidth(1f)
            .wrapContentHeight()
            .constrainAs(textView5) {
                top.linkTo(textView4.bottom, margin = 10.dp)
                start.linkTo(textView4.start)
                end.linkTo(textView4.end)
            })

        BorderCircledTextV2(content = "Sai", modifier = Modifier
            .wrapContentHeight()
            .constrainAs(textView6) {
                top.linkTo(textView5.bottom, margin = 20.dp)
                start.linkTo(imageRef.end, margin = 30.dp)
            }
            .drawBehind {
                drawCircle(Color.Yellow, radius = this.size.minDimension)
            })
        TextComposeV2(content = "Compose", modifier = Modifier
            .wrapContentHeight()
            .constrainAs(textView7) {
                top.linkTo(textView6.top)
                start.linkTo(textView6.end, margin = 20.dp)
                end.linkTo(textView8.start)
            })
        TextComposeV2(content = "Kotlin", modifier = Modifier
            .wrapContentHeight()
            .constrainAs(textView8) {
                top.linkTo(textView6.top)
                start.linkTo(textView7.end, margin = 20.dp)
                end.linkTo(parent.end)
            })
        TextComposeV2(content = "Studio", modifier = Modifier
            .wrapContentHeight()
            .constrainAs(textView9) {
                top.linkTo(textView8.bottom, margin = 5.dp)
                start.linkTo(textView8.start)
            })

    }
}

@Composable
fun TextComposeV2(
    content: String,
    size: Int = 20,
    modifier: Modifier
) {
    Text(
        text = content,
        color = Color.Red, textAlign = TextAlign.Center,
        fontSize = size.sp, fontFamily = FontFamily.SansSerif,
        modifier = modifier
    )
}

@Composable
fun BorderCircledTextV2(
    content: String,
    size: Int = 20,
    modifier: Modifier
) {
    Text(
        text = content,
        color = Color.Red, textAlign = TextAlign.Center,
        fontSize = size.sp,
        modifier = modifier
    )
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ChainComposeCard() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top)
            .padding(10.dp)
    ) {

        val (imageRef, textView1, textView2) = createRefs()
        val chain =
            createVerticalChain(imageRef, textView1, textView2, chainStyle = ChainStyle.Spread)
        val painter = painterResource(R.drawable.pins_53)
        Image(
            painter = painter,
            contentDescription = "MY_IMAGE",
            contentScale = ContentScale.Fit, modifier = Modifier
                .fillMaxWidth(0.2f)
                .background(Color.Green)
                .height(100.dp)
                .constrainAs(imageRef) {

                }
        )
        TextComposeV2(content = "ABC", modifier = Modifier
            .wrapContentHeight()
            .constrainAs(textView1) {

            })
        TextComposeV2(content = "DEF", modifier = Modifier
            .wrapContentHeight()
            .constrainAs(textView2) {

            })

    }
}