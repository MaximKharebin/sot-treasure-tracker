package com.example.sot_treasure_tracker.di

import com.example.sot_treasure_tracker.data.TreasureRepositoryImpl
import com.example.sot_treasure_tracker.data.TreasureCatalog
import com.example.sot_treasure_tracker.data.treasure.TreasureCatalogInstance
import com.example.sot_treasure_tracker.domain.TreasureRepository
import com.example.sot_treasure_tracker.data.PresetsCatalog
import com.example.sot_treasure_tracker.data.presets.PresetsCatalogInstance
import com.example.sot_treasure_tracker.data.PresetsRepositoryImpl
import com.example.sot_treasure_tracker.domain.PresetsRepository
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