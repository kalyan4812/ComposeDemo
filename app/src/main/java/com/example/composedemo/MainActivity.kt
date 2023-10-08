package com.example.composedemo

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.composedemo.databinding.FragmentTest2Binding
import com.example.composedemo.ui_blocks.HorizontalDottedProgress

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeWithXml()
        }
    }
}


@Composable
fun ComposeWithXml() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Place your Compose content here
        Text(text = "Hello from Compose!")

        Spacer(modifier = Modifier.height(16.dp))
        XmlInCompose()
        Spacer(modifier = Modifier.height(16.dp))
        CustomViewCompose()
        Spacer(modifier = Modifier.height(16.dp))
        AndroidViewBindingExample()
    }
}

@Composable
fun XmlInCompose() {
    AndroidView(
        factory = { context ->
            val view =
                LayoutInflater.from(context).inflate(R.layout.fragment_test2, null, false)
            view // return the view
        },
        update = { view ->
            val textView = view.findViewById<TextView>(R.id.text)
            textView.text = "TEXT FROM COMPOSE...."
        }
    )
}

@Composable
fun CustomViewCompose() {
    AndroidView(factory = {
        HorizontalDottedProgress(it)
    }, update = {

    })
}

/*
    using xml in compose blocks...
 */

@Composable
fun AndroidViewBindingExample() {
    AndroidViewBinding(FragmentTest2Binding::inflate) {
        text.text = "TEXT FROM COMPOSE VIEW BINDING....."
    }
}

