package com.example.e16m5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.e16m5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Adapter.PaisCallBack {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
    }

    private fun initAdapter() {
        val adapter = Adapter()
        adapter.setData(PaisesLatam.paises)
        adapter.setPaisCallBack(this)
        binding.rv.adapter = adapter
    }

    override fun showCountry(s: String){
        binding.habitantestxt.text = s
    }

}