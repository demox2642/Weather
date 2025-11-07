package com.demox.weather

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demox.feature.main.domain.usecase.LoadDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase
): ViewModel() {
    private val _keepSplashOnScreen = MutableStateFlow(true)
    val keepSplashOnScreen = _keepSplashOnScreen.asStateFlow()

    private val coroutineExceptionHandler =
        CoroutineExceptionHandler { coroutineContext, exception ->

            Log.e("MainActivityViewModel","ERROR: $exception")
            _keepSplashOnScreen.value = false
        }

    init {
        viewModelScope.launch(Dispatchers.IO) {
            supervisorScope {
                launch(coroutineExceptionHandler){
                    async {
                        loadDataUseCase.loadData()
                    }.await()
                    _keepSplashOnScreen.value = false
                }
            }

        }
    }
}