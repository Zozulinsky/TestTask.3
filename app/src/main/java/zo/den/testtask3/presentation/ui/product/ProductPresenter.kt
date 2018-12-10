package zo.den.testtask3.presentation.ui.product

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import zo.den.testtask3.data.dao.ImageDao
import zo.den.testtask3.data.dao.ProductDao
import zo.den.testtask3.presentation.base.MoxyPresenter
import zo.den.testtask3.presentation.mapper.ProductModelMapper
import zo.den.testtask3.presentation.model.ProductModel
import zo.den.testtask3.presentation.ui.MainQualifier
import javax.inject.Inject

@InjectViewState
class ProductPresenter @Inject constructor() : MoxyPresenter<ProductView>() {
    @field:Inject
    lateinit var productDao: ProductDao

    @field:Inject
    lateinit var imageDao: ImageDao


    @Inject
    @field:MainQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        productDao.getProducts()
                .map(ProductModelMapper())
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.showProductList(it)
                    for (productModel: ProductModel in it) {
                        imageDao.getImage(productModel.image)
                                .subscribeOn(Schedulers.io())
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe({
                                    viewState.inputPhoto(it)
                                }, { it.printStackTrace() }).toCompositeDisposable()
                    }
                }, {
                    it.printStackTrace()
                }).toCompositeDisposable()
        }

        fun onProduct(productModel: ProductModel) {
            //TODO добавить функционал открытия карты
        }
    }