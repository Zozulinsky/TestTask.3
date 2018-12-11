package zo.den.testtask3.data.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import zo.den.testtask3.data.DataQualifier
import zo.den.testtask3.data.network.service.ImageService
import zo.den.testtask3.data.network.service.ProductService

@Module
class ProductServiceModule {

    @Provides
    @DataQualifier("baseURL")
    fun provideBaseUrl(): String = ""

    @Provides
    fun provideProductService(@DataQualifier("baseURL") baseUrl: String, okHttpClient: OkHttpClient): ProductService{
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.myjson.com/bins/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ProductService::class.java)
    }
    /*
    @Provides
    fun provideImageService(okHttpClient: OkHttpClient): ImageService {
        return Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ImageService::class.java)
    }

*/
}