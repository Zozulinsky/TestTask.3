package zo.den.testtask3.data.network.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Product {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("available_stock")
    @Expose
    var availableStock: Int? = null
    @SerializedName("image")
    @Expose
    lateinit var image: String
    @SerializedName("isFavorite")
    @Expose
    var isFavorite: Boolean? = null
    @SerializedName("price")
    @Expose
    var price: Int? = null
    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("description")
    @Expose
    var description: String? = null
    @SerializedName("latitude")
    @Expose
    var latitude: String = ""
    @SerializedName("longitude")
    @Expose
    var longitude: String = ""

}
