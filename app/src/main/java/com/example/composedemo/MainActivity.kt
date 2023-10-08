package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui_blocks.ConstraintComposeCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenV2()
        }
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreenV2() {
    ComposeDemoTheme {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(Alignment.Top)
                .padding(10.dp),
            color = MaterialTheme.colorScheme.surface
        ) {
            LazyColumn() {
                items(count = 15) {
                    ConstraintComposeCard()
                }
            }
        }
    }
}
