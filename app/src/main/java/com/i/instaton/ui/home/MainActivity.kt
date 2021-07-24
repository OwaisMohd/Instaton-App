package com.i.instaton.ui.home

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.i.instaton.R
import com.i.instaton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val storiesViewModel by viewModels<StoriesViewModel>()
    private val storiesAdapter = StoriesRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStories.apply {
            layoutManager = LinearLayoutManager(context,
                    RecyclerView.HORIZONTAL,false)
            adapter = storiesAdapter
        }

        setUpNav()

        storiesViewModel.fetchTags()

    }

    private fun setUpNav() {
        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment)

/*      NOTE: NOT USING AN ACTION BAR IN OUR APP FOR NOW
        ------------------------ACTION BAR CODE--------------------
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.navigation_hot, R.id.navigation_top))
//        setupActionBarWithNavController(navController, appBarConfiguration)
          ------------------------ACTION BAR CODE--------------------
          */

        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()

        storiesViewModel.tags.observe(this){
            storiesAdapter.submitList(it)
        }
    }
}