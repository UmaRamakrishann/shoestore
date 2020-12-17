package com.udacity.shoestore

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoelistBinding


/**
 * Fragment for the Shoe List screen
 */
class ShoeListFragment : Fragment() {

    // Define viewModel as by activityViewModels, since it is shared by fragments of the activity
    private val viewModel: ShoeStoreViewModel by activityViewModels<ShoeStoreViewModel>()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentShoelistBinding>(
            inflater, R.layout.fragment_shoelist, container, false
        )
        setHasOptionsMenu(true)
        binding.addShoeButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }
        //Build the Shoes List observing the shoes added in the Shoe detail fragment
        viewModel.shoeList.observe(this.viewLifecycleOwner, Observer { newShoeList ->
            newShoeList.forEach {
                val textView = TextView(this.context)
                textView.setTextAppearance(R.style.label_style)
                textView.text =
                    it.name + "-" + it.size + "->" + it.company + "\n" + it.description + "\n"
                binding.linearLayout.addView(textView)
            }
        })
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //Inflate the menu
        val inflater: MenuInflater = inflater
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = this.findNavController()
        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item)
    }


}
