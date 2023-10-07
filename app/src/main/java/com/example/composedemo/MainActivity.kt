package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui_blocks.ComposeCard
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
private fun MainScreen() {
    ComposeDemoTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.surface
        ) {
            ComposeCard()
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
            color = MaterialTheme.colorScheme.surface,
            shadowElevation = 3.dp,
            shape = RoundedCornerShape(7.dp)
        ) {
            ConstraintComposeCard()
        }
    }
}
