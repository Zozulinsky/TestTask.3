package zo.den.testtask3.presentation.ui.product

import android.graphics.Bitmap
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask3.presentation.base.BaseView
import zo.den.testtask3.presentation.model.ProductModel

interface ProductView : BaseView {
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProductList(list: List<ProductModel>)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun inputPhoto(bitmap: Bitmap)
}