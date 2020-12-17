package com.udacity.shoestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * View Model for the Shoe Store shared by all the fragments
 */
class ShoeStoreViewModel : ViewModel() {

    private var _shoeList: MutableLiveData<List<Shoe>> = MutableLiveData<List<Shoe>>()
    val shoeList:LiveData<List<Shoe>>
            get()=_shoeList
    private val _loggedIn = MutableLiveData<Boolean>()
    val loggedIn:LiveData<Boolean>
        get() = _loggedIn

    private var list = ArrayList<Shoe>()

    fun addShoe(shoe: Shoe) {
        list.add(shoe)
        _shoeList.value = list
    }

    fun onLogin() {
        _loggedIn.value = true
    }
}