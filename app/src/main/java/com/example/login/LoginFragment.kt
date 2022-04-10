package com.example.login

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
//    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var fAuth: FirebaseAuth

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
////            param1 = it.getString(ARG_PARAM1)
////            param2 = it.getString(ARG_PARAM2)
//        }
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_login, container, false)

        username = view.findViewById(R.id.tv_username_log)
        password = view.findViewById(R.id.tv_pass_log)
        fAuth = Firebase.auth

        view.findViewById<Button>(R.id.bt_register_log).setOnClickListener{
            var navRegister = activity as FragmentNav
            navRegister.navFragment(RegisterFragment(), false)
        }

        view.findViewById<Button>(R.id.bt_login_log).setOnClickListener{
            checkValid()
        }

        return view
    }

    private fun firebaseSignIn(){

        fAuth.signInWithEmailAndPassword(username.text.toString(),
        password.text.toString()).addOnCompleteListener{
            task ->
            if (task.isSuccessful){
                Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                var navUser = activity as FragmentNav
                navUser.navFragment(UserFragment(), addToStack = true)
            }
            else{
                Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun checkValid() {
        val warningIcon = AppCompatResources.getDrawable(
            requireContext(),
            R.drawable.ic_baseline_warning_24
        )

        warningIcon?.setBounds(0, 0, warningIcon.intrinsicWidth, warningIcon.intrinsicHeight)
        when {
            TextUtils.isEmpty(username.text.toString().trim()) -> {
                username.setError("Invalid Username!", warningIcon)
            }
            TextUtils.isEmpty(password.text.toString().trim()) -> {
                password.setError("Invalid Password!", warningIcon)
            }
            username.text.toString().isNotEmpty() &&
                    password.text.toString().isNotEmpty() ->
            {
                if (username.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))){

                    firebaseSignIn()
                }else
                {
                    username.setError("Invalid Username!", warningIcon)
                }
            }



        }

    }

//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment LoginFragment.
//         */
//        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(param1: String, param2: String) =
//            LoginFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
//                }
//            }
//    }
}