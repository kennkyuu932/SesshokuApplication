package com.example.sesshokuapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sesshokuapplication.databinding.ActivityMainBinding
import com.example.sesshokuapplication.room.RoomActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Example of a call to a native method
//        binding.sampleText.text = stringFromJNI()
//        Log.d(TAG, "BoringTest: "+BoringTest())

        binding.addData.setOnClickListener {
            val intent: Intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * A native method that is implemented by the 'sesshokuapplication' native library,
     * which is packaged with this application.
     */
    external fun stringFromJNI(): String

    //external fun BoringTest(): Int

    companion object {
        // Used to load the 'sesshokuapplication' library on application startup.
        init {
            System.loadLibrary("sesshokuapplication")
        }
    }
}