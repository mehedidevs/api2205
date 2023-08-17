package com.mehedi.platzi2205.ui.registration


import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.mehedi.platzi2205.R
import com.mehedi.platzi2205.base.BaseFragment
import com.mehedi.platzi2205.data.models.registration.RequestRegistration
import com.mehedi.platzi2205.databinding.FragmentReagisterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<FragmentReagisterBinding>(FragmentReagisterBinding::inflate) {

    private val viewModel: RegistrationViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.registrationResponse.observe(viewLifecycleOwner) {

            if (it.isSuccessful) {
                findNavController().navigate(R.id.action_reagisterFragment_to_loginFragment)
            }


        }




        binding.registerBtn.setOnClickListener {

            val name = binding.userName.text.toString()
            val email = binding.userEmail.text.toString().trim()
            val password = binding.password.text.toString().trim()
            val imageAvatar = "https://dmarkcy.com/images/team/web/mehedi.png"

            val registerRequest = RequestRegistration(
                avatar = imageAvatar,
                email = email,
                name = name,
                password = password
            )

            viewModel.registration(registerRequest)


        }


    }


}