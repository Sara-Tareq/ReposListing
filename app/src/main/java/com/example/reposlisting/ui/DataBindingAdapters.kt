package com.example.reposlisting.ui

import android.view.View
import androidx.databinding.BindingAdapter

class DataBindingAdapters {
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }
}