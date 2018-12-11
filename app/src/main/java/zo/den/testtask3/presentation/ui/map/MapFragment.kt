package zo.den.testtask3.presentation.ui.map

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapController
import org.osmdroid.views.MapView
import zo.den.testtask3.R
import zo.den.testtask3.presentation.base.MoxyFragment
import zo.den.testtask3.presentation.model.ProductModel
import javax.inject.Inject
import javax.inject.Provider


class MapFragment : MoxyFragment(), MapFragmentView {
    companion object {
        private const val KEY_PRODUCT: String = "product"
        fun getInstance(productModel: ProductModel): MapFragment = MapFragment().also {
            it.arguments = Bundle().apply {
                putParcelable(KEY_PRODUCT, productModel)
            }
        }
    }

    override val layout: Int = R.layout.fragment_map

    fun getProductModel(): ProductModel {
        //TODO исправить
        val productModel: ProductModel = this.arguments!!.getParcelable(KEY_PRODUCT)
        return productModel
    }

    @field:Inject
    lateinit var presenterProvider: Provider<MapPresenter>

    @ProvidePresenter
    fun providePresenter(): MapPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: MapPresenter

    @field:Inject
    @field:MapQualifier
    lateinit var modelP: ProductModel

    override fun showMap(model: ProductModel) {
        modelP=model

    }


    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        val mapView: MapView =  R.id.map as MapView
        val mapController: MapController = mapView.controller as MapController
        mapView.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
        mapView.setBuiltInZoomControls(true)
        mapController.setZoom(13)
        val gpt = GeoPoint(modelP.latitude.toDouble(), modelP.longitude.toDouble())
        mapController.setCenter(gpt)

    }
}