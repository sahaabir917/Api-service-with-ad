package com.example.apiservice3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    MobileAds.initialize(this,getString(R.string.app_id))
        val addrequest = AdRequest.Builder().build()
        adView.loadAd(addrequest)

    }
}
