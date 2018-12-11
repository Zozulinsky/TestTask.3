package zo.den.testtask3.data.network.service

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Url

interface ImageService {
    @GET
    fun getImage(@Url url: String): Single<ResponseBody>
}