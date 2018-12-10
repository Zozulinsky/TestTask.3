package zo.den.testtask3.presentation.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zo.den.testtask3.presentation.ui.product.ProductFragment
import zo.den.testtask3.presentation.ui.product.ProductModule
import zo.den.testtask3.presentation.ui.product.ProductScope

@Module
abstract class MainFragmentBuilder{

    @ContributesAndroidInjector(modules = [ProductModule::class])
    @ProductScope
    abstract fun buildProductFragment(): ProductFragment
}