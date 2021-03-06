package zo.den.testtask3.presentation.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.product.*
import kotlinx.android.synthetic.main.product.view.*
import zo.den.testtask3.R
import zo.den.testtask3.presentation.model.ProductModel

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    var listener: OnItemClickListener? = null

    var list: List<ProductModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ProductViewHolder {
        return ProductViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.product, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(p0: ProductViewHolder, p1: Int) {
        p0.bind(list[p1])

    }

    inner class ProductViewHolder(view: View)
        : RecyclerView.ViewHolder(view) {

        fun bind(productModel: ProductModel) {
            itemView.idProduct.text = productModel.id.toString()
            itemView.name.text = productModel.name
            itemView.price.text = productModel.price.toString()
            itemView.city.text = productModel.city
            Picasso
                    .get()
                    .load(productModel.image)
                    .placeholder(R.drawable.outline_cached_black_18dp)
                    .error(R.drawable.baseline_error_black_18)
                    .into(itemView.imageProduct)
            val isFavorite: Boolean? = productModel.isFavorite
            if (isFavorite != null) {
                itemView.isFavorite.setChecked(isFavorite)
            }
            itemView.setOnClickListener(View.OnClickListener {
                val latitude = productModel.latitude
                val longitude = productModel.longitude
                if (latitude != null && longitude != null)
                    listener?.onItemClick(productModel)
            })
        }
    }

    interface OnItemClickListener {
        fun onItemClick(productModel: ProductModel)
    }
}