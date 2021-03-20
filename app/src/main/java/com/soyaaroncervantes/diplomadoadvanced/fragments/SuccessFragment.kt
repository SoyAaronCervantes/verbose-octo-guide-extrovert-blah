package com.soyaaroncervantes.diplomadoadvanced.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.button.MaterialButton
import com.soyaaroncervantes.diplomadoadvanced.R

class SuccessFragment : Fragment() {

  lateinit var loginFragment: LoginFragment

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_success, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    loginFragment = LoginFragment()

    val goToLoginButton: MaterialButton = view.findViewById(R.id.goToLoginButton);

    goToLoginButton.setOnClickListener {

      val fragmentManager = activity?.supportFragmentManager?.beginTransaction()
      fragmentManager?.replace( R.id.container, loginFragment );
      fragmentManager?.commit()

    }

  }
}