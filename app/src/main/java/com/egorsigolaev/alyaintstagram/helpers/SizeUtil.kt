package com.egorsigolaev.alyaintstagram.helpers

import android.content.Context
import android.graphics.Point
import android.view.WindowManager

fun convertDpToPx(context: Context, dp: Float): Float{
    return dp * context.resources.displayMetrics.density;
}

fun convertPxToDp(context: Context, px: Float): Float{
    return px / context.resources.displayMetrics.density;
}

fun getScreenWidthInPx(context: Context): Int{
    val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size.x
}

fun getScreenHeightInPx(context: Context): Int{
    val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = wm.defaultDisplay
    val size = Point()
    display.getSize(size)
    return size.y
}