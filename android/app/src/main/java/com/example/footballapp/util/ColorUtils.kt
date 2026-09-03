package com.example.footballapp.util

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance

object ColorUtils {

    /**
     * Parses a color string (e.g. "ffbb00", "#ffbb00", "0xffbb00", "red") into a Compose Color.
     */
    fun parseHexColor(value: String?): Color? {
        if (value.isNullOrBlank()) return null
        
        val cleaned = value.trim()
        
        // 1. Try parsing as-is (handles #RRGGBB, #AARRGGBB, and color names like "red")
        try {
            return Color(android.graphics.Color.parseColor(cleaned))
        } catch (e: Exception) {
            // Fall through
        }
        
        // 2. Try prepending # if it looks like a hex code without it
        try {
            val hex = cleaned.removePrefix("0x").removePrefix("#")
            val finalHex = when (hex.length) {
                3 -> hex.map { "$it$it" }.joinToString("")
                6 -> hex
                8 -> hex
                else -> null
            }
            
            if (finalHex != null) {
                return Color(android.graphics.Color.parseColor("#$finalHex"))
            }
        } catch (e: Exception) {
            // Fall through
        }
        
        return null
    }

    /**
     * Determines if a color is "light" or "dark" and returns an appropriate contrast color.
     */
    fun getContrastColor(background: Color): Color {
        return if (background.luminance() > 0.5f) Color.Black else Color.White
    }
}
