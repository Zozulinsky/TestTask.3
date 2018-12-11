package zo.den.testtask3.presentation.ui.product

import android.Manifest
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import zo.den.testtask3.data.dao.ProductDao
import zo.den.testtask3.presentation.ScreenFactory
import zo.den.testtask3.presentation.base.MoxyPresenter
import zo.den.testtask3.presentation.mapper.ProductModelMapper
import zo.den.testtask3.presentation.ui.MainQualifier
import javax.inject.Inject
import android.Manifest.permission
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.app.Activity
import android.content.ContentValues.TAG
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log


@InjectViewState
class ProductPresenter @Inject constructor() : MoxyPresenter<ProductView>() {

    @field:Inject
    lateinit var productDao: ProductDao

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


                }, {
                    it.printStackTrace()
                }).toCompositeDisposable()
        }

        fun onProduct(latitude: Double, longitude: Double) {
            router.navigateTo(ScreenFactory.getMapScreen(latitude, longitude))
        }

    private fun isStoragePermissionGranted(): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) === PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted")
                return true
            } else {

                Log.v(TAG, "Permission is revoked")
                ActivityCompat.requestPermissions(context as Activity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 1)
                return false
            }
        } else {
            Log.v(TAG, "Permission is granted")
            return true
        }
    }
    }