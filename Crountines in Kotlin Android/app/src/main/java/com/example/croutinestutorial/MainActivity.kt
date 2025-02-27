package com.example.croutinestutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import com.example.croutinestutorial.crountinecontext.TestDispatchers
import com.example.croutinestutorial.crountinecontext.TestWithContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        TestDispatchers.runMyFirstCoroutines()
        TestWithContext.TestWithContextFunc()



    }
}

