package com.example.callapi

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.example.callapi.Model.Song
import com.example.callapi.ui.theme.CallAPITheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CallAPITheme {
                Scaffold {
                    SongScreen()
                }
            }
        }
    }
}

@Composable
fun SongScreen(viewModel: SongViewModel = SongViewModel()) {
    val state = viewModel.state.collectAsState()

    when (val result = state.value) {
        is SongState.Loading -> LoadingScreen()
        is SongState.Success -> SongList(songs = result.songs)
        is SongState.Error -> Text(text = result.message, modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun SongList(songs: List<Song>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(songs) { song ->
            SongItem(song)
        }
    }
}


@Composable
fun SongItem(song: Song) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Row {
                LoadImage(url = song.image)
                Spacer(modifier = Modifier.width(12.dp))
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = song.title,
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Black
                    )

                    Text(
                        text = song.artist,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }
        }
    }
}

@Composable
fun LoadImage(url: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .build(),
        placeholder = painterResource(R.drawable.song_default),
        error = painterResource(R.drawable.song_default),
        contentDescription = "Ảnh tải từ mạng",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .width(50.dp)
            .height(50.dp)
            .clip(RoundedCornerShape(6.dp))
    )
}

@Composable
fun LoadingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator( // Hiệu ứng vòng tròn loading
            modifier = Modifier.size(50.dp),
            color = MaterialTheme.colorScheme.primary,
            strokeWidth = 4.dp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "MeeMusic đang tải dữ liệu...",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Gray
        )
    }
}

fun clickSong(song: Song) {
    Log.d("MainActivity", "clickSong: ${song.title}")
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    CallAPITheme {
        SongItem(song = Song("1", "Hello", "Album", "Adele", "source", "image", 100, false, 0, 0))
    }
}

