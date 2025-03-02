package com.example.states

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun StateTesting(viewModel: StateTestViewModel) {
    Log.i("MYTAG", "StateTesting: ")
//    var name = remember { /*Now this remember function will remember the value of the name variable but it do
//    not remember the value when the configuration is changed*/
//        mutableStateOf("")
//    }
    //Now this rememberSaveable function will remember the value of the name variable even if the configuration is changed
//    var name = rememberSaveable() { //it persistance on configuration change
//        mutableStateOf("")
//    }
    val name = viewModel.name.observeAsState(initial = "")
    val surname = viewModel.surname.observeAsState(initial = "")
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyText("${name.value} ${surname.value}")
        MyTextField(name.value, onNameChange = {
            viewModel.onNameUpdate(it)
        })
        MyTextField(surname.value, onNameChange = {
            viewModel.onSurnameUpdate(it)
        })
    }
}

@Composable
fun MyText(name: String) {
    Text("Hello $name", style = TextStyle(fontSize = 30.sp))
}

@Composable
fun MyTextField(name: String,onNameChange: (String) -> Unit) {

    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameChange(it)
        },
        label = { Text("Name") }
    )
}