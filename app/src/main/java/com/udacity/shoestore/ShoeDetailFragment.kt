package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

/**
 * Fragment for the Shoe Detail screen
 */
class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding
    private val shoe: Shoe = Shoe()

    // Define viewModel as by activityViewModels, since it is shared by fragments of the activity
    private val viewModel: ShoeStoreViewModel by activityViewModels<ShoeStoreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_shoe_detail, container, false
        )
        binding.shoe = shoe
        //Set Button onClick listeners
        binding.saveButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
            viewModel.addShoe(shoe)
        }
        binding.cancelButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }
        return binding.root
    }

}

