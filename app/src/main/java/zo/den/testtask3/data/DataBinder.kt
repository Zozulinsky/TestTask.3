package zo.den.testtask3.data

import dagger.Binds
import dagger.Module
import zo.den.testtask3.data.dao.ImageDao
import zo.den.testtask3.data.dao.ProductDao
import zo.den.testtask3.data.dao.impl.ImageDaoImpl
import zo.den.testtask3.data.dao.impl.ProductDaoImpl

@Module
abstract class DataBinder {
    @Binds
    abstract fun bindProductDao(dao: ProductDaoImpl): ProductDao

    @Binds
    abstract fun bindImageDao(dao: ImageDaoImpl): ImageDao
}