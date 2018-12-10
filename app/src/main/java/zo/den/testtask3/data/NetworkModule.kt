package zo.den.testtask3.data

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import zo.den.testtask3.data.network.ProductServiceModule
import javax.inject.Singleton

@Module(includes = [ProductServiceModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
}