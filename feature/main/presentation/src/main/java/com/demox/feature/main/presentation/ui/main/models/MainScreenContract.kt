package com.demox.feature.main.presentation.ui.main.models

import com.demox.feature.main.domain.models.CurrentWeatherData

class MainScreenContract {
    data class State(
        val currentWeather: CurrentWeatherData? = null,
        val loading: Boolean = true,
        val scrollPosition: Int = 0,
        val showError: Boolean = false,
        val error: String? = null,
    )

    sealed class Effect {

    }

    sealed class Event {
        class ShowError(
            val show: Boolean = true,
            val error: String? = null,
        ) : Event()

        class HiddenError(
            val show: Boolean = false,
            val error: String? = null,
        ) : Event()

        class ChangeLoadingState(
            val loadingState: Boolean,
        ) : Event()

        class Update : Event()

        class DateUpdated(
            val currentWeather: CurrentWeatherData? = null,
            val loading: Boolean = false,
        ) : Event()
    }
}