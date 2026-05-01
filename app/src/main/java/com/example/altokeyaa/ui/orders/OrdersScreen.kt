package com.example.altokeyaa.ui.orders

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.altokeyaa.ui.theme.Primary
import com.example.altokeyaa.ui.theme.Secondary
import com.example.altokeyaa.ui.theme.Tertiary

data class Order(
    val id: String,
    val merchant: String,
    val status: String,
    val date: String,
    val amount: String,
    val icon: String,
    val statusColor: Color,
    val items: List<String>
)

@Composable
fun OrdersScreen(onBack: () -> Unit = {}) {
    Scaffold(
        topBar = { OrdersTopBar(onBack = onBack) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF9F9F9))
        ) {
            item { OrdersHeader() }

            val orders = listOf(
                Order(
                    "#PE001",
                    "Starbucks",
                    "Entregado",
                    "Hoy, 10:30 AM",
                    "S/. 12.50",
                    "☕",
                    Color(0xFF4CAF50),
                    listOf("Latte grande", "Croissant")
                ),
                Order(
                    "#PE002",
                    "McDonald's",
                    "En camino",
                    "Hoy, 11:00 AM",
                    "S/. 18.99",
                    "🍔",
                    Secondary,
                    listOf("Big Mac", "Papas medianas", "Gaseosa")
                ),
                Order(
                    "#PE003",
                    "Subway",
                    "Preparando",
                    "Hoy, 12:15 PM",
                    "S/. 14.50",
                    "🥖",
                    Tertiary,
                    listOf("Sándwich pollo", "Bebida")
                ),
                Order(
                    "#PE004",
                    "Pizza Hut",
                    "Entregado",
                    "Ayer, 8:45 PM",
                    "S/. 22.00",
                    "🍕",
                    Color(0xFF4CAF50),
                    listOf("Pizza Mediana", "Tabla de quesos")
                ),
                Order(
                    "#PE005",
                    "Farmacia Cruz Azul",
                    "Entregado",
                    "Ayer, 3:20 PM",
                    "S/. 45.75",
                    "💊",
                    Color(0xFF4CAF50),
                    listOf("Medicinas varias")
                )
            )

            items(orders) { order ->
                OrderCard(order)
            }

            item { Spacer(modifier = Modifier.height(30.dp)) }
        }
    }
}

@Composable
fun OrdersTopBar(onBack: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Primary)
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        IconButton(
            onClick = onBack,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Volver",
                tint = Color.White
            )
        }
        
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Mis Pedidos",
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 24.sp
            )
            Text(
                text = "Historial de compras",
                color = Color.White.copy(alpha = 0.8f),
                fontSize = 13.sp
            )
        }
        
        Row(modifier = Modifier.align(Alignment.CenterEnd)) {
            IconButton(onClick = { }) {
                Icon(Icons.Outlined.Notifications, contentDescription = null, tint = Color.White)
            }
            IconButton(onClick = { }) {
                Icon(Icons.Outlined.ShoppingCart, contentDescription = null, tint = Color.White)
            }
        }
    }
}

@Composable
fun OrdersHeader() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Tertiary.copy(alpha = 0.1f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, Tertiary)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.LocalShipping,
                contentDescription = null,
                tint = Tertiary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    "Rastreo en tiempo real",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.Black
                )
                Text(
                    "Conoce el estado de tus pedidos",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun OrderCard(order: Order) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(Color(0xFFF0F0F0)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(order.icon, fontSize = 24.sp)
                    }

                    Column {
                        Text(
                            text = order.merchant,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                        Text(
                            text = order.date,
                            fontSize = 11.sp,
                            color = Color.Gray
                        )
                    }
                }

                Text(
                    text = order.amount,
                    fontWeight = FontWeight.Black,
                    fontSize = 16.sp,
                    color = Primary
                )
            }

            // Divider
            Divider(color = Color(0xFFEEEEEE), thickness = 1.dp)

            // Items
            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                order.items.forEach { item ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Icons.Default.Check,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = item,
                            fontSize = 12.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

            // Status Badge
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(8.dp)
                            .clip(CircleShape)
                            .background(order.statusColor)
                    )
                    Text(
                        text = order.status,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 12.sp,
                        color = order.statusColor
                    )
                }

                Text(
                    text = order.id,
                    fontSize = 10.sp,
                    color = Color.LightGray
                )
            }

            // Action Button
            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(36.dp),
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Primary.copy(alpha = 0.1f)),
                contentPadding = PaddingValues(0.dp)
            ) {
                Text(
                    "Ver detalles",
                    color = Primary,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 12.sp
                )
            }
        }
    }
}

