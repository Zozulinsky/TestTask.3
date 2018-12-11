package zo.den.testtask3.data.network.api

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.reactivex.Single
import zo.den.testtask3.data.network.pojo.Product
import zo.den.testtask3.data.network.service.ImageService
import zo.den.testtask3.data.network.service.ProductService
import java.io.BufferedInputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductApi @Inject constructor(private val productService: ProductService/*, private val imageService: ImageService*/) {
    fun getProducts(): Single<MutableList<Product>>{
        return productService.getProducts()
    }
/*
    fun getImage(url: String): Single<Bitmap>{
        return imageService.getImage(url).map {
            val buffer = BufferedInputStream(it.byteStream())
            buffer.use { stream ->
                BitmapFactory.decodeStream(stream)
            }
        }
    }*/
}