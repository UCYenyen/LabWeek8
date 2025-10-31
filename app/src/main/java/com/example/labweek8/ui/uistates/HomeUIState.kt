package com.example.labweek8.ui.uistates
import com.example.labweek8.ui.model.WeatherItem

sealed interface HomeUiState {
    object Initial : HomeUiState
    object Loading : HomeUiState
    data class Success(val data: WeatherItem) : HomeUiState
    data class Error(val message: String) : HomeUiState
}