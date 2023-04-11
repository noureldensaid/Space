package com.spc.space.ui.auth.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.spc.space.R
import com.spc.space.databinding.FragmentLoginBinding
import com.spc.space.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentLoginBinding.bind(view)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
         }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}