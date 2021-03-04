package com.example.weatherapp.presentation

import com.example.weatherapp.presentation.SingleLiveEvent

class LiveEvent : SingleLiveEvent<Unit>(){

    operator fun invoke(){
        this.value = Unit
    }
}