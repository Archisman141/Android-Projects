package com.example.listdemoapp

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



//The main difference between LazyColumn and Column is that Column will render all the items in the screen even if they are not visible.
//But the LazyColumn will render only the visible items and not all the items. The other items will only be visible when the user scrolls.
@Composable
fun ListDemo(modifier: Modifier = Modifier) {
    //SimpleColumn() // SimpleList()
    LazyColumnDemo() // LazyList()
}

@Composable
fun SimpleColumn(modifier: Modifier = Modifier) {
    var scrollState = rememberScrollState()
    Column(
        modifier = modifier.verticalScroll(scrollState)
    ){
        for(i in 1..100){
            TextDemo(text = "Item $i")
        }
    }
}

//Now if the list is dynamic we can use LazyColumn instead of Column

@Composable
fun LazyColumnDemo() {
//    var myList = listOf<String>("A","B","C","D","E","F","G","H")
    var myList = getAllMarvelChar()
    LazyColumn (content = {
//        items(100, itemContent = {
//            TextDemo(text = "Item $it")
//        })
        itemsIndexed(myList,itemContent = { index, item ->
//            TextDemo(text = "Item ${item.name}")
            MarvelItem(item = item)
        })
    })
}

@Composable
fun MarvelItem(item: MarvelChar) { //This function contain all the images and the text associated with the app
    var context = LocalContext.current
    Row(
        modifier = Modifier.fillMaxWidth().padding(16.dp).clickable{
            Toast.makeText(context,"Clicked on ${item.name}",Toast.LENGTH_SHORT).show()
        }
    ){
        Image(painter = painterResource(id = item.imageRes),
            contentDescription = "{$item.name}",
            modifier = Modifier.clip(CircleShape).size(64.dp).scale(1.0f)
        )
        Column (
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            horizontalAlignment = Alignment.Start

        ){
            Text(
                text = item.charName,
                style = TextStyle(fontSize = 20.sp,fontWeight = FontWeight.Bold)
            )
            Text(
                text = item.name,
                style = TextStyle(fontSize = 18.sp)
            )
        }
    }
}
 //This function is responsible for maintaining the Text Alignment, text size
@Composable
fun TextDemo(text:String) {
    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        textAlign = TextAlign.Center,
        fontSize = 20.sp
    )
}