package com.example.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learnjetpackcompose_1.nagavition.Screen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Home") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Row {
                Text(text = "Xin chào",
                    fontSize = 24.sp,
                    color = Color.Blue,
                    fontStyle = FontStyle.Italic
                    )

                    
                }
            Button(onClick = {
                navController.navigate(Screen.Detail.route)
            })
            {
                Text(text = "click me")
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Review() {
    val fakeNavController = rememberNavController()
    HomeScreen(navController = fakeNavController)
}
