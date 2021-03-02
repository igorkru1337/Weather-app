package com.example.weatherapp

class LiveEvent : SingleLiveEvent<Unit>(){

    operator fun invoke(){
        this.value = Unit
    }
}