package com.example.myapplication.ui.activity

import TabAdapter
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.databinding.ActivityNavigationBinding
import com.example.myapplication.databinding.ActivityOrderBinding
import com.example.myapplication.ui.fragment.ActiveFragment
import com.google.android.material.tabs.TabLayoutMediator

class OrderActivity : AppCompatActivity() {
    override fun onPause() {
        Log.d("lifecycle","Onpause -> I am called")
        super.onPause()
    }

    override fun onResume() {
        Log.d("lifecycle","Onresume -> I am called")
        super.onResume()
    }

    override fun onStart() {
        Log.d("lifecycle","ONStart -> I am called")
        super.onStart()
    }
    override fun onDestroy() {

        Log.d("lifecycle","Ondestroy -> I am called")
        super.onDestroy()
    }

    lateinit var binding : ActivityOrderBinding
    lateinit var adapter: TabAdapter

    // if tab layout ko header ma icon rakne bhaye
    val icons = arrayOf(
        R.drawable.baseline_home_24,
        R.drawable.baseline_notifications_24,
        R.drawable.baseline_person_24,
    )

    // if tab layout ko header ma text rakne bhaye
    val data = arrayOf("Active Order","Delivered Order","Cancelled Order")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager : FragmentManager =
            supportFragmentManager

        adapter = TabAdapter(fragmentManager,lifecycle)

        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager){
            // if we want to put text
                tabs,position -> tabs.text = data[position]
            //if we want to put icon
//            tabs,position -> tabs.icon =
//            resources.getDrawable(icons[position],null)
        }.attach()

        Log.d("lifecycle","Oncreate -> I am called")
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}