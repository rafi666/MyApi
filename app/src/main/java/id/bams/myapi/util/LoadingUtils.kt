package id.bams.myapi.util

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import id.bams.myapi.R

fun showloading(cotext: Context, swipeRefreshLayout: SwipeRefreshLayout){
    swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(cotext, R.color.colorPrimary))

    swipeRefreshLayout.isEnabled = true
    swipeRefreshLayout.isRefreshing = true

}

fun dissmisloading(swipeRefreshLayout: SwipeRefreshLayout){
    swipeRefreshLayout.isRefreshing = false
    swipeRefreshLayout.isEnabled = false
}