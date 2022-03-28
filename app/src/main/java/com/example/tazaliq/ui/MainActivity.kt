package com.example.tazaliq.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.tazaliq.R
import com.yandex.mapkit.MapKitFactory


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.setApiKey("1d18fce9-0433-40d7-ac96-3b86d997da9f")
        MapKitFactory.initialize(this)
        setContentView(R.layout.activity_main)
        navController = findNavController(R.id.root_nav_host)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_DENIED) {
                Log.d("permission", "permission denied to SEND_SMS - requesting it")
                val permissions = arrayOf<String>(Manifest.permission.SEND_SMS)
                requestPermissions(permissions, 404)
            }
        }
    }
}