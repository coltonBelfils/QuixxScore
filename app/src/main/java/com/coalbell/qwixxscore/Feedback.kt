package com.coalbell.qwixxscore

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.colton.quixxscore.R

import kotlinx.android.synthetic.main.activity_feedback.*

class Feedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<WebView>(R.id.feedbackPage).apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSckIv5gITmWJGpuAVQw1gPvrDcj5eh8cZjVzbwGGzUCISKw1A/viewform?usp=sf_link")
        }
    }
}
