package com.example.composedemo

import android.graphics.drawable.shapes.Shape
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel by viewModels<MyViewModel> ()
        setContent {
            StateChangeV3(viewModel = viewModel)
        }
    }
}

/*
   surface= portion/blocker on screen.
 */
@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreen() {
    Surface(
        color = Color.Green, modifier = Modifier.fillMaxSize()
    ) {
        Surface(
            modifier = Modifier.wrapContentSize(align = Alignment.TopCenter), color = Color.Yellow
        ) {
            Column {
                Text(
                    text = "Sai kalyan",
                    color = Color.Blue,
                    style = MaterialTheme.typography.headlineSmall
                )

                Text(
                    text = "Android",
                    color = Color.Blue,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

//---------------------------
@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun StateChangeV1() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        DisplayListV1()
    }
}

val list = listOf<String>("abc", "def")

@Composable
fun DisplayList() {
    var data by remember {
        mutableStateOf(list)
    }
    for (item in data) {
        Text(text = item)
    }
    Button(onClick = {
        data = data.toMutableList().apply { add("kalyan") }
    }) {
        Text(text = "Add Text")
    }
}

@Composable
fun DisplayListV1() {
    var data = remember {
        mutableStateListOf("abc")
    }
    for (item in data) {
        Text(text = item)
    }
    Button(onClick = {
        data.add("kalyan")
    }) {
        Text(text = "Add Text")
    }
}

//--------------------------------------- uplift state to outer composable----
@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun StateChangeV2() {
    val data = remember {
        mutableStateListOf("abc")
    }
    var editText by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        DisplayListV2(data, editText, {
            editText = it
        }) {
            if (editText.isNotBlank()) {
                data.add(editText)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayListV2(
    data: List<String>, editTextValue: String, editTextChange: (String) -> Unit, click: () -> Unit
) {
    for (item in data) {
        Text(text = item)
    }
    TextField(value = editTextValue, onValueChange = editTextChange)
    Button(onClick = click) {
        Text(text = "Add Text V2")
    }
}

//--------------------------------------- uplift state to view model----


@Composable
private fun StateChangeV3(viewModel: MyViewModel) {
    val data by viewModel.currentData.observeAsState(mutableListOf())
    val editText by viewModel.textFieldState.observeAsState("")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        DisplayListV3(data, editText, {
            viewModel.setTextField(it)
        }) {
            if (editText.isNotBlank()) {
                 viewModel.updateList(editText)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayListV3(
    data: MutableList<String>,
    editTextValue: String,
    editTextChange: (String) -> Unit,
    click: () -> Unit
) {
    for (item in data) {
        Text(text = item)
    }
    TextField(value = editTextValue, onValueChange = editTextChange)
    Button(onClick = click) {
        Text(text = "Add Text V2")
    }
}