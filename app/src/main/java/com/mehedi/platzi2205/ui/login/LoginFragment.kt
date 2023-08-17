package com.mehedi.platzi2205.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehedi.platzi2205.R
import com.mehedi.platzi2205.base.BaseFragment
import com.mehedi.platzi2205.data.models.login.RequestLogin
import com.mehedi.platzi2205.databinding.FragmentLoginBinding
import com.mehedi.platzi2205.utils.Keys
import com.mehedi.platzi2205.utils.PrefManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {


    private val viewModel: LoginViewModel by viewModels()

    @Inject
    lateinit var prefManager: PrefManager


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loginResponse.observe(viewLifecycleOwner) {

            if (it.isSuccessful) {
                binding.loading.visibility = View.GONE

                prefManager.setPref(Keys.ACCESS_TOKEN, it.body()?.accessToken!!)
                prefManager.setPref(Keys.REFRESH_TOKEN, it.body()?.refreshToken!!)




                findNavController().navigate(R.id.action_loginFragment_to_profileFragment)
              //  findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

            }


        }

        binding.registerBtn.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_reagisterFragment)

        }




        binding.loginBtn.setOnClickListener {
            binding.loading.visibility = View.VISIBLE

            val email = binding.userEmail.text.toString()
            val password = binding.password.text.toString()


            // handleLogin(email, password)
          //  handleLogin("john@mail.com", "changeme")
            handleLogin("user@gmail.com", "123456")

        }


    }


    private fun handleLogin(email: String, password: String) {

        val requestLogin = RequestLogin(email = email, password = password)

        viewModel.login(requestLogin)
    }
}