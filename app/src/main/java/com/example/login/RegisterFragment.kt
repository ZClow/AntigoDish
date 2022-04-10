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
import java.sql.RowId

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var cpassword: EditText
    private lateinit var fAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_register, container, false)

        username = view.findViewById(R.id.tv_username_reg)
        password = view.findViewById(R.id.tv_pass_reg)
        cpassword = view.findViewById(R.id.tv_cpass_reg)
        fAuth = Firebase.auth

        view.findViewById<Button>(R.id.bt_login_reg).setOnClickListener{
            var navRegister = activity as FragmentNav
            navRegister.navFragment(LoginFragment(), false)
        }

        view.findViewById<Button>(R.id.bt_register_reg).setOnClickListener{
            checkValid()
        }

        return view
    }


    private fun firebaseSignUp(){

        fAuth.createUserWithEmailAndPassword(username.text.toString(),
        password.text.toString()).addOnCompleteListener{
            task ->
            if (task.isSuccessful){
                Toast.makeText(context, "Successfully Registered!", Toast.LENGTH_SHORT).show()
                var navHome = activity as FragmentNav
                navHome.navFragment(HomeFragment(), addToStack = true)
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
            TextUtils.isEmpty(cpassword.text.toString().trim()) -> {
                cpassword.setError("Invalid Password!", warningIcon)
            }
            username.text.toString().isNotEmpty() &&
            password.text.toString().isNotEmpty() &&
            cpassword.text.toString().isNotEmpty() ->
            {
                if (username.text.toString().matches(Regex("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"))){
                    if (password.text.toString().length>=8){
                        if (password.text.toString() == cpassword.text.toString()){
                            firebaseSignUp()
                        }else
                        {
                            cpassword.setError("Passwords don't match!", warningIcon)
                        }

                    }else
                    {
                        password.setError("Password too short!", warningIcon)
                    }
                }else
                {
                    username.setError("Invalid Username!", warningIcon)
                }
            }



        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}