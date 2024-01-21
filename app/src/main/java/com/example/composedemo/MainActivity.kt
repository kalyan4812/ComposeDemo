package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui.theme.lightGreen

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
   Scaffold - to add top bar and bottom bar
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true, showBackground = true, fontScale = 1F)
private fun MainScreen() {
    Scaffold(topBar = { ToolBar() }) { param ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = param.calculateTopPadding()),
            color = Color.Green
        ) {
            ProfileCard()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar() {
    TopAppBar(title = {
        Text(
            text = "Compose App", color = Color.Green, fontWeight = FontWeight.Bold
        )
    }, navigationIcon = {
        Icon(
            imageVector = Icons.Default.Home,
            tint = Color.Green,
            contentDescription = "ToolBarIcon",
            modifier = Modifier.padding(16.dp)
        )
    })
}

@Composable
fun ProfileCard() {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .wrapContentHeight(
                align = Alignment.Top
            ), elevation = CardDefaults.cardElevation(), colors = CardDefaults.cardColors(
            containerColor = Color.White
        ), shape = CutCornerShape(
            topEnd = 40.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProfileImageWithCoil()
            ProfileContent()
        }
    }
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Kalyan", style = MaterialTheme.typography.titleMedium)

        Text(
            text = "Active",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.alpha(0.6f)
        )

    }

}

@Composable
fun ProfileImage() {
    Card(
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(),
        border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.lightGreen),
        modifier = Modifier.padding(10.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "profileImage",
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun ProfileImageWithCoil() {
    Card(
        shape = CircleShape,
        elevation = CardDefaults.cardElevation(),
        border = BorderStroke(width = 3.dp, color = MaterialTheme.colorScheme.lightGreen),
        modifier = Modifier.padding(10.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = R.drawable.ic_launcher_foreground)
                    .apply(block = fun ImageRequest.Builder.() {
                        transformations(CircleCropTransformation())
                    }).build()
            ),
            contentDescription = "profileImage",
            modifier = Modifier.size(80.dp),
            contentScale = ContentScale.Crop
        )
    }
}
