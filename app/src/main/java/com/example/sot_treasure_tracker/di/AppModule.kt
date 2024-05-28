package com.example.sot_treasure_tracker.di

import com.example.sot_treasure_tracker.data.treasure.TreasureCatalogInstance
import com.example.sot_treasure_tracker.data.CatalogStorage
import com.example.sot_treasure_tracker.data.presets.PresetsCatalogInstance
import com.example.sot_treasure_tracker.data.RepositoryImpl
import com.example.sot_treasure_tracker.domain.Repository
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
    fun provideCatalogStorage(): CatalogStorage {
        return object : CatalogStorage {
            override val treasureCatalog = TreasureCatalogInstance
            override val presetCatalog = PresetsCatalogInstance
        }
    }

    @Provides
    @Singleton
    fun provideRepository(catalogStorage: CatalogStorage): Repository {
        return RepositoryImpl(catalogStorage)
    }
}