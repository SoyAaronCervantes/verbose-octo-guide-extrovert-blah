package com.soyaaroncervantes.diplomadoadvanced.fragments

import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import com.soyaaroncervantes.diplomadoadvanced.R

class LoginFragment : Fragment() {

  lateinit var successFragment: SuccessFragment
  lateinit var errorFragment: ErrorFragment
  private val userTest: Map<String, String> = mapOf( "asd@asd.com" to "asdqwe123" );

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_login, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState);

    successFragment = SuccessFragment()
    errorFragment = ErrorFragment()

    /** Text Input */
    val emailInput: TextInputLayout = view.findViewById(R.id.emailTextInput)
    val passwordInput: TextInputLayout = view.findViewById(R.id.passwordTextInput)

    /** Button Submit */
    val submitButton: MaterialButton = view.findViewById(R.id.submitButton)

    /** Get Password Text */
    val passwordText = passwordInput.editText!!.text

    /** Get Email Text */
    val emailText = emailInput.editText!!.text

    /** Add onClick Listener */
    submitButton.setOnClickListener {

      // toDO add a validator for email Input with a ReGex
      // your code...

      /** Validate password */
      val passwordValidated = isPasswordValidate(passwordText)
      passwordInput.error = if ( !passwordValidated ) "Password must contain at least 8 characters" else null

      val checkEmail = userTest.contains( emailText.toString() );
      // emailInput.error = if ( !checkEmail ) "Your email isn't validate" else null
      var checkPassword = false

      if ( checkEmail ) {
        val password = userTest.getValue( emailText.toString() )
        checkPassword = password == passwordText.toString();
      }

      Log.d("[Debug] Check Email", checkEmail.toString() )
      Log.d("[Debug] Check Password", checkPassword.toString() )

      val fragmentManager = activity?.supportFragmentManager?.beginTransaction()

      if ( checkEmail && checkPassword ) {
        fragmentManager?.replace( R.id.container, successFragment );
      } else {
        fragmentManager?.replace( R.id.container, errorFragment );
      }

      fragmentManager?.commit()

    }

    /** Add text Listener */
    passwordInput.editText!!.addTextChangedListener {
      val passwordValidated = isPasswordValidate(passwordText)
      if ( passwordValidated ) { passwordInput.error = null }
    }

  }

  /** Func, check if text is longer or equal to 8 characters */
  private fun isPasswordValidate(text: Editable): Boolean {
    return text.length >= 8
  }

}