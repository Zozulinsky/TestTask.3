package zo.den.testtask3.presentation.mapper

import io.reactivex.functions.Function
import zo.den.testtask3.data.network.pojo.Product
import zo.den.testtask3.presentation.model.ProductModel

class ProductModelMapper:Function<Product, ProductModel> {
    override fun apply(t: Product): ProductModel {
        val id: Int? = t.id
        val name: String? = t.name
        val image: String = t.image
        val price: Int? = t.price
        val city: String? = t.city
        val isFavorite: Boolean? = t.isFavorite
        val latitude: String = t.latitude
        val longitude: String = t.longitude

        return ProductModel(id, name, image, price, city, isFavorite, latitude,longitude)
    }
}