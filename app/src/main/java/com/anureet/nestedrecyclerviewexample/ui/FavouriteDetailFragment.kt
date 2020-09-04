package com.anureet.nestedrecyclerviewexample.ui

import android.os.Bundle
import android.support.v4.media.session.MediaSessionCompat.Token.fromBundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.anureet.nestedrecyclerviewexample.R
import com.anureet.nestedrecyclerviewexample.data.Categories
import com.anureet.nestedrecyclerviewexample.data.Favourites
import kotlinx.android.synthetic.main.fragment_favourite_detail.*

@Suppress("DEPRECATION")
class FavouriteDetailFragment : Fragment() {

    private lateinit var viewModel: FavouriteDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FavouriteDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val categories = mutableListOf<String>()
        Categories.values().forEach { categories.add(it.name)}
        val arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, categories)
        category_spinner.adapter = arrayAdapter

//        category_spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//                updateCategoryView(position)
//            }
//        }
        val id = FavouriteDetailFragmentArgs.fromBundle(requireArguments()).id
        viewModel.setTaskId(id)

        viewModel.item.observe(viewLifecycleOwner, Observer {
            it?.let{ setData(it) }
        })

        save_button.setOnClickListener {
            saveTask()
        }

        delete_button.setOnClickListener {
            deleteTask()
        }
    }

    private fun setData(data: Favourites){
        name.setText(data.name)
        category_spinner.setSelection(data.category)
    }

    private fun saveTask(){
        val name = name.text.toString()
        val category = category_spinner.selectedItemPosition

        // Saving item inside database
        val item = Favourites(viewModel.itemId.value!!, name, category)
        viewModel.saveTask(item)

        requireActivity().onBackPressed()
    }

    private fun deleteTask(){
        viewModel.deleteTask()

        requireActivity().onBackPressed()
    }

//    private fun updateCategoryView(category: Int){
//        when(category){
//            Categories.Movies.ordinal ->{
//                category_image.setBackgroundResource(R.drawable.movies)
//            }
//            Categories.Sports.ordinal ->{
//                category_image.setBackgroundResource(R.drawable.sports)
//            }
//            Categories.Fruits.ordinal ->{
//                category_image.setBackgroundResource(R.drawable.fruits)
//            }
//            else ->  category_image.setBackgroundResource(R.drawable.vegetables)
//        }
//    }


}