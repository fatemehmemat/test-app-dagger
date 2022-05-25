package com.example.myapp.ui.activities


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapp.R
import com.example.myapp.data.dataStore.DataStoreManager
import com.example.myapp.ui.fragments.HomeFragment
import com.example.myapp.ui.fragments.PersonFragment
import com.example.myapp.ui.fragments.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject


class MainActivity : AppCompatActivity(), HasAndroidInjector {
    private val TAG = "MainActivity"

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var dataStoreManager: DataStoreManager


    @Inject
    internal lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)

/*

        coroutineScope.launch {
            dataStoreManager.setToken("455555555445")
        }

        coroutineScope.launch {
            dataStoreManager.getToken().collect {
                Log.d(TAG, "onCreate: token" + it)
            }

        }
*/

        val homeFragment = HomeFragment()
        val personFragment = PersonFragment()
        val settingsFragment = SettingsFragment()

        setCurrentFragment(homeFragment)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setCurrentFragment(homeFragment)
                R.id.person -> setCurrentFragment(personFragment)
                R.id.settings -> setCurrentFragment(settingsFragment)

            }
            true
        }

    }


    override fun androidInjector() = dispatchingAndroidInjector

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(com.example.myapp.R.id.flFragment, fragment)
            commit()
        }


}
