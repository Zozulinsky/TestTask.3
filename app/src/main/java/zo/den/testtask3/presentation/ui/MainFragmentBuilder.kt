package zo.den.testtask3.presentation.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zo.den.testtask3.presentation.ui.map.MapFragment
import zo.den.testtask3.presentation.ui.map.MapModule
import zo.den.testtask3.presentation.ui.map.MapScope
import zo.den.testtask3.presentation.ui.product.ProductFragment
import zo.den.testtask3.presentation.ui.product.ProductModule
import zo.den.testtask3.presentation.ui.product.ProductScope

@Module
abstract class MainFragmentBuilder{

    @ContributesAndroidInjector(modules = [ProductModule::class])
    @ProductScope
    abstract fun buildProductFragment(): ProductFragment
    @ContributesAndroidInjector(modules = [MapModule::class])
    @MapScope
    abstract fun buildMapFragment(): MapFragment
}