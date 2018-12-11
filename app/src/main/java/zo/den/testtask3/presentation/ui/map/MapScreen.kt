package zo.den.testtask3.presentation.ui.map

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class MapScreen(var latitude: Double, var longitude: Double): SupportAppScreen(){
    override fun getFragment(): Fragment {
        return MapFragment.getInstance(latitude, longitude)
    }

    override fun getScreenKey(): String {
        return MapFragment::class.java.name
    }
}