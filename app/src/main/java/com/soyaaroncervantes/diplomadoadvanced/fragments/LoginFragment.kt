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
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.soyaaroncervantes.diplomadoadvanced.R

class LoginFragment : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_login, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState);
    val submitButton: MaterialButton = view.findViewById(R.id.submitButton)
    val passwordInput: TextInputLayout = view.findViewById(R.id.passwordTextInput)
    val passwordInputEdit: TextInputEditText = view.findViewById(R.id.passwordTextInputEdit)

    val textInput = passwordInput.editText?.text!!
    val textInputEditable = passwordInputEdit.editableText;

    val validatedInput = isPasswordValidate(textInput)
    val validatedInputEdit = isPasswordValidate(textInputEditable)

    submitButton.setOnClickListener {
      Log.d("[Debug] Something here", "asdasd")
      if (!validatedInput) {
        passwordInput.error = "Password must contain at least 8 characters"
      } else {
        passwordInput.error = null
      }
    }

    passwordInput.editText!!.addTextChangedListener {
      if (validatedInput) {
        passwordInput.error = null
      }
    }
  }

  private fun isPasswordValidate(text: Editable): Boolean {
    return text.length >= 8
  }
}