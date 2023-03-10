package com.main.activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.main.activity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val activityResult = registerForActivityResult(ActivityResultContracts.
            StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val message = it.data?.getStringExtra("returnValue")
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            }
        }
        val intent = Intent(this, SubActivity::class.java)
        intent.putExtra("from1", "Hello World")
        intent.putExtra("from2", 2023)

        binding.button.setOnClickListener {activityResult.launch(intent)}
    }

    override fun onPause(){
        super.onPause()
        Toast.makeText(this, "Paused", Toast.LENGTH_LONG).show()
    }
}