package com.example.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BuyFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BuyFragment : Fragment() {
    var productList = ArrayList<Product>()
    var recyclerView: RecyclerView? = null

    private var database : FirebaseDatabase? = null
    private var dbreference: DatabaseReference? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_buy, container, false)

        database = FirebaseDatabase.getInstance()
        dbreference = database?.getReference("Products")
        val fireBaseListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var child: MutableIterable<DataSnapshot> = snapshot.children
                child.forEach{
                    var product = Product(it.child("Image").value.toString(),
                    it.child("ProductName").value.toString(),
                        it.child("Price").value.toString())

                    productList.add(product)
                }

                val adapter = BuyAdapter(productList)
                recyclerView?.adapter = adapter

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        dbreference?.addValueEventListener(fireBaseListener)

        recyclerView = view.findViewById(R.id.rv_view)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = GridLayoutManager(context,
        2,
        GridLayoutManager.VERTICAL,
        false)







        return view
    }

}