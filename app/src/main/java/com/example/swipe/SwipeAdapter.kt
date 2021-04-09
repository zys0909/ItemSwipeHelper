package com.example.swipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * 描述:
 *
 * author zys
 * create by 2021/4/9
 */
class SwipeAdapter(private val callback:ItemCallback) : RecyclerView.Adapter<RecyclerVH>() {

    val currentList = mutableListOf<ItemCell>()

    /**
     * submit list
     */
    fun submit(list: List<ItemCell>) {
        val temp = mutableListOf<ItemCell>()
        temp.addAll(list)
        currentList.clear()
        currentList.addAll(list)
        notifyDataSetChanged()
    }

    fun removeAt(position: Int) {
        val temp = MutableList(currentList.size) {
            currentList[it]
        }
        temp.removeAt(position)
        submit(temp)
    }

    override fun getItemViewType(position: Int) = currentList[position].layoutResId()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerVH {
        currentList.forEach {
            if (viewType == it.layoutResId()) {
                return it.onCreateViewHolder(
                    LayoutInflater.from(parent.context).inflate(
                        viewType,
                        parent,
                        false
                    ), callback
                )
            }
        }
        throw IllegalArgumentException("viewType not found")
    }

    override fun getItemCount() = currentList.size

    override fun onBindViewHolder(holder: RecyclerVH, position: Int, payloads: MutableList<Any>) {
        holder.bind(currentList[position], payloads)
    }

    override fun onBindViewHolder(holder: RecyclerVH, position: Int) {
        holder.bind(currentList[position])
    }

}

