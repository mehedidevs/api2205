package com.mehedi.platzi2205.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.platzi2205.data.models.login.RequestLogin
import com.mehedi.platzi2205.data.models.login.ResponseLogin
import com.mehedi.platzi2205.data.repositories.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel() {


    private var _response = MutableLiveData<Response<ResponseLogin>>()

    val loginResponse: LiveData<Response<ResponseLogin>> = _response


    fun login(requestLogin: RequestLogin) {

        viewModelScope.launch {

            _response.postValue(repo.login(requestLogin))

        }


    }


}