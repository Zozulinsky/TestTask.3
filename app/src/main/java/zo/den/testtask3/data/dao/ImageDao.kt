package zo.den.testtask3.data.dao

import android.graphics.Bitmap
import io.reactivex.Single

interface ImageDao {
    fun getImage(path: String): Single<Bitmap>
}