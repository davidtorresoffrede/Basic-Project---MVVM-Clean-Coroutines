package d.offrede.base.view

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter<T>(
    var itens: List<T>,
    private val viewHolder: (ViewGroup) -> BaseViewHolder<T>
) : RecyclerView.Adapter<BaseViewHolder<T>>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): BaseViewHolder<T> {
        return viewHolder(viewGroup)
    }

    override fun getItemCount() = itens.size

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(itens[position])
    }

}