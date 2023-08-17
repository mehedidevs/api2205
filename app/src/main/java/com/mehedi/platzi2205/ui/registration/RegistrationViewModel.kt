package com.mehedi.platzi2205.ui.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mehedi.platzi2205.data.models.login.RequestLogin
import com.mehedi.platzi2205.data.models.login.ResponseLogin
import com.mehedi.platzi2205.data.models.registration.RequestRegistration
import com.mehedi.platzi2205.data.models.registration.ResponseRegistration
import com.mehedi.platzi2205.data.repositories.AuthRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repo: AuthRepo) : ViewModel() {


    private var _response = MutableLiveData<Response<ResponseRegistration>>()

    val registrationResponse: LiveData<Response<ResponseRegistration>> = _response


    fun registration(request: RequestRegistration) {
        viewModelScope.launch {
            _response.postValue(repo.registration(request))
        }


    }


}