package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding


/**
 * Fragment for the Shoe Store Login screen
 */
class LoginFragment : Fragment() {

    // Define viewModel as by activityViewModels, since it is shared by fragments of the activity
    private val viewModel: ShoeStoreViewModel by activityViewModels<ShoeStoreViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container, false
        )
        //Set click listeners for the New Login and Existing User Login
        binding.newloginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            //Save the login state
            viewModel.onLogin()
        }

        binding.existingLoginButton.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            //Save the login state
            viewModel.onLogin()
        }
        return binding.root
    }
}
