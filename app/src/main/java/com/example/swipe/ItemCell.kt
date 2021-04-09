package com.example.swipe

import android.view.View
import androidx.annotation.LayoutRes

typealias ItemCallback = () -> Unit

/**
 * 描述:
 *
 * author zys
 * create by 2021/4/9
 */
interface ItemCell {
    @LayoutRes
    fun layoutResId(): Int

    /**
     * item标志，用于比较item是否一样
     */
    fun itemId(): String

    /**
     * item内容
     */
    fun itemContent(): String

    fun onCreateViewHolder(itemView: View, callback: ItemCallback): RecyclerVH
}