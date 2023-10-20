package com.example.sot_treasure_tracker.data

import com.example.sot_treasure_tracker.data.storage.AthenaFortuneStorage
import com.example.sot_treasure_tracker.data.storage.GoldHoardersStorage
import com.example.sot_treasure_tracker.data.storage.MerchantAllianceStorage
import com.example.sot_treasure_tracker.data.storage.OrderOfSoulsStorage
import com.example.sot_treasure_tracker.data.storage.OtherStorage

object TreasureStorage {
    val goldHoardersStorage = GoldHoardersStorage.treasure
    val merchantAllianceStorage = MerchantAllianceStorage.treasure
    val orderOfSoulsStorage = OrderOfSoulsStorage.treasure
    val athenaFortuneStorage = AthenaFortuneStorage.treasure
    val otherStorage = OtherStorage.treasure
}
