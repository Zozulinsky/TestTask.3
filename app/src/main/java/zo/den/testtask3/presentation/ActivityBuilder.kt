package zo.den.testtask3.presentation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zo.den.testtask3.presentation.ui.MainActivity
import zo.den.testtask3.presentation.ui.MainModule
import zo.den.testtask3.presentation.ui.MainScope

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainModule::class])
    @MainScope
    abstract fun buildMainActivity(): MainActivity
}