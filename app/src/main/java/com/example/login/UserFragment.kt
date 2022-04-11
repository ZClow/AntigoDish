package com.example.login

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserFragment : Fragment() {

    lateinit var  toggle : ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_user, container, false)
        var drawerLayout : DrawerLayout = view.findViewById<DrawerLayout>(R.id.dr_layout)
        var navView : NavigationView = view.findViewById<NavigationView>(R.id.nav_view)

//        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
//        drawerLayout.addDrawerListener(toggle)
//        toggle.syncState()


        navView.setNavigationItemSelectedListener {
        when(it.itemId){
            R.id.nav_home -> Toast.makeText(context, "Home", Toast.LENGTH_SHORT).show()
            R.id.nav_orders -> Toast.makeText(context, "Orders", Toast.LENGTH_SHORT).show()
            R.id.nav_settings -> {
                var navSettings = activity as FragmentNav
                navSettings.navFragment(HomeFragment(), addToStack = true)
            }
            R.id.nav_delete -> Toast.makeText(context, "Delete", Toast.LENGTH_SHORT).show()
            R.id.nav_logout -> {
                var navLogin = activity as FragmentNav
                navLogin.navFragment(LoginFragment(), addToStack = false)
            }

        }
            true
    }

        return view
    }

}