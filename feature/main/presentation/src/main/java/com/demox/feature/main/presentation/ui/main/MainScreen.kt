package com.demox.feature.main.presentation.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.demox.core.presentation.ui.AlertDialog
import com.demox.feature.main.presentation.ui.main.models.MainScreenContract
import com.demox.feature.main.presentation.ui.main.ui.WeatherUIItems

@Composable
fun MainScreen(navController: NavHostController) {
    val viewModel: MainScreenViewModel  = hiltViewModel()
    val screenState by viewModel.viewStates().collectAsState()

        MainScreenContent(
            screenState = screenState,
            eventHandler = viewModel::obtainEvent)


}

@Composable
fun MainScreenContent(
    screenState: MainScreenContract.State,
    eventHandler: (MainScreenContract.Event) -> Unit,
    ){

        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { paddingValues ->
            WeatherUIItems(
                paddingValues = paddingValues,
                isRefreshing = screenState.loading,
                onRefresh = { eventHandler(MainScreenContract.Event.Update()) },
                currentWeather = screenState.currentWeather
            )

        }

        if (screenState.showError){
            AlertDialog(message = screenState.error.toString(),
                closeDialog = {eventHandler(MainScreenContract.Event.ShowError(show = false,error = null)) })
        }
    }
