package dev.kunaal.deciphyr

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration =
            AppBarConfiguration(setOf(R.id.loginFragment, R.id.gameListFragment))

        // Don't use the following:
        // toolbar.setupWithNavController(navController, appBarConfiguration)
        // Reason : https://stackoverflow.com/questions/55904485/custom-navigate-up-behavior-for-certain-fragment-using-navigation-component
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        supportActionBar?.title = navController.currentDestination?.label
    }
}
