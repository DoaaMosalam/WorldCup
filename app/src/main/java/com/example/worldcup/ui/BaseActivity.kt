package com.example.worldcup.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB:ViewBinding>: AppCompatActivity(){
    abstract val LOG_TAG:String
    abstract val bindingInflater:(LayoutInflater) -> VB
    private lateinit var _binding:ViewBinding
    protected val binding
        get() = _binding as VB?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater(layoutInflater)
        setContentView(_binding.root)


        setUp()
        addCallBacks()
    }
    abstract fun setUp()
    abstract fun addCallBacks()

    protected fun log(value:Any){
        Log.v(LOG_TAG,value.toString())
    }

}