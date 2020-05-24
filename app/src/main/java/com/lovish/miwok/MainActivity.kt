package com.lovish.miwok


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        val viewpager_main = findViewById<ViewPager>(R.id.viewpager_main)
        val tabs_main = findViewById<TabLayout>(R.id.tabs_main)

        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
    }
}
