package com.example.marsapi

import com.google.gson.annotations.SerializedName

data class FootballList(@SerializedName("data") var data :List<FootballData>)