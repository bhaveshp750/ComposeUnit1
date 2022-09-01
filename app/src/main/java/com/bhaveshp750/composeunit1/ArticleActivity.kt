package com.bhaveshp750.composeunit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhaveshp750.composeunit1.ui.theme.ComposeUnit1Theme

class ArticleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val actionName = intent.getStringExtra("name")
            ComposeUnit1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    if (actionName.equals("Article"))
                        ArticleMainLayout()
                    else if (actionName.equals("TaskManager"))
                        TaskManagerMainLayout()
                    else if (actionName.equals("Quadrant"))
                        QuadrantMainLayout()

                }
            }
        }
    }
}


@Composable
fun ArticleMainLayout() {
    val image = painterResource(id = R.drawable.top_banner)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
        )
        MyTextLayout()
    }
}

@Composable
fun MyTextLayout() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(align = Alignment.CenterHorizontally)
    ) {
        Text(
            text = "Jetpack Compose tutorial",
            fontSize = 26.sp,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.Start)
                .padding(all = 16.dp)
        )
        Text(
            text = "Jetpack Compose is a modern toolkit for" +
                    "building native Android Ul. Compose" +
                    "simplifies and accelerates Ul development on" +
                    "Android with less code, powerful tools, and" +
                    "intuitive Kotlin APls.",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = "On this tutorial, you build a simple UI" +
                    "component with declarative functions. You" +
                    "call Compose functions to say what elements" +
                    "you want and the Compose compiler does the" +
                    "fest. Compose is built around Composable" +
                    "functions. These functions let you define your" +
                    "app's UI programmatically because they let" +
                    "you describe how it should look and provide" +
                    "data dependencies, rather than focus on the" +
                    "process of the UI's construction, such as" +
                    "initializing an element and then attaching it to" +
                    "a parent. To create a Composable function," +
                    "you add the @Composable annotation to the" +
                    "function name.",
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxWidth()
                .padding(all = 16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Composable
fun TaskManagerMainLayout() {
    val image = painterResource(id = R.drawable.ic_task_completed)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentHeight(align = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = "All tasks completed",
            fontSize = 24.sp,
            modifier = Modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = "Nice work!",
            fontSize = 16.sp,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
    }
}

@Composable
fun QuadrantMainLayout() {
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            EachQuadrantLayout(
                title = "Text composable",
                description = "Displays text and follows Material Design guidelines.",
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            EachQuadrantLayout(
                title = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            EachQuadrantLayout(
                title = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            EachQuadrantLayout(
                title = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun EachQuadrantLayout(
    title: String,
    description: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeUnit1Theme {
        QuadrantMainLayout()
    }
}