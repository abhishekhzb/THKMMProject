package ns.thkmmproject.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ns.thkmmproject.Greeting
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ns.thkmmproject.android.databinding.ActivityMainBinding
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainScope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)


        //ktor
      //  val tv: TextView = findViewById(R.id.text_view)
       // tv.text = "Loading..."
        mainScope.launch {
            kotlin.runCatching {
                Greeting().getHtml()
            }.onSuccess {
              //  tv.text = it
                Log.e("RESPONSE",""+it)
            }.onFailure {
               // tv.text = "Error: ${it.localizedMessage}"
            }
        }

       // Bottom Navigation Code //************************************************************
        val navView: BottomNavigationView = binding.appBarMain.contentMain.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_briefing, R.id.navigation_trending, R.id.navigation_premium,R.id.navigation_more
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        binding.appBarMain.toolbarOpenDrawer.setOnClickListener {
            // If the navigation drawer is not open then open it, if its already open then close it.

        }




        //************************************************************



        // Nav Drawer Code //************************************************************
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navViewDrawer: NavigationView = binding.navViewDrawer
        val navControllerDrawer = findNavController(R.id.nav_host_fragment_activity_main)
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
//            ), drawerLayout
//        )
//        setupActionBarWithNavController(navControllerDrawer, appBarConfiguration)
        navViewDrawer.setupWithNavController(navControllerDrawer)
        //************************************************************


    }
}
