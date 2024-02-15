package com.example.mobilelearningapp.utils

import android.content.Context
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


class ResourceProvider @Inject constructor(@ApplicationContext context: Context) {
    private val context: Context

    init {
        this.context = context
    }

    fun getString(@StringRes id: Int): String {
        return context.getString(id)
    }
}
