package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.databinding.ImageViewBinding

class ImageView : AppCompatActivity() {

    private lateinit var designImageView:ImageViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        designImageView = ImageViewBinding.inflate(layoutInflater)
        setContentView(designImageView.root)

        designImageView.resim1.setOnClickListener{
            designImageView.imageView.setImageResource(R.drawable.resim)
        }

        designImageView.resim2.setOnClickListener{
            designImageView.imageView.setImageResource(resources.getIdentifier(
                "vector_resim", "drawable", packageName))
        }

    }
}