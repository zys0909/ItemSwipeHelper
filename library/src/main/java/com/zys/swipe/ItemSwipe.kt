package com.zys.swipe

/**
 * 描述:
 *
 * author zys
 * create by 2021/3/16
 */
interface ItemSwipe {

    /**
     * 该ViewHolder 是否支持侧滑
     */
    fun enable(): Boolean

    fun maxSwipeWidth(): Int
}