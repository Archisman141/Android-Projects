package com.example.states

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StateTestViewModel:ViewModel(){
    /*
    * Declares a private mutable LiveData _name that holds a String value.
    MutableLiveData allows us to update the data it holds.
    This is private to ensure that only the ViewModel can modify its value.
    * */
    private val _name = MutableLiveData<String>()
    private val _surname = MutableLiveData<String>()
    //It can be modified by the ViewModel
    /*Exposes a read-only LiveData<String> named name to observers (like UI components).
    LiveData is an observable data holder that automatically updates the UI when data changes.
    Since it's a LiveData, the UI can observe name but cannot modify it directly.*/
    val name: LiveData<String> = _name
    val surname: LiveData<String> = _surname
    //Read only LiveData to observe the data it cannot be modified\

    fun onNameUpdate(newName: String) {
        _name.value = newName
    }
    fun onSurnameUpdate(newSurname: String) {
        _surname.value = newSurname

    }
}