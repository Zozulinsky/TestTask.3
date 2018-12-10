package zo.den.testtask3.data.dao.impl

import io.reactivex.Observable
import zo.den.testtask3.data.dao.ProductDao
import zo.den.testtask3.data.network.api.ProductApi
import zo.den.testtask3.data.network.pojo.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductDaoImpl @Inject constructor(): ProductDao {
    @Inject
    lateinit var productApi: ProductApi

    override fun getProducts(): Observable<Product> {
        return productApi.getProducts()
                .flatMapObservable {
                    Observable.fromIterable(it)
                }
    }
}