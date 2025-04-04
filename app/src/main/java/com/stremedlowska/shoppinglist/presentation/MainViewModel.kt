package com.stremedlowska.shoppinglist.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.stremedlowska.shoppinglist.data.ShopListRepositoryImpl
import com.stremedlowska.shoppinglist.domain.DeleteShopItemUseCase
import com.stremedlowska.shoppinglist.domain.EditShopItemUseCase
import com.stremedlowska.shoppinglist.domain.GetShopListUseCase
import com.stremedlowska.shoppinglist.domain.ShopItem
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    
    private val repository = ShopListRepositoryImpl(application)
    
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    
    val shopList = getShopListUseCase.getShopList()
    
    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem.id)
        }
    }
    
    fun changeEnableState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(enabled = !shopItem.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}