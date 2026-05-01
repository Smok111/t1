package com.example.altokeyaa.ui.promo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.altokeyaa.ui.theme.Primary
import com.example.altokeyaa.ui.theme.Secondary
import com.example.altokeyaa.ui.theme.Tertiary

data class Promotion(
    val id: Int,
    val title: String,
    val description: String,
    val discount: String,
    val icon: String,
    val color: Color
)

@Composable
fun PromoScreen(onBack: () -> Unit = {}) {
    Scaffold(
        topBar = { PromoTopBar(onBack = onBack) }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF9F9F9))
        ) {
            item { PromoHeader() }

            val promotions = listOf(
                Promotion(1, "¡Descuento 30%!", "En tu primer pedido", "30%", "🎉", Primary),
                Promotion(2, "Envío Gratis", "Compras mayores a $50", "FREE", "🚚", Secondary),
                Promotion(3, "Doble puntos", "En bebidas y postres", "2x", "⭐", Tertiary),
                Promotion(4, "Desayuno al 50%", "Solo mañanas", "50%", "🥐", Color(0xFFA8D5BA)),
                Promotion(5, "Combos especiales", "Pizza + Bebida + Postre", "COMBO", "🍕", Color(0xFFFFD93D)),
                Promotion(6, "Cliente VIP", "Acumula puntos", "✓", "👑", Color(0xFFFF6B9D))
            )

            items(promotions) { promo ->
                PromoCard(promo)
            }

            item { Spacer(modifier = Modifier.height(30.dp)) }
        }
    }
}

@Composable
fun PromoTopBar(onBack: () -> Unit = {}) {
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
                text = "Promociones",
                color = Color.White,
                fontWeight = FontWeight.Black,
                fontSize = 24.sp
            )
            Text(
                text = "Ofertas exclusivas para ti",
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
fun PromoHeader() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Secondary.copy(alpha = 0.1f)),
        border = androidx.compose.foundation.BorderStroke(1.dp, Secondary)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Default.Info,
                contentDescription = null,
                tint = Secondary,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    "Promociones válidas esta semana",
                    fontWeight = FontWeight.Bold,
                    fontSize = 13.sp,
                    color = Color.Black
                )
                Text(
                    "No te pierdas nuestras mejores ofertas",
                    fontSize = 12.sp,
                    color = Color.Gray
                )
            }
        }
    }
}

@Composable
fun PromoCard(promo: Promotion) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(14.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Icon
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(promo.color.copy(alpha = 0.15f)),
                contentAlignment = Alignment.Center
            ) {
                Text(promo.icon, fontSize = 32.sp)
            }

            // Content
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = promo.title,
                    fontWeight = FontWeight.Black,
                    fontSize = 16.sp,
                    color = Color.Black
                )
                Text(
                    text = promo.description,
                    fontSize = 12.sp,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = promo.discount,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 14.sp,
                    color = promo.color
                )
            }

            // Arrow
            Icon(
                Icons.Default.ChevronRight,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

