package com.zys.swipe

import android.content.res.Resources
import android.util.TypedValue

/**
 * 描述:
 *
 * author zys
 * create by 2021/4/9
 */
val Number.dp: Int
    get() = this.dpf.toInt()

val Number.dpf: Float
    get() = TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        this.toFloat(),
        Resources.getSystem().displayMetrics
    )