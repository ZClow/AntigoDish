package com.example.login

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.MimeTypeMap
import android.widget.*
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.content.res.AppCompatResources
import com.example.login.databinding.ActivityMainBinding
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.StorageTask
import com.google.firebase.storage.UploadTask
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.*

//import android.content.ContentResolver as contentResolver

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters

    private lateinit var firstname: EditText
    private lateinit var lastname: EditText
    private lateinit var bio: EditText
    private lateinit var fAuth: FirebaseAuth
    private lateinit var fStore: FirebaseStorage
    private lateinit var dbreference: DatabaseReference
    private lateinit var storeference: StorageReference
    private lateinit var uploader: ImageButton
    private lateinit var selector : ImageButton
    private lateinit var imagePreview: ImageView
    private lateinit var filePath: Uri

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        firstname = view.findViewById<EditText>(R.id.et_firstname)
        lastname = view.findViewById<EditText>(R.id.et_lastname)
        bio = view.findViewById<EditText>(R.id.et_bio)

        fAuth = FirebaseAuth.getInstance()


        view.findViewById<Button>(R.id.bt_logout).setOnClickListener {
            Firebase.auth.signOut()
            Toast.makeText(context, "Logged Out!", Toast.LENGTH_SHORT).show()
            var navLogin = activity as FragmentNav
            navLogin.navFragment(LoginFragment(), addToStack = false)
        }

        view.findViewById<Button>(R.id.bt_save).setOnClickListener {
            checkValid()
        }

        selector = view.findViewById(R.id.bt_select)
        imagePreview = view.findViewById(R.id.circ_image)
        uploader = view.findViewById(R.id.bt_upload)

        val getImage = registerForActivityResult(ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                imagePreview.setImageURI(it)
                filePath = it

            })

        selector.setOnClickListener {
            getImage.launch("image/*")

        }

        uploader.setOnClickListener {
            uploadImage(filePath)
        }

        return view

    }

    private fun uploadImage(filepath: Uri){
        val uid = fAuth.currentUser?.uid
//        dbreference = FirebaseDatabase.getInstance().getReference("Users")
        storeference = FirebaseStorage.getInstance().getReference("Users")

        if (uid != null){
            storeference.child(fAuth!!.uid!!).child("image").child("Profile Pic").putFile(filepath).addOnCompleteListener{
                if(it.isSuccessful){
                    Toast.makeText(context, "Image Saved!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, "Image failed to Save!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun checkValid(){
        val warningIcon = AppCompatResources.getDrawable(
            requireContext(),
            R.drawable.ic_baseline_warning_24
        )
        warningIcon?.setBounds(0, 0, warningIcon.intrinsicWidth, warningIcon.intrinsicHeight)
        when {
            TextUtils.isEmpty(firstname.text.toString().trim()) -> {
                firstname.setError("Required Field!", warningIcon)
            }
            TextUtils.isEmpty(lastname.text.toString().trim()) -> {
                lastname.setError("Required Field!", warningIcon)
            }
            firstname.text.toString().isNotEmpty() &&
                    lastname.text.toString().isNotEmpty() -> {
                            var navUser = activity as FragmentNav
                            navUser.navFragment(UserFragment(), addToStack = false)
                saveDetails(firstname.text.toString(), lastname.text.toString(), bio.text.toString())
            }
        }
    }

    private fun saveDetails(firstname: String, lastname: String, bio: String) {
        val user = User(firstname, lastname, bio)
        val uid = fAuth.currentUser?.uid
        dbreference = FirebaseDatabase.getInstance().getReference("Users")
        if (uid != null ){
            dbreference.child(fAuth!!.uid!!).child("user info").setValue(user).addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(context,"Saved!", Toast.LENGTH_SHORT).show()
                }
                else{
                    Toast.makeText(context, "Failed to Save!", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }



}