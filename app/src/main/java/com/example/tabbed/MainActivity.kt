package com.example.tabbed

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.tabbed.ui.main.SectionsPagerAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout
    private lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        //Create a slides
        setupViewPager()

        //Create a Floating Action Button
        setupFab()

    }

    private fun setupFab() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun initViews() {
        viewPager = findViewById(R.id.view_pager)
        tabs = findViewById(R.id.tabs)
        fab = findViewById(R.id.fab)
    }

    private fun setupViewPager() {
        val sectionsPagerAdapter = SectionsPagerAdapter( supportFragmentManager)

        sectionsPagerAdapter.addFragment(CallFragment(), "Call")
        sectionsPagerAdapter.addFragment(ContactFragment(), "Contact")
        sectionsPagerAdapter.addFragment(FavFragment(), "Favorits")

        viewPager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }
}