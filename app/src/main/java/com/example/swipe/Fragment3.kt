package com.example.swipe

import android.view.View

/**
 * 描述:
 *
 * author zys
 * create by 2021/4/9
 */
class Fragment3 : BaseSampleFragment() {
    override val layoutId: Int = R.layout.fragment_sample

    override fun init(view: View) {
        view.setBackgroundColor(0xFF999999.toInt())
    }
}