package com.example.states

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.states.ui.theme.StatesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        /*
        * ViewModelProvider(this)

          ViewModelProvider is a factory class that creates and manages ViewModel instances.
          this refers to the current Activity or Fragment, which acts as the lifecycle owner.
          This ensures the ViewModel survives configuration changes (e.g., screen rotation).
          [StateTestViewModel::class.java]

          This retrieves an instance of StateTestViewModel from ViewModelProvider.
          If the ViewModel does not exist, ViewModelProvider creates a new instance.
          If it already exists (e.g., after a screen rotation), the same instance is returned.
*/
        val viewModel = ViewModelProvider(this)[StateTestViewModel::class.java] //Create an instance of the ViewModel
        setContent {
            StateTesting(viewModel)
        }
    }
}
