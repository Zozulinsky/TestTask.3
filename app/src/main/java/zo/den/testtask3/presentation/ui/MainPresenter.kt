package zo.den.testtask3.presentation.ui

import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router
import zo.den.testtask3.presentation.ScreenFactory
import zo.den.testtask3.presentation.base.MoxyPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor(): MoxyPresenter<MainView>() {
    @Inject
    @field:MainQualifier
    lateinit var router: Router



    fun onCreate(isRestore: Boolean) {
        if (!isRestore){
            router.newRootScreen(ScreenFactory.getProductScreen())

        }


    }
}