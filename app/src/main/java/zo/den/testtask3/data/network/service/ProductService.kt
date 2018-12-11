package zo.den.testtask3.data.network.service

import io.reactivex.Single
import retrofit2.http.GET
import zo.den.testtask3.data.network.pojo.Product

interface ProductService {
    @GET("vk6qe")
    fun getProducts():Single<MutableList<Product>>
}