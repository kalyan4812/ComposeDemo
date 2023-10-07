package com.example.composedemo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreenV4(viewModel)
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreen() {
    val counter = remember {
        mutableStateOf(0)
    }
    val increment = {
        counter.value = counter.value + 1
    }
    val decrement = {
        counter.value = counter.value - 1
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { decrement.invoke() }) {
            Text(text = "Minus", color = Color.Green)
        }
        Text(text = "${counter.value}")
        Button(onClick = { increment.invoke() }) {
            Text(text = "Plus", color = Color.Green)
        }
    }
}


@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreenV2() {
    var counter by remember {
        mutableIntStateOf(0)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { counter-- }) {
            Text(text = "Minus", color = Color.Green)
        }
        Text(text = "$counter")
        Button(onClick = { counter++ }) {
            Text(text = "Plus", color = Color.Green)
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreenV3() {
    var counter by rememberSaveable {
        mutableIntStateOf(0)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { counter-- }) {
            Text(text = "Minus", color = Color.Green)
        }
        Text(text = "$counter")
        Button(onClick = { counter++ }) {
            Text(text = "Plus", color = Color.Green)
        }
    }
}
/*
  rememberSavable - survive from configuration changes.
 */

@Composable
private fun MainScreenV4(viewModel: MainViewModel) {
    val counter by viewModel.observeCounter().observeAsState(0)
    Toast.makeText(LocalContext.current, "MainScreenV4 called", Toast.LENGTH_SHORT).show()
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = { viewModel.decrementCounter() }) {
            Text(text = "Minus", color = Color.Green)
        }
        Text(text = "$counter")
        Button(onClick = { viewModel.incrementCounter() }) {
            Text(text = "Plus", color = Color.Green)
        }
    }
}