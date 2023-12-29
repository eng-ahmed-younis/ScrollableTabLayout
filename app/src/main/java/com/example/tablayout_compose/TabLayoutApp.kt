package com.example.tablayout_compose

import android.app.Application
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

class TabLayoutApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoinDI()
    }


    override fun onTerminate() {
        super.onTerminate()
        stopKoin()
    }

}


fun startKoinDI(){
    startKoin {
        androidLogger()
        modules(
            mainViewModelModule
        )

    }
}

val mainViewModelModule = module {
    viewModelOf(::MainViewModel)
}