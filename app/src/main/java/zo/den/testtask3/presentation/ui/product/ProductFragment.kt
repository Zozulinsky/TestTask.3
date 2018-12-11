package zo.den.testtask3.presentation.ui.product

import android.Manifest
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.LinearLayoutManager.HORIZONTAL
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_products.*
import zo.den.testtask3.R
import zo.den.testtask3.R.drawable.items_divider
import zo.den.testtask3.presentation.adapter.DividerItemDecoration
import zo.den.testtask3.presentation.adapter.ProductAdapter
import zo.den.testtask3.presentation.base.MoxyFragment
import zo.den.testtask3.presentation.model.ProductModel
import javax.inject.Inject
import javax.inject.Provider
import android.Manifest.permission
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.app.Activity
import android.content.ContentValues.TAG
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import android.os.Build
import android.util.Log
import android.widget.Toast


class ProductFragment: MoxyFragment(), ProductView{

    companion object {
        fun getInstance(): ProductFragment = ProductFragment()
    }
    override val layout: Int = R.layout.fragment_products

    @field:Inject
    lateinit var presenterProvider: Provider<ProductPresenter>

    @ProvidePresenter
    fun providePresenter() = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: ProductPresenter

    @field:Inject
    @field:ProductQualifier
    lateinit var productAdapter: ProductAdapter

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        val context: Context? = this.context
        if(!isStoragePermissionGranted()){
            Toast.makeText(context, getString(R.string.getpermission),Toast.LENGTH_LONG)
        }
        products_list.addItemDecoration(DividerItemDecoration(context?.let { ContextCompat.getDrawable(it, R.drawable.items_divider) }!!))
        products_list.adapter = productAdapter
        products_list.layoutManager = LinearLayoutManager(context)
        productAdapter.listener = object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(productModel : ProductModel) {
                val latitude = productModel.latitude
                val longitude = productModel.longitude
                if (latitude != null && longitude != null)
                presenter.onProduct(latitude, longitude)
            }
        }
    }

    private fun isStoragePermissionGranted(): Boolean {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context?.checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) === PackageManager.PERMISSION_GRANTED) {
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

    override fun showProductList(list: List<ProductModel>) {
        productAdapter.list = list


    }

}