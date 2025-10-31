package com.example.labweek8.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.labweek8.data.container.WeatherServerContainer
import com.example.labweek8.ui.uistates.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
class HomeViewModel: ViewModel(){
    private val repository = WeatherServerContainer().WeatherServerRepository
    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Initial)
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
    private val _searchText = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText.asStateFlow()

    fun onSearchTextChange(text: String) {
        _searchText.value = text
    }

    fun getWeather() {
        if (_searchText.value.isBlank()) return

        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            try {
                val result = repository.getWeatherByCity(_searchText.value)
                _uiState.value = HomeUiState.Success(result)
            } catch (e: Exception) {
                _uiState.value = HomeUiState.Error(e.message ?: "An unknown error occurred")
            }
        }
    }
}