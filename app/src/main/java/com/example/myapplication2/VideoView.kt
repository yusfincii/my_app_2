package com.example.myapplication2

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.databinding.VideoViewBinding

class VideoView : AppCompatActivity() {
    private lateinit var designVideoView : VideoViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        designVideoView = VideoViewBinding.inflate(layoutInflater)
        setContentView(designVideoView.root)

        designVideoView.start.setOnClickListener{
            val adress = Uri.parse("android.resource://"+packageName+"/"+R.raw.ets_video)
            designVideoView.videoView.setVideoURI(adress)
            designVideoView.videoView.start()
        }

        designVideoView.stop.setOnClickListener{
            designVideoView.videoView.stopPlayback()
        }



    }
}