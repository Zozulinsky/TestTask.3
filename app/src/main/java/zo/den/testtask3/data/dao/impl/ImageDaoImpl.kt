package zo.den.testtask3.data.dao.impl

import android.graphics.Bitmap
import android.util.LruCache
import io.reactivex.Single
import zo.den.testtask3.data.dao.ImageDao
import zo.den.testtask3.data.network.api.ProductApi
import javax.inject.Inject
/*
class ImageDaoImpl @Inject constructor() : ImageDao {

    var bitmapLruCache: LruCache<String, Bitmap>? = null
    @Inject
    lateinit var productApi: ProductApi

    /*override fun getImage(path: String): Single<Bitmap> {
        val bmp = bitmapLruCache?.get(path)
        return if(bmp==null || bmp.isRecycled){
            productApi.getImage(path).doOnSuccess {
                bitmapLruCache?.put(path, it)
            }
        }else
            Single.just(bmp)
    }*/
}*/