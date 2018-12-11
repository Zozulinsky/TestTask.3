package zo.den.testtask3.presentation.ui.map

import android.os.Bundle
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_map.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapController
import org.osmdroid.views.overlay.Marker
import zo.den.testtask3.R
import zo.den.testtask3.presentation.base.MoxyFragment
import javax.inject.Inject
import javax.inject.Provider


class MapFragment : MoxyFragment(), MapFragmentView {
    companion object {
        private const val KEY_PRODUCT: String = "geoData"
        fun getInstance(latitude: Double, longitude: Double): MapFragment = MapFragment().also {
            it.arguments = Bundle().apply {
                val geoData: DoubleArray = doubleArrayOf(latitude, longitude)
                putDoubleArray(KEY_PRODUCT, geoData)
            }
        }
    }

    fun getData() : DoubleArray {
        val geoData: DoubleArray = this.arguments?.getDoubleArray(KEY_PRODUCT).throwIfNull()
        return geoData
    }


    override val layout: Int = R.layout.fragment_map

    @field:Inject
    lateinit var presenterProvider: Provider<MapPresenter>

    @field:Inject
    @field:MapQualifier
    lateinit var geoData: DoubleArray

    @ProvidePresenter
    fun providePresenter(): MapPresenter = presenterProvider.get()

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        val mapController: MapController = map.controller as MapController
        map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
        map.setBuiltInZoomControls(true)
        mapController.setZoom(13)
        val gpt = GeoPoint(geoData[0], geoData[1])
        mapController.setCenter(gpt)
        val startMarker = Marker(map)
        startMarker.position = gpt
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM)
        map.overlays.add(startMarker)
    }

    override fun showMap(latitude: Double, longitude: Double) {
        geoData[0]= latitude
        geoData[1] = longitude }
}