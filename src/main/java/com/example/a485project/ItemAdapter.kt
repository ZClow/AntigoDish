package com.example.a485project.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a485project.R
import com.example.a485project.data.Datasource
import com.example.a485project.database.items.ItemDatabase
import com.example.a485project.database.items.Items
import com.example.a485project.model.Buy





class ItemAdapter(private val context: Context) : ListAdapter<Items, ItemAdapter.ItemViewHolder>(WordsComparator()) {
    /**class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textView1: TextView = view.findViewById(R.id.item_title)
        val textView2: TextView = view.findViewById(R.id.item_price)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val hiddenText: TextView = view.findViewById(R.id.textView5)
    }
**/
    //private val db by lazy { ItemDatabase.getDatabase(context).itemDao() }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        return ItemViewHolder.create(parent)


        /**val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)


        return ItemViewHolder(adapterLayout)
        **/
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.textView1.text = context.resources.getString(item.itemName)
        holder.textView2.text = context.resources.getString(item.price)
        holder.imageView.setImageResource(item.picture)
        holder.hiddenText.text=context.resources.getString(item.description)
        holder.hiddenText.append(System.getProperty("line.separator"))
        holder.hiddenText.append(context.resources.getString(item.location))
        holder.hiddenText.append(System.getProperty("line.separator"))
        holder.imageView.setOnClickListener(View.OnClickListener {
            holder.hiddenText.visibility=View.VISIBLE
        })
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val ItemView: TextView = itemView.findViewById(R.id.textView)
        val textView1: TextView = itemView.findViewById(R.id.item_title)
        val textView2: TextView = itemView.findViewById(R.id.item_price)
        val imageView: ImageView = itemView.findViewById(R.id.item_image)
        val hiddenText: TextView = itemView.findViewById(R.id.textView5)

        fun bind(text: String?) {
            ItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): ItemViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_item, parent, false)
                return ItemViewHolder(view)
            }
        }
    }
    class WordsComparator : DiffUtil.ItemCallback<Items>() {
        override fun areItemsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Items, newItem: Items): Boolean {
            return oldItem.itemName == newItem.location
        }
    }


}
