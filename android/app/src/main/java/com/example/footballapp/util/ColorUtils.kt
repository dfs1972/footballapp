package com.example.footballapp.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

object ColorUtils {

    /**
     * Parses a hex color string (e.g. "ffbb00" or "#ffbb00") into a Compose Color.
     */
    fun parseHexColor(value: String?): Color? {
        if (value.isNullOrBlank()) return null
        
        return try {
            val hex = value.trim().removePrefix("#")
            if (hex.length != 6) return null
            
            Color(android.graphics.Color.parseColor("#$hex"))
        } catch (e: Exception) {
            null
        }
    }

    /**
     * Determines if a color is "light" or "dark" and returns an appropriate contrast color.
     */
    fun getContrastColor(background: Color): Color {
        return if (background.luminance() > 0.5f) Color.Black else Color.White
    }
}
