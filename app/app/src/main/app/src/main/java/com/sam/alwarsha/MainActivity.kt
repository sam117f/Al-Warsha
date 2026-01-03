package com.sam.alwarsha

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AlWarshaScreen()
            }
        }
    }
}

@Composable
fun AlWarshaScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF121212)) // Dark Background
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // 1. Header (Bilingual)
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "AL-WARSHA", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(text = "الورشة التقنية", color = Color(0xFF00E5FF), fontSize = 22.sp, fontWeight = FontWeight.Bold)
        
        Spacer(modifier = Modifier.height(40.dp))

        // 2. Status Cards
        InfoCard("CPU Temp", "حرارة المعالج", "36°C", Color.Green)
        InfoCard("RAM Usage", "الذاكرة العشوائية", "72%", Color(0xFFFF9800))
        InfoCard("Battery", "البطارية", "Good | جيدة", Color.Green)

        Spacer(modifier = Modifier.weight(1f))

        // 3. Action Button
        Button(
            onClick = { /* Logic later */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00E5FF)),
            modifier = Modifier.fillMaxWidth().height(60.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = "SCAN & FIX | فحص وإصلاح",
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun InfoCard(labelEn: String, labelAr: String, value: String, statusColor: Color) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(text = labelEn, color = Color.Gray, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                Text(text = labelAr, color = Color.LightGray, fontSize = 14.sp)
            }
            Text(text = value, color = statusColor, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}
