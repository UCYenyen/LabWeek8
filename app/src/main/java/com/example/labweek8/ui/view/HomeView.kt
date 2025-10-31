package com.example.labweek8.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.labweek8.R
import com.example.labweek8.ui.view.components.SearchBar
import com.example.labweek8.ui.uistates.HomeUiState
import com.example.labweek8.ui.view.components.WeatherErrorView
import com.example.labweek8.ui.view.components.WeatherInitialView
import com.example.labweek8.ui.view.components.WeatherSuccessView
import com.example.labweek8.ui.viewmodel.HomeViewModel

@Composable
fun HomeView(
    homeViewModel: HomeViewModel = viewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()
    val searchText by homeViewModel.searchText.collectAsState()

    Image(
        painter = painterResource(R.drawable.weather___home_2),
        contentDescription = "Background",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 14.dp)
    ) {
        SearchBar(
            text = searchText,
            onTextChange = homeViewModel::onSearchTextChange,
            onSearchClick = homeViewModel::getWeather,
            hint = "Enter city name",
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon"
                )
            },
            modifier = Modifier.padding(vertical = 8.dp)
        )

        when (val state = uiState) {
            is HomeUiState.Initial -> {
                WeatherInitialView()
            }
            is HomeUiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = Color.White)
                }
            }
            is HomeUiState.Error -> {
                WeatherErrorView(message = "HTTP 404 Not Found")
            }
            is HomeUiState.Success -> {
                WeatherSuccessView(data = state.data)
            }
        }
    }
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
private fun HomeViewPreview() {
    HomeView()
}