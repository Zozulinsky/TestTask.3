package zo.den.testtask3.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductModel (

        val id: Int?,
        val name: String?,
        val image: String,
        val price: Int?,
        val city: String?,
        val isFavorite: Boolean?
) :Parcelable