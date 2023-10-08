package com.example.composedemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView

class TestFragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test2, container, false)
        view.findViewById<ComposeView>(R.id.compose_view).setContent {
            // set compose view here ,so we can combine both xml and compose views.
        }
        return view
    }

}