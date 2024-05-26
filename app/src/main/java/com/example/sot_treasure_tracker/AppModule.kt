package com.example.sot_treasure_tracker

import com.example.sot_treasure_tracker.components.data.TreasureRepositoryImpl
import com.example.sot_treasure_tracker.components.data.TreasureCatalog
import com.example.sot_treasure_tracker.components.data.TreasureCatalogInstance
import com.example.sot_treasure_tracker.components.domain.TreasureRepository
import com.example.sot_treasure_tracker.presets.data.PresetsCatalog
import com.example.sot_treasure_tracker.presets.data.PresetsCatalogInstance
import com.example.sot_treasure_tracker.presets.data.PresetsRepositoryImpl
import com.example.sot_treasure_tracker.presets.domain.PresetsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTreasureCatalog(): TreasureCatalog {
        return object : TreasureCatalog {
            override val catalog = TreasureCatalogInstance
        }
    }

    @Provides
    @Singleton
    fun provideTreasureRepository(treasureCatalog: TreasureCatalog): TreasureRepository {
        return TreasureRepositoryImpl(treasureCatalog)
    }

    @Provides
    @Singleton
    fun providePresetCatalog(): PresetsCatalog {
        return object : PresetsCatalog {
            override val catalog = PresetsCatalogInstance
        }
    }

    @Provides
    @Singleton
    fun providePresetRepository(presetsCatalog: PresetsCatalog): PresetsRepository {
        return PresetsRepositoryImpl(presetsCatalog)
    }
}