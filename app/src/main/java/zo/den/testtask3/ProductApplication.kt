package zo.den.testtask3

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import zo.den.testtask3.di.DaggerAppComponent

class ProductApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).create(this)
    }

    override fun onCreate(){
        super.onCreate()

    }
}