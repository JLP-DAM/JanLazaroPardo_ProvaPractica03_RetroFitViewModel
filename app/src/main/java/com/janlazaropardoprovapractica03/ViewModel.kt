package com.janlazaropardoprovapractica03

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ViewModel: ViewModel() {
    private val _user = MutableLiveData<Usuari>()
    val user: LiveData<Usuari> = _user

    private val _reservations = MutableLiveData<List<Reserva>>()
    val reservations: LiveData<List<Reserva>> = _reservations
    fun login(username: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            var foundUser: Usuari? = null

            try {
                foundUser = API.API().login(Usuari(null, username, null, password)).body()
            } catch(exception: Exception) {}

            if (foundUser == null) {
                return@launch
            }

            withContext(Dispatchers.Main) {
                _user.value = foundUser
            }
        }
    }

    fun getReservations() {
        viewModelScope.launch(Dispatchers.IO) {
            if (user.value == null) {return@launch}

            var foundReservations: List<Reserva>? = null

            try {
                foundReservations = API.API().getReservations(user.value!!.id!!).body()
            } catch(exception: Exception) {}

            if (foundReservations == null) {
                return@launch
            }

            withContext(Dispatchers.Main) {
                _reservations.value = foundReservations
            }
        }
    }
}