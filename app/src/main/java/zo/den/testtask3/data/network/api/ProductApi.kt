package zo.den.testtask3.data.network.api

import io.reactivex.Single
import zo.den.testtask3.data.network.pojo.Product
import zo.den.testtask3.data.network.service.ProductService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductApi @Inject constructor(private val productService: ProductService) {
    fun getProducts(): Single<MutableList<Product>>{
        return productService.getProducts()
    }

}