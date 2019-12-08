package com.example.reposlisting.ui

import android.view.View
import androidx.databinding.BindingAdapter

object DataBindingAdapters {

    @BindingAdapter("visibleGone")
    @JvmStatic
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }
}