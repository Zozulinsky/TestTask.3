package zo.den.testtask3.presentation

import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask3.presentation.ui.map.MapScreen
import zo.den.testtask3.presentation.ui.product.ProductScreen

object ScreenFactory {
    fun getProductScreen(): SupportAppScreen
    {
        return ProductScreen()
    }
    fun getMapScreen(latitude: Double, longitude: Double): SupportAppScreen
    {
        return MapScreen(latitude, longitude)
    }


}