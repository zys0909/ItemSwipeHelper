package com.example.swipe

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import com.zys.swipe.ItemSwipe
import com.zys.swipe.dp

/**
 * 描述:
 *
 * author zys
 * create by 2021/2/16
 */
class SwipeCell(private val text: String, private val type: Int) : ItemCell {


    override fun layoutResId() = when (type) {
        1 -> R.layout.item_date_cell_delete_2
        2 -> R.layout.item_date_cell_delete_3
        else -> R.layout.item_date_cell_delete_1
    }

    override fun itemId() = text

    override fun itemContent() = text

    override fun onCreateViewHolder(itemView: View, callback: ItemCallback): RecyclerVH {
        return when (type) {
            1 -> SwipeCellVH2(itemView, callback)
            2 -> SwipeCellVH3(itemView, callback)
            else -> SwipeCellVH1(itemView, callback)
        }
    }

}

class SwipeCellVH1(itemView: View, callback: ItemCallback) : BaseSwipeCellVH(itemView, callback) {
    override fun maxSwipeWidth(): Int = 80.dp
}

class SwipeCellVH2(itemView: View, callback: ItemCallback) : BaseSwipeCellVH(itemView, callback) {
    override fun maxSwipeWidth(): Int = 80.dp * 2
}

class SwipeCellVH3(itemView: View,callback: ItemCallback) : BaseSwipeCellVH(itemView, callback) {
    override fun maxSwipeWidth(): Int = 80.dp * 3
}

abstract class BaseSwipeCellVH(itemView: View, callback: ItemCallback) :
    RecyclerVH(itemView, callback), ItemSwipe {

    private val dateView = itemView.findViewById<TextView>(R.id.tv_date)
    private val tvDelete = itemView.findViewById<TextView>(R.id.tv_delete)


    @SuppressLint("SetTextI18n")
    override fun bind(itemCell: ItemCell, payloads: MutableList<Any>) {
        dateView.text = "$adapterPosition - ${itemCell.itemContent()}"
    }

    override fun enable(): Boolean = true
}