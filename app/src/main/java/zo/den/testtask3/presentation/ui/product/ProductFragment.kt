package zo.den.testtask3.presentation.ui.product

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.content.ContextCompat
import zo.den.testtask3.presentation.adapter.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_products.*
import kotlinx.android.synthetic.main.product.*
import zo.den.testtask3.R
import zo.den.testtask3.presentation.adapter.ProductAdapter
import zo.den.testtask3.presentation.base.MoxyFragment
import zo.den.testtask3.presentation.model.ProductModel
import javax.inject.Inject
import javax.inject.Provider

class ProductFragment: MoxyFragment(), ProductView{

    companion object {
        private const val KEY_ORDER: String = "productmodel"
        fun getInstance(): ProductFragment = ProductFragment()
    }
    override val layout: Int = R.layout.fragment_products

    @field:Inject
    lateinit var presenterProvider: Provider<ProductPresenter>

    @ProvidePresenter
    fun providePresenter(): ProductPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: ProductPresenter

    @field:Inject
    @field:ProductQualifier
    lateinit var productAdapter: ProductAdapter

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        products_list.addItemDecoration(DividerItemDecoration(ContextCompat.getDrawable(this!!.context!!, R.drawable.items_divider)!!))
        products_list.adapter = productAdapter
        products_list.layoutManager = LinearLayoutManager(context)
        productAdapter.listener = object : ProductAdapter.OnItemClickListener{
            override fun onItemClick(productModel: ProductModel) {
                //presenter.onProduct(productModel)
            }
        }
    }

    override fun showProductList(list: List<ProductModel>) {
        productAdapter.list = list
    }

    override fun inputPhoto(bitmap: Bitmap) {
        image.setImageBitmap(bitmap)
    }

    fun getProductModel(): ProductModel {
        //TODO исправить !!
        var productModel: ProductModel = this.arguments!!.getParcelable(KEY_ORDER)
        return productModel
    }
}