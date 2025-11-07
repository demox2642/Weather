@file:Suppress("ktlint:standard:no-wildcard-imports", "ktlint:standard:backing-property-naming")

package com.demox.core.presentation.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

const val SIDE_EFFECTS_KEY = "side-effects_key"

public abstract class BaseViewModel<State : Any, Effect, Event>(
    initialState: State,
) : ViewModel() {
    private val _viewStates = MutableStateFlow(initialState)

    public fun viewStates(): StateFlow<State> = _viewStates.asStateFlow()

    private val _effect: Channel<Effect> = Channel()
    val effect = _effect.receiveAsFlow()

    protected var viewState: State
        get() = _viewStates.value
        set(value) {
            _viewStates.value = value
        }


    public abstract fun obtainEvent(viewEvent: Event)


    protected fun setEffect(builder: () -> Effect) {
        val effectValue = builder()
        viewModelScope.launch {
            _effect.send(effectValue)
        }
    }
}
