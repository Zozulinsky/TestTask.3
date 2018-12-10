package zo.den.testtask3.data.dao

import io.reactivex.Observable
import zo.den.testtask3.data.network.pojo.Product
import java.util.*

interface ProductDao {
    fun getProducts(): Observable<Product>
}