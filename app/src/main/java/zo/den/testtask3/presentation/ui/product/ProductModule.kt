package zo.den.testtask3.presentation.ui.product

import dagger.Module
import dagger.Provides
import zo.den.testtask3.presentation.adapter.ProductAdapter
import zo.den.testtask3.presentation.model.ProductModel

@Module
class ProductModule {

    @Provides
    @ProductQualifier
    fun provideProductAdapter() : ProductAdapter = ProductAdapter()

    @Provides
    @ProductQualifier
    fun provideDetails(productFragment: ProductFragment): ProductModel = productFragment.getProductModel()

}