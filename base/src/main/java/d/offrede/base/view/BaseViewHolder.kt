package d.offrede.base.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(viewGroup: ViewGroup, resLayout: Int) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context).inflate(resLayout, viewGroup, false)
) {
    abstract fun bind(item: T)
}