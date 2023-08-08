package com.mehedi.platzi2205.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehedi.platzi2205.R
import com.mehedi.platzi2205.data.models.login.RequestLogin
import com.mehedi.platzi2205.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding


    val viewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater, container, false)


        viewModel.loginResponse.observe(viewLifecycleOwner) {

            if (it.isSuccessful) {
                binding.loading.visibility = View.GONE



                findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

            }


        }


        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginBtn.setOnClickListener {
            binding.loading.visibility = View.VISIBLE

            val email = binding.userEmail.text.toString()
            val password = binding.password.text.toString()


            // handleLogin(email, password)
            handleLogin("john@mail.com", "changeme")

        }


    }


    private fun handleLogin(email: String, password: String) {

        val requestLogin = RequestLogin(email = email, password = password)

        viewModel.login(requestLogin)
    }
}