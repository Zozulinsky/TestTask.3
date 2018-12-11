package zo.den.testtask3.presentation.ui.map

import dagger.Module
import dagger.Provides
import zo.den.testtask3.presentation.model.ProductModel

@Module
class MapModule {
    @Provides
    @MapQualifier
    fun provideGeoData(mapFragment: MapFragment) : DoubleArray = mapFragment.getData()
}