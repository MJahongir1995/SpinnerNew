package com.example.spinnernew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import com.example.spinnernew.adapters.SpinnerAdapter
import com.example.spinnernew.databinding.ActivityMainBinding
import com.example.spinnernew.models.Fruits

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var list:ArrayList<Fruits>
    private lateinit var spinnerAdapter: SpinnerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.mySpinner.onItemSelectedListener = object : OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@MainActivity, list[p2].name, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        list = ArrayList()
        list.add(Fruits("Apple",R.drawable.apple))
        list.add(Fruits("Banana", R.drawable.banana))
        list.add(Fruits("Peach", R.drawable.peach))
        list.add(Fruits("Mango", R.drawable.mango))

        spinnerAdapter = SpinnerAdapter(list)
        binding.mySpinner.adapter = spinnerAdapter
    }
}