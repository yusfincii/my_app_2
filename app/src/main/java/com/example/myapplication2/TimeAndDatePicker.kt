package com.example.myapplication2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.databinding.TimeAndDatePickerBinding
import java.util.Calendar

class TimeAndDatePicker : AppCompatActivity() {

    private lateinit var designPickers:TimeAndDatePickerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        designPickers = TimeAndDatePickerBinding.inflate(layoutInflater)
        setContentView(designPickers.root)

        val calendar = Calendar.getInstance()

        designPickers.Time.setOnClickListener{
            // baslangicta secili saat tanimlamasi
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            val timePicker = TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { view, saat, dakika ->
                // layouta aktarilacak veri
                designPickers.Time.setText("$saat : $dakika")
            }, hour, minute, true)

            // baslik
            timePicker.setTitle("Saat")
            // buton isimlendirmeleri
            timePicker.setButton(DialogInterface.BUTTON_POSITIVE, "Set", timePicker)
            timePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", timePicker)

            timePicker.show()

        }

        designPickers.Date.setOnClickListener{
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)

            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, yil, ay, gun ->
                // ay 1 eksik olarak verildiginden +1 yapildi
                designPickers.Date.setText("$gun / ${ay+1} / $yil")
            }, year, month, day)

            datePicker.setTitle("Tarih")
            datePicker.setButton(DialogInterface.BUTTON_POSITIVE, "Set", datePicker)
            datePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", datePicker)
            datePicker.show()

        }
    }
}