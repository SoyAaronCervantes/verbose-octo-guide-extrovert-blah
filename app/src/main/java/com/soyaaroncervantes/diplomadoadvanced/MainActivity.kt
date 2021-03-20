package com.soyaaroncervantes.diplomadoadvanced

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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