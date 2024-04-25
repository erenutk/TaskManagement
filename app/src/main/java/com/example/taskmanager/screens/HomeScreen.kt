package com.example.taskmanager.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.taskmanager.components.pool.Pool

@Composable
fun HomeScreen(){

    Column(
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.9f)
            .padding(top = 10.dp, start = 20.dp, end = 10.dp)
    ) {
        Button(onClick = { }) {
            Icon(imageVector = Icons.Default.Notifications, contentDescription = null )
        }
        Pool("Open", Color(0x666650a4))
        Pool("Active", Color(0x666790a4))
    }

}