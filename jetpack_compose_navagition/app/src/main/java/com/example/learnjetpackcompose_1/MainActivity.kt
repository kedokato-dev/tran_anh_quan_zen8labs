package com.example.learnjetpackcompose_1

import android.health.connect.datatypes.units.Length
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learnjetpackcompose_1.nagavition.AppNavGraph
import com.example.learnjetpackcompose_1.ui.theme.LearnJetpackCompose_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            AppNavGraph(navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(nav :NavController) {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Tìm kiếm",
                color = Color.Blue,
                fontSize = 40.sp,
                fontStyle = FontStyle.Italic,
                fontFamily = FontFamily.SansSerif,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        })
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                LoadImage()
                Spacer(modifier = Modifier.width(20.dp))
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = "Như anh đã thấy em",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                        ),
                        color = Color.Black,
                    )
                    Text(
                        text = "Tran Anh Quan",
                        style = androidx.compose.ui.text.TextStyle(
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            textAlign = TextAlign.Center,
                        ),
                        color = Color.Gray,
                    )
                    Button(onClick = {
                        nav.navigate("detail_screen")
                    }
                    ) {
                        Text(text = "Detail")
                    }
                }
            }
        }
    }
}


@Composable
fun LoadImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Hình ảnh bài hát",
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(80.dp)
            .border(2.dp, Color.Gray, RoundedCornerShape(12.dp))
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    LearnJetpackCompose_1Theme {
        val fakeNavController = rememberNavController() // Tạo NavController giả
        MainScreen(nav = fakeNavController)  // Truyền vào MainScreen
    }
}