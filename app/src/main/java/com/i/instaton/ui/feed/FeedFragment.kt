package com.i.instaton.ui.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.i.instaton.R
import com.i.instaton.databinding.FragmentFeedBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()
    private val feedAdapter = FeedRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed") //TODO: turn into enum
        feed?.let{
            viewModel.updateFeed(it)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentFeedBinding.inflate(inflater,container,false)

        binding.rvGalleryFeed.layoutManager = LinearLayoutManager(requireContext())
        binding.rvGalleryFeed.adapter = feedAdapter

        viewModel.feed.observe(viewLifecycleOwner){
            feedAdapter.submitList(it)
        }

        return binding.root
    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
//        // TODO: Use the ViewModel
//    }

}