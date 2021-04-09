package com.example.swipe

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.zys.swipe.ItemSwipeHelper

/**
 * 描述:
 *
 * author zys
 * create by 2021/4/9
 */
class Fragment0 : BaseSampleFragment() {
    private val recyclerView by lazy { requireView().findViewById<RecyclerView>(R.id.recyclerView) }
    private val swipeAdapter by lazy { SwipeAdapter {} }

    override val layoutId: Int = R.layout.fragment_home
    override fun init(view: View) {
        recyclerView.adapter = swipeAdapter

        ItemSwipeHelper.attach(this,recyclerView)

        val temp = mutableListOf<String>()
        for (y in 2018..2021) {
            for (m in 1..12 step 2) {
                for (d in 1..28 step 3) {
                    temp.add("$y 年 $m 月 $d 日")
                }
            }
        }
        val data = temp.mapIndexed { index, s -> SwipeCell(s, (index + 1) % 3) }
        swipeAdapter.submit(data)

    }
}