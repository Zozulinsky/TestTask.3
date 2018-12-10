package zo.den.testtask3.presentation

import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask3.presentation.model.ProductModel
import zo.den.testtask3.presentation.ui.product.ProductScreen

object ScreenFactory {
    fun getProductScreen(productModel: ProductModel): SupportAppScreen
    {
        return ProductScreen(productModel)
    }


}