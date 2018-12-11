package zo.den.testtask3.presentation.ui.map

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask3.presentation.model.ProductModel
import zo.den.testtask3.presentation.ui.product.ProductFragment

class MapScreen(var productModel: ProductModel): SupportAppScreen(){
    override fun getFragment(): Fragment {
        return MapFragment.getInstance(productModel)
    }

    override fun getScreenKey(): String {
        return MapFragment::class.java.name
    }
}