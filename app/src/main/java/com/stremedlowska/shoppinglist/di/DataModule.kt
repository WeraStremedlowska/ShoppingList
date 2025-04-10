package com.stremedlowska.shoppinglist.di

import android.app.Application
import com.stremedlowska.shoppinglist.data.AppDatabase
import com.stremedlowska.shoppinglist.data.ShopListDao
import com.stremedlowska.shoppinglist.data.ShopListRepositoryImpl
import com.stremedlowska.shoppinglist.domain.ShopListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    
    @ApplicationScope
    @Binds
    fun bindShopListRepository(impl: ShopListRepositoryImpl): ShopListRepository
    
    companion object {
        
        @ApplicationScope
        @Provides
        fun provideShopListDao(
            application: Application
        ): ShopListDao {
            return AppDatabase.getInstance(application).shopListDao()
        }
    }
}