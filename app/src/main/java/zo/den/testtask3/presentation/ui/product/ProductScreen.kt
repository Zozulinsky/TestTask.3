package zo.den.testtask3.presentation.ui.product

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask3.presentation.model.ProductModel

class ProductScreen() : SupportAppScreen(){
    override fun getFragment(): Fragment {
        return ProductFragment.getInstance()
    }

    override fun getScreenKey(): String {
        return ProductFragment::class.java.name
    }
}