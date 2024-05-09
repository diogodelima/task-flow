package com.diogo.taskflow

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.diogo.taskflow.ui.theme.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("NewApi")
@Composable
fun header(onAddButtonClick: () -> Unit){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(headerBackground),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 12.dp),
            text = "Tarefas",
            fontSize = 20.sp,
            color = Color.White
        )

        Box(
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .background(
                    color = addBackground,
                    shape = CircleShape
                )
                .width(40.dp)
                .height(40.dp)
        ){
            IconButton(onClick = {
                onAddButtonClick()
            }){
                Icon(
                    imageVector = Icons.Rounded.Add,
                    contentDescription = "Add Task",
                    tint = Color.White
                )
            }
        }

    }

}

@Composable
@Preview
fun headerPreview(){
    header {}
}