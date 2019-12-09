package com.example.reposlisting.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.reposlisting.R

object DataBindingAdapters {

    @BindingAdapter("visibleGone")
    @JvmStatic
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }

    @BindingAdapter("imageSrc")
    @JvmStatic
    fun addDeleteBookmark(imageView: ImageView,isBookmarked:Boolean){
        imageView.setImageResource(if(isBookmarked) R.drawable.ic_bookmark_delete else R.drawable.ic_bookmark)
    }
}