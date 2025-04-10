package com.stremedlowska.shoppinglist.presentation

import android.app.Application
import com.stremedlowska.shoppinglist.di.DaggerApplicationComponent

class ShopListApp : Application() {
    
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}