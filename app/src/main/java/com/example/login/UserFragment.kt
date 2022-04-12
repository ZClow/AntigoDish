package com.example.login

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

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
    private lateinit var profileImage : ImageView
    private lateinit var username : TextView
//    private lateinit var emailid: TextView
    private lateinit var fAuth: FirebaseAuth
    private lateinit var fStore: FirebaseStorage
    private lateinit var dbreference: DatabaseReference
    private lateinit var storeference: StorageReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        profileImage = requireView().findViewById(R.id.circ_profileimage_navbar)
//
//        return view
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

//        profileImage = view.findViewById(R.id.circ_profileimage_navbar)
//        username = view.findViewById(R.id.tv_username_navbar)
////        emailid = view.findViewById(R.id.)

//        fAuth = FirebaseAuth.getInstance()
//        fStore = FirebaseStorage.getInstance()
//        storeference = fStore.reference
//        val uid = fAuth.currentUser?.uid
//
//        if (uid != null) {
//            storeference.child(uid).child("image/Profile Pic").downloadUrl.addOnSuccessListener { uri -> Picasso.get().load(uri).into(profileImage)
//
//            }
//        }
        

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

        view.findViewById<Button>(R.id.bt_buy).setOnClickListener{
            var navBuy = activity as FragmentNav
            navBuy.navFragment(BuyFragment(), addToStack = true)

        }

        return view
    }

}