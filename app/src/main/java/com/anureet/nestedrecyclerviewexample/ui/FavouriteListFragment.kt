package com.anureet.nestedrecyclerviewexample.ui

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.anureet.nestedrecyclerviewexample.R
import kotlinx.android.synthetic.main.fragment_favourite_list.*
import androidx.lifecycle.Observer


class FavouriteListFragment : Fragment() {

    private lateinit var viewModel: FavouriteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(FavouriteListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        with(card_list){
            layoutManager = LinearLayoutManager(activity)
            adapter = ItemAdapter (requireContext())
        }

        add_item.setOnClickListener{
            findNavController().navigate(
                FavouriteListFragmentDirections.actionFavouriteListFragmentToFavouriteDetailFragment(0)
            )
        }
        viewModel.items.observe(viewLifecycleOwner, Observer{
            (card_list.adapter as ItemAdapter).submitList(it)
        })


    }

}