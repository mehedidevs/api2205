package com.mehedi.platzi2205.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.platzi2205.data.models.profile.ResponseProfile
import com.mehedi.platzi2205.data.models.registration.RequestRegistration
import com.mehedi.platzi2205.data.models.registration.ResponseRegistration
import com.mehedi.platzi2205.data.repositories.UserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repo: UserRepo) : ViewModel() {


    private var _response = MutableLiveData<Response<ResponseProfile>>()

    val profileResponse: LiveData<Response<ResponseProfile>> = _response


    init {
        profile()
    }


    private fun profile() {
        viewModelScope.launch {
            _response.postValue(repo.profile())
        }


    }


}