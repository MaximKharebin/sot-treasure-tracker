package com.example.sot_treasure_tracker.data

import com.example.sot_treasure_tracker.data.storage.AthenaFortuneStorage
import com.example.sot_treasure_tracker.data.storage.GoldHoardersStorage
import com.example.sot_treasure_tracker.data.storage.MerchantAllianceStorage
import com.example.sot_treasure_tracker.data.storage.OrderOfSoulsStorage
import com.example.sot_treasure_tracker.data.storage.OtherStorage
import com.example.sot_treasure_tracker.data.storage.ReapersBonesStorage

object TreasureStorage {
    val storage = listOf(
        GoldHoardersStorage.treasure,
        MerchantAllianceStorage.treasure,
        OrderOfSoulsStorage.treasure,
        AthenaFortuneStorage.treasure,
        ReapersBonesStorage.treasure,
        OtherStorage.treasure
    )
}
