package com.example.swipe

import android.view.View

/**
 * 描述:
 *
 * author zys
 * create by 2021/4/9
 */
class Fragment2 : BaseSampleFragment() {
    override val layoutId: Int = R.layout.fragment_sample

    override fun init(view: View) {
        view.setBackgroundColor(0xFFBBBBBB.toInt())
    }
}