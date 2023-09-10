package com.dicoding.tourismapp.core.di.dagger

import android.content.Context
import androidx.room.Room
import com.dicoding.tourismapp.core.data.source.local.room.TourismDao
import com.dicoding.tourismapp.core.data.source.local.room.TourismDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(context: Context): TourismDatabase = Room.databaseBuilder(
        context,
        TourismDatabase::class.java,
        "Tourism.db"
    ).build()

    @Provides
    fun provideTourismDao(database: TourismDatabase): TourismDao = database.tourismDao()
}