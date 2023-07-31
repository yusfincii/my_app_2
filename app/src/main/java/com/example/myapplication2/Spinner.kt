package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.myapplication2.databinding.SpinnerBinding
import java.util.ArrayList

class Spinner : AppCompatActivity() {

    private lateinit var designSpinner:SpinnerBinding

    private val countries = ArrayList<String>()
    private lateinit var adapterX:ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        designSpinner = SpinnerBinding.inflate(layoutInflater)
        setContentView(designSpinner.root)

        countries.add("Turkey")
        countries.add("Iraq")
        countries.add("Portugal")
        countries.add("Rwanda")
        countries.add("Canada")
        countries.add("Japan")
        countries.add("Malaysia")
        countries.add("Kongo Republic")

        adapterX = ArrayAdapter(this, android.R.layout.simple_list_item_2, android.R.id.text2, countries)
        designSpinner.spinner.adapter = adapterX

        designSpinner.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val country = countries[position].uppercase()
                Toast.makeText(applicationContext, "Choosed country : $country", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        designSpinner.buttonShow.setOnClickListener{
            Toast.makeText(applicationContext, "Country : ${countries[designSpinner.spinner.selectedItemPosition]}"
                , Toast.LENGTH_SHORT).show()
        }


    }
}