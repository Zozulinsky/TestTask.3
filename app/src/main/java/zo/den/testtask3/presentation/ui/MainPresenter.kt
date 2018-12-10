package zo.den.testtask3.presentation.ui

import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router
import zo.den.testtask3.presentation.ScreenFactory
import zo.den.testtask3.presentation.base.MoxyPresenter
import zo.den.testtask3.presentation.model.ProductModel
import zo.den.testtask3.presentation.ui.product.ProductQualifier
import javax.inject.Inject
@InjectViewState
class MainPresenter @Inject constructor(): MoxyPresenter<MainView>() {
    @Inject
    @field:MainQualifier
    lateinit var router: Router

    @Inject
    @field:ProductQualifier
    lateinit var productModel: ProductModel


    fun onCreate(isRestore: Boolean) {
        if (!isRestore){
            router.newRootScreen(ScreenFactory.getProductScreen(productModel))

        }


    }
}