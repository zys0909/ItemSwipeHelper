package com.example.swipe

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * 描述:
 *
 * author zys
 * create by 2021/4/9
 */
open class RecyclerVH(itemView: View, val callback: ItemCallback) :
    RecyclerView.ViewHolder(itemView) {

    open fun bind(itemCell: ItemCell, payloads: MutableList<Any> = mutableListOf()) {
        //empty
    }
}