package axons.forfarm.catproject.di

import android.content.Context
import android.content.res.Resources
import axons.forfarm.catproject.domain.remote.TheCatApi
import axons.forfarm.catproject.domain.remote.TheCatFactApi
import axons.forfarm.catproject.utils.DISPATCHERS_DEFAULT
import axons.forfarm.catproject.utils.DISPATCHERS_IO
import axons.forfarm.catproject.utils.DISPATCHERS_MAIN
import axons.forfarm.catproject.utils.DISPATCHERS_UNCONFINED
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideTheCatApi(): TheCatApi {
        return Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheCatApi::class.java)
    }
    //create url new line
    @Provides
    @Singleton
    fun provideTheCatFactApi(): TheCatFactApi {
        return Retrofit.Builder()
            .baseUrl("https://catfact.ninja")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TheCatFactApi::class.java)
    }


    @Provides
    @Singleton
    @Named(DISPATCHERS_DEFAULT)
    fun provideDefaultCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.Default
    }

    @Provides
    @Singleton
    @Named(DISPATCHERS_MAIN)
    fun provideMainCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.Main
    }

    @Provides
    @Singleton
    @Named(DISPATCHERS_IO)
    fun provideIOCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    @Singleton
    @Named(DISPATCHERS_UNCONFINED)
    fun provideUnconfinedCoroutineDispatcher(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }

    @Provides
    @Singleton
    fun provideResources(@ApplicationContext app: Context): Resources {
        return app.resources
    }
}