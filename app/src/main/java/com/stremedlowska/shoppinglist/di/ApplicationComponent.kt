package com.stremedlowska.shoppinglist.di

import android.app.Application
import com.stremedlowska.shoppinglist.presentation.MainActivity
import com.stremedlowska.shoppinglist.presentation.ShopItemFragment
import com.stremedlowska.shoppinglist.presentation.ShopListApp
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class,
    ]
)
interface ApplicationComponent {
    
    fun inject(mainActivity: MainActivity)
    
    fun inject(fragment: ShopItemFragment)
    
    fun inject(application: ShopListApp)
    
    @Component.Factory
    interface Factory {
        
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}