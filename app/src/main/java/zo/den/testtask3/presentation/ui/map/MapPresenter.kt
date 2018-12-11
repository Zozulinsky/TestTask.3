package zo.den.testtask3.presentation.ui.map

import com.arellomobile.mvp.InjectViewState
import zo.den.testtask3.presentation.base.MoxyPresenter
import zo.den.testtask3.presentation.model.ProductModel
import javax.inject.Inject


@InjectViewState
class MapPresenter @Inject constructor() : MoxyPresenter<MapFragmentView>() {


    @Inject
    @field:MapQualifier
    lateinit var productModel: ProductModel

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showMap(productModel)
    }
}