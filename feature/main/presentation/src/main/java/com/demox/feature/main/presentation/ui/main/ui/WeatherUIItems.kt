package com.demox.feature.main.presentation.ui.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.Indicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.demox.feature.main.domain.models.CurrentWeatherData

@Composable
fun WeatherUIItems(
    paddingValues: PaddingValues,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
    currentWeather: CurrentWeatherData?,
){
    val state = rememberPullToRefreshState()
    val verticalScrollState = rememberScrollState()

    PullToRefreshBox(
        modifier = Modifier.fillMaxSize(),
        isRefreshing = isRefreshing,
        onRefresh = onRefresh,
        state = state,
        indicator = {
            Indicator(
                modifier = Modifier.align(Alignment.Center)
                    .padding(paddingValues),
                isRefreshing = isRefreshing,
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                state = state
            )
        },
    ) {

        if (currentWeather == null && isRefreshing.not()) {
            Box(
                modifier = Modifier.fillMaxSize()
                    .padding(horizontal = 6.dp, vertical = 10.dp)
                    .verticalScroll(verticalScrollState),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Не удалось получить данные.\n" +
                            "Проверте интернет соединение и повторите заново.",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }else {

            Column(
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 10.dp)
                    .fillMaxSize()
                    .verticalScroll(verticalScrollState)
            ) {
                currentWeather?.let {
                    LocationUI(locationData = currentWeather.locationData)
                    Spacer(modifier = Modifier.height(10.dp))
                    CurrentWeatherUI(
                        currentData = currentWeather.currentData
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Восход:${currentWeather.astroData.sunrise}  Закат:${currentWeather.astroData.sunset}")
                    Spacer(modifier = Modifier.height(10.dp))
                    HourUI(hoursData = currentWeather.hoursData)
                    Spacer(modifier = Modifier.height(10.dp))
                    currentWeather.daysData.forEach {
                        DayUI(
                            dayData = it
                        )
                    }
                }


            }

        }
    }

}