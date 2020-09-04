package com.anureet.nestedrecyclerviewexample.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.anureet.nestedrecyclerviewexample.R
import com.anureet.nestedrecyclerviewexample.data.Categories
import com.anureet.nestedrecyclerviewexample.data.Category
import com.anureet.nestedrecyclerviewexample.data.Favourites
import com.anureet.nestedrecyclerviewexample.data.itemName
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fragment_favourite_detail.*
import kotlinx.android.synthetic.main.card_item.*

class ItemAdapter(val context: Context):
    ListAdapter<Category, ItemAdapter.ViewHolder>(
        DiffCallback()
    ){

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_item, parent, false)

        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
//        init{
//            itemView.setOnClickListener{
//                listener.invoke(getItem(adapterPosition).category)
//            }
//        }

        fun bind(item: Category){
            with(item){
                when(item.category){
                    Categories.Movies.ordinal ->{
                        category_name.text = Categories.Movies.toString()
                    }
                    Categories.Sports.ordinal ->{
                        category_name.text = Categories.Sports.toString()
                    }
                    Categories.Fruits.ordinal ->{
                        category_name.text = Categories.Fruits.toString()
                    }
                    else ->  category_name.text = Categories.Vegetables.toString()
                }

                // Setting up list view
                val list: List<String> = item.children.map { it.name }
                val adapter = ArrayAdapter(context, android.R.layout.simple_list_item_1,list)
                item_list.adapter = adapter

            }
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem.category == newItem.category
    }

    override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
        return oldItem == newItem
    }
}