package zo.den.testtask3.data.network.service

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import zo.den.testtask3.data.network.pojo.Product

interface ProductService {
    @GET("vk6qe")
    fun getProducts():Single<MutableList<Product>>

    @GET("{imageName}")
    fun getImage(@Path("imageName")imageName: String): Single<ResponseBody>

}