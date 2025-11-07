package com.demox.feature.main.presentation.ui.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.demox.core.presentation.vm.BaseViewModel
import com.demox.feature.main.domain.usecase.GetWeatherCacheData
import com.demox.feature.main.domain.usecase.LoadDataUseCase
import com.demox.feature.main.presentation.ui.main.models.MainScreenContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val getWeatherCacheData: GetWeatherCacheData,
    private val loadDataUseCase: LoadDataUseCase
): BaseViewModel<MainScreenContract.State,MainScreenContract.Effect,MainScreenContract.Event>(initialState = MainScreenContract.State()) {

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, exception ->

            Log.e("MainScreenViewModel","ERROR: $exception")
            obtainEvent(MainScreenContract.Event.ShowError(
                show = true,
                error = exception.toString()
            ))
        }

    init {
        loadCacheData()
    }

    override fun obtainEvent(viewEvent: MainScreenContract.Event) {
        when(viewEvent){
            is MainScreenContract.Event.Update -> {
                loadDataFromSerer()
            }
            is MainScreenContract.Event.ShowError -> {
                viewState = viewState.copy(error = viewEvent.error, showError = viewEvent.show, loading = false)
            }
            is MainScreenContract.Event.HiddenError->{
                viewState = viewState.copy(error = viewEvent.error, showError = viewEvent.show, loading = false)
            }
            is MainScreenContract.Event.DateUpdated -> {
                viewState = viewState.copy(loading = false, currentWeather = viewEvent.currentWeather, showError = false, error = null)
            }
            is MainScreenContract.Event.ChangeLoadingState -> {
                viewState = viewState.copy(loading = viewEvent.loadingState)
            }
        }
    }

    private fun loadCacheData(){
        viewModelScope.launch(Dispatchers.IO) {
            supervisorScope {
                obtainEvent(MainScreenContract.Event.ChangeLoadingState(loadingState = true))

                launch(coroutineExceptionHandler) {
                    obtainEvent(MainScreenContract.Event.DateUpdated(
                        currentWeather = getWeatherCacheData.getWeatherCacheData()
                    )
                    )

                }
            }
        }
    }

    private fun loadDataFromSerer(){
        viewModelScope.launch(Dispatchers.IO) {
            supervisorScope {
                obtainEvent(MainScreenContract.Event.ChangeLoadingState(loadingState = true))
                launch(coroutineExceptionHandler) {
                    async { loadDataUseCase.loadData() }.await()
                    obtainEvent(MainScreenContract.Event.DateUpdated(
                        currentWeather = getWeatherCacheData.getWeatherCacheData()
                    )
                    )
                }
            }
        }
    }
}