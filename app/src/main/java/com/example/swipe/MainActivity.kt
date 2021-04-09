package com.example.swipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.zys.swipe.ItemSwipeHelper

/**
 * 描述:
 *
 * author zys
 * create by 2021/4/9
 */
class MainActivity : AppCompatActivity() {
    private val bottomNavView: BottomNavigationView by lazy { findViewById(R.id.bottom_nav_view) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val helper = MainHelper(supportFragmentManager, R.id.fragment_content)

        bottomNavView.setOnNavigationItemSelectedListener {
            val position = when (it.itemId) {
                R.id.page1Fragment -> 0
                R.id.page2Fragment -> 1
                R.id.page3Fragment -> 2
                R.id.page4Fragment -> 3
                else -> -1
            }
            if (position >= 0) {
                helper.updateFragments(position)

            }
            position >= 0
        }
        helper.updateFragments(0)
    }
}