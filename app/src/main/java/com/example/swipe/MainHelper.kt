package com.example.swipe

import android.util.SparseArray
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

/**
 * 描述:
 *
 * author zys
 * create by 2021/4/9
 */
class MainHelper(private val fragmentManager: FragmentManager, @IdRes private val contentId: Int) {

    private val tagArray = SparseArray<String>(6)

    private val fragmentSparseArray = SparseArray<Fragment>(5)

    private var homeNav = -1

    init {
        tagArray.put(0, "Fragment0")
        tagArray.put(1, "Fragment1")
        tagArray.put(2, "Fragment2")
        tagArray.put(3, "Fragment3")

    }

    private fun <F : Fragment> create(module: Int, clazz: Class<F>): Fragment {
        val tag: String = tagArray[module]
        val fragment = fragmentManager.findFragmentByTag(tag)
        return if (fragment == null) {
            val newFragment = clazz.newInstance()
            fragmentSparseArray.put(module, newFragment)
            newFragment
        } else {
            fragment
        }
    }

    fun updateFragments(module: Int) {
        val transaction = fragmentManager.beginTransaction()
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        if (homeNav == -1) {
            for (fragment in fragmentManager.fragments) {
                transaction.hide(fragment)
            }
        } else {
            transaction.hide(fragmentSparseArray.get(homeNav))
        }
        homeNav = module
        val tag: String = tagArray[module]
        val clazz = when (module) {
            1 -> Fragment1::class.java
            2 -> Fragment2::class.java
            3 -> Fragment3::class.java
            else -> Fragment0::class.java
        }
        val fragment = create(module, clazz)
        if (fragment.isAdded) {
            transaction.show(fragment)
        } else {
            transaction.add(contentId, fragment, tag)
        }
        transaction.commitAllowingStateLoss()
    }
}