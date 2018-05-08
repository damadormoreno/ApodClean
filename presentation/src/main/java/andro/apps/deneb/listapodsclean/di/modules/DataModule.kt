package andro.apps.deneb.listapodsclean.di.modules

import andro.apps.deneb.domain.ApodCache
import andro.apps.deneb.domain.ApodRepository
import andro.apps.deneb.listapodsclean.di.DI
import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import deneb.apps.andro.data.api.Api
import deneb.apps.andro.data.repositories.ApodRepositoryImpl
import javax.inject.Named
import javax.inject.Singleton

@Module
@Singleton
class DataModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(context: Context): ApodsDatabase {
        return Room.databaseBuilder(
                context,
                ApodsDatabase::class.java,
                "apods_db").build()
    }

    @Provides
    @Singleton
    fun provideApodRepository(api: Api,
                              @Named(DI.inMemoryCache) cache: ApodCache,
                              apodDataMapper: ApodDataEntityMapper): ApodRepository{
        return ApodRepositoryImpl(api, cache, apodDataMapper)
    }

}