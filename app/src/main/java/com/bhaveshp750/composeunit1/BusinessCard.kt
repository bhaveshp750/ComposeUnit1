package com.bhaveshp750.composeunit1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bhaveshp750.composeunit1.ui.theme.ComposeUnit1Theme

class BusinessCard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeUnit1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardMainLayout(
                        "Bhavesh Patel",
                        "+91 (900) 837 4455",
                        "@BhaveshP",
                        "bhaveshp750@gmail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCardMainLayout(name: String, phone: String, developerId: String, emailId: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xff003a4a))
    ) {
        BusinessInfo(name)
        BusinessContactDetails(phone, developerId, emailId)
    }
}

@Composable
fun BusinessContactDetails(phone: String, developerId: String, emailId: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentHeight(align = Alignment.Bottom)
    ) {
        DetailItem(phone, Icons.Rounded.Phone, "Phone Icon")
        DetailItem(developerId, Icons.Rounded.Share, "Id Icon")
        DetailItem(emailId, Icons.Rounded.Email, "Email Icon")
        Spacer(modifier = Modifier.height(45.dp))
    }
}

@Composable
fun DetailItem(text: String, myIcon: ImageVector, iconDesc: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        Spacer(Modifier.width(50.dp))
        Icon(
            imageVector = myIcon,
            contentDescription = iconDesc,
            tint = Color(0xFF3ddc84),
            modifier = Modifier
                .padding(start = 30.dp)
        )
        Spacer(Modifier.width(30.dp))
        Text(
            text = text,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = null
        )

    }
}

@Composable
fun BusinessInfo(name: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .wrapContentHeight(align = Alignment.CenterVertically)
            .padding(bottom = 36.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "Business Logo",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .size(120.dp)
        )

        Text(
            text = name,
            fontSize = 48.sp,
            fontWeight = FontWeight.Light,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
        )

        Text(
            text = "Android Developer Extraordinaire",
            color = Color(0xFF3ddc84),
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 5.dp)
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .wrapContentHeight(align = Alignment.CenterVertically)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    ComposeUnit1Theme {
        BusinessCardMainLayout(
            "Bhavesh Patel",
            "+91 (900) 837 4455",
            "@BhaveshP",
            "bhaveshp750@gmail.com"
        )
    }
}