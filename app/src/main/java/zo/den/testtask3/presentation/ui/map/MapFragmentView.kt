package zo.den.testtask3.presentation.ui.map

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask3.presentation.base.BaseView
import zo.den.testtask3.presentation.model.ProductModel

interface MapFragmentView : BaseView{
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showMap(latitude: Double, longitude: Double)
}