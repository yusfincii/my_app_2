package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.databinding.WebViewBinding

class WebView : AppCompatActivity() {

    private lateinit var designWebView : WebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        designWebView = WebViewBinding.inflate(layoutInflater)
        setContentView(designWebView.root)

        designWebView.webView.settings.javaScriptEnabled = true

        // https olmali
        designWebView.webView.loadUrl("https://dev.to/ruppysuppy/git-cheat-sheet-with-40-commands-concepts-1m26")

        // http icin manifest:16 incele
        // yuklu internet uygulamasi uzerinden acilir
        designWebView.webView.loadUrl("http://dev.to/ruppysuppy/git-cheat-sheet-with-40-commands-concepts-1m26")
    }
}