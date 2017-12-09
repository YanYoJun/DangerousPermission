package com.plbear.yyj.dangerouspermission

import android.Manifest
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatTextView
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lab_test.setText("这是切换后的")
        if (lab_test is TextView) {
            Log.e(TAG, "lab_test is TextView")
        }
    }

    fun onClick_requestPermission(v: View) {
        if (ContextCompat.checkSelfPermission(applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0);
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        var i = 0;
        while (i < permissions.size) {
            Log.e(TAG, "permission:" + permissions[i] + " grantResult:" + grantResults[i])
            i++
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
