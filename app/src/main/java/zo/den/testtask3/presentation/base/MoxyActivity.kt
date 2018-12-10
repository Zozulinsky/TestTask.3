package zo.den.testtask3.presentation.base

import android.os.Bundle
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import dagger.android.AndroidInjection

abstract class MoxyActivity : MvpAppCompatActivity(), BaseView{

    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout)
        onViewPrepare(savedInstanceState)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.getItemId() === android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }
    protected open fun onViewPrepare(savedInstanceState: Bundle?){}

    protected open fun onViewDetach(){}

    override fun onDestroy(){
        onViewDetach()
        super.onDestroy()
    }
}