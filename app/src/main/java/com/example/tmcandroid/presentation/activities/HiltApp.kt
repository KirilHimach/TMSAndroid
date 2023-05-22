package com.example.tmcandroid.presentation.activities

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

//Step 1. Create HiltApp after implemented
// dependencies in Gradle and corrected Manifest.xml.
@HiltAndroidApp
class HiltApp : Application()