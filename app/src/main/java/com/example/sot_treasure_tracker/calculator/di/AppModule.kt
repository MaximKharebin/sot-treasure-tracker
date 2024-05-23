package com.example.sot_treasure_tracker.calculator.di

import com.example.sot_treasure_tracker.calculator.data.RepositoryImpl
import com.example.sot_treasure_tracker.calculator.data.TreasureCatalog
import com.example.sot_treasure_tracker.calculator.data.catalog_instance.TreasureCatalogInstance
import com.example.sot_treasure_tracker.calculator.domain.Repository
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
    fun provideRepository(treasureCatalog: TreasureCatalog): Repository {
        return RepositoryImpl(treasureCatalog)
    }
}