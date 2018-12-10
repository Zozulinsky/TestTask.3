package zo.den.testtask3.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import zo.den.testtask3.ProductApplication
import zo.den.testtask3.data.DataModule
import zo.den.testtask3.presentation.ActivityBuilder
import zo.den.testtask3.presentation.ui.product.ProductModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            DataModule::class,
            RouterModule::class,
            ProductModule::class,
            ActivityBuilder::class,
            AppModule::class,
            AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<ProductApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<ProductApplication>(){

        @BindsInstance
        abstract fun application(application: Application): Builder

    }
}