package com.soyaaroncervantes.diplomadoadvanced

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.FrameMetrics
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.soyaaroncervantes.diplomadoadvanced.fragments.ErrorFragment
import com.soyaaroncervantes.diplomadoadvanced.fragments.LoginFragment

class MainActivity : AppCompatActivity() {

  lateinit var loginFragment: LoginFragment
  lateinit var errorFragment: ErrorFragment

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    loginFragment = LoginFragment()
    errorFragment = ErrorFragment()

    initFragment( loginFragment )

  }

  private fun initFragment( fragment: Fragment ) {
    val fragmentManager = supportFragmentManager.beginTransaction()
    fragmentManager.replace( R.id.container, fragment )
    fragmentManager.commit()
  }

}