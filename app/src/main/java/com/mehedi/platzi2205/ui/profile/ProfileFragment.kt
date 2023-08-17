package com.mehedi.platzi2205.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import coil.load
import coil.request.CachePolicy
import com.mehedi.platzi2205.R
import com.mehedi.platzi2205.base.BaseFragment
import com.mehedi.platzi2205.databinding.FragmentProfileBinding
import com.mehedi.platzi2205.utils.load
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileFragment : BaseFragment<FragmentProfileBinding>(FragmentProfileBinding::inflate) {

    private val viewModel: ProfileViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.profileResponse.observe(viewLifecycleOwner) {

            if (!it.isSuccessful) return@observe

            binding.apply {

                it.body()?.let { profile ->
                    nameTextView.text = profile.name
                    emailTextView.text = profile.email
                    roleTextView.text = profile.role
                    nameTextView.text = profile.name

                    profileImageView.load(profile.avatar)


                }
            }


        }


    }


}