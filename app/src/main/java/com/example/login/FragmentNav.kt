package com.example.login

import androidx.fragment.app.Fragment

interface FragmentNav {
    fun navFragment(fragment: Fragment, addToStack: Boolean)
}