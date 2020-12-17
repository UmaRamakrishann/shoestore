package com.udacity.shoestore


import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding

/**
 * MainActivity for the Shoe Store app
 */
class MainActivity : AppCompatActivity() {

    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var viewModel: ShoeStoreViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        //Setup toolbar
        toolbar = binding.toolbar
        setSupportActionBar(toolbar);
        navController = this.findNavController(R.id.navHostFragment)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupWithNavController(
            toolbar, navController, appBarConfiguration
        );
        // Get the viewmodel
        viewModel = ViewModelProvider(this).get(ShoeStoreViewModel::class.java)
    }


    override fun onBackPressed() {
        //Ensure that when device bacl button pressed from ShoeList screen,
        // the user cannot go back to the Onboarding and Login screens.
        viewModel.loggedIn.observe(this, Observer { loggedIn ->
            if (loggedIn && navController.currentDestination!!.id == R.id.shoeListFragment) {
                Navigation.findNavController(this, R.id.navHostFragment)
                    .popBackStack(R.id.shoeListFragment, false)
            }
        })
    }
}
