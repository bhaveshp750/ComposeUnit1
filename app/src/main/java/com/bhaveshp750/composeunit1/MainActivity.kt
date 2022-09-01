package com.bhaveshp750.composeunit1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhaveshp750.composeunit1.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BirthdayGreetingWithImage("Happy Birthday Dada!", "-Bhavesh")
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String) {
    val image = painterResource(id = R.drawable.androidparty)
    Box {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(message = message, from = from)
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String) {
    Column {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(start = 16.dp, top = 16.dp)
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(start = 16.dp, end = 16.dp)
        )
        Row(modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(align = Alignment.CenterHorizontally)
        ) {
            val context = LocalContext.current
            Button(onClick = {
                val intent = Intent(context, ArticleActivity::class.java)
                intent.putExtra("name", "Article")
                context.startActivity(intent)
            }, modifier = Modifier.padding(all = 4.dp)) {
                Text(text = "Article")
            }
            Button(onClick = {
                val intent = Intent(context, ArticleActivity::class.java)
                intent.putExtra("name", "TaskManager")
                context.startActivity(intent)
            }, modifier = Modifier.padding(all = 4.dp)) {
                Text(text = "TaskManager")
            }
            Button(onClick = {
                val intent = Intent(context, ArticleActivity::class.java)
                intent.putExtra("name", "Quadrant")
                context.startActivity(intent)
            }, modifier = Modifier.padding(all = 4.dp)) {
                Text(text = "Quadrant")
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithImagePreview() {
    HappyBirthdayTheme {
        BirthdayGreetingWithImage(stringResource(R.string.happy_birthday_text), stringResource(R.string.from_text))
    }
}