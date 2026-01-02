package com.lugalokinho.kotlintutorialpractice.features.business_card

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lugalokinho.kotlintutorialpractice.R

data class ContactInfoData(
    val icon: ImageVector,
    val info: String
)

@Composable
private fun PresentationInfo(
    name: String,
    description: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 8.dp)
                .background(Color(0xFF0C3F08), shape = CircleShape)
                .padding(16.dp)
        )
        Text(
            text = name,
            fontSize = 20.sp,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = description,
            fontSize = 14.sp,
            color = Color(0xFF0C3F08)
        )
    }
}

@Composable
private fun ContactInfo(info: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = modifier
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF0C3F08),
            modifier = modifier.size(14.dp),
        )
        Spacer(
            modifier = modifier.width(16.dp)
        )
        Text(
            text = info,
            fontSize = 14.sp
        )
    }
}

@Composable
fun BusinessCardScreen(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    val name = "Lugalokinho"
    val description = "Mobile developer"
    val phone = "+55 (14) 99668 0161"
    val github = "lugalokinho"
    val email = "luizjarduli@gmail.com"
    val infos = listOf(
        ContactInfoData(Icons.Default.Call, phone),
        ContactInfoData(Icons.Default.Share, github),
        ContactInfoData(Icons.Default.Email, email)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF0C3F08).copy(alpha = 0.2f))
    ) {
        PresentationInfo(
            name = name,
            description = description,
            image = image,
            modifier = modifier.weight(2f)
        )
        Column(verticalArrangement = Arrangement.Center, modifier = Modifier.weight(1f)) {
            infos.forEach { 
                ContactInfo(
                    info = it.info,
                    icon = it.icon,
                )
            }
        }
    }
}