package com.example.labweek8.ui.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.labweek8.R
import com.example.labweek8.data.container.WeatherServerContainer
import com.example.labweek8.ui.model.WeatherItem

@Composable
fun WeatherStatus(weatherData: WeatherItem) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(WeatherServerContainer.BASE_IMG_URL + "${weatherData.icon}@4x.png")
                        .crossfade(true)
                        .build(),
                    contentDescription = "weather icon",
                    modifier = Modifier.size(100.dp)
                )
                Text(
                    "Rain",
                    fontSize = 48.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.width(200.dp),
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    "28°C",
                    fontSize = 72.sp,
                    modifier = Modifier.width(200.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Image(
                painter = painterResource(R.drawable.blue_and_black_bold_typography_quote_poster_2),
                contentDescription = "Weather Status",
                contentScale = ContentScale.Fit,
            )
        }
    }
}