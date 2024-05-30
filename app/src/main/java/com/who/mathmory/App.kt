package com.who.mathmory

import android.app.Application
import com.who.mathmory.data.MainDb

class App : Application() {
    val database by lazy { MainDb.createDataBase(this) }
}