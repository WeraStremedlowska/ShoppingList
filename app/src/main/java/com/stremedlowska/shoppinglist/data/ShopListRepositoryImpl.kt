package com.stremedlowska.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.stremedlowska.shoppinglist.domain.ShopItem
import com.stremedlowska.shoppinglist.domain.ShopListRepository
import javax.inject.Inject

class ShopListRepositoryImpl @Inject constructor(
    private val shopListDao: ShopListDao,
    private val mapper: ShopListMapper
) : ShopListRepository {
    
    override suspend fun addShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }
    
    override suspend fun deleteShopItem(shopItemId: Int) {
        shopListDao.deleteShopItem(shopItemId)
    }
    
    override suspend fun editShopItem(shopItem: ShopItem) {
        shopListDao.addShopItem(mapper.mapEntityToDbModel(shopItem))
    }
    
    override suspend fun getShopItem(shopItemId: Int): ShopItem {
        val dbModel = shopListDao.getShopItem(shopItemId)
        return mapper.mapDbModelToEntity(dbModel)
    }
    
    override fun getShopList(): LiveData<List<ShopItem>> =
        shopListDao.getShopList().map {
            mapper.mapListDbModelToListEntity(it)
        }
}