package com.bangkit.skutapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ViewPagerItem(
    var diseaseName: String,
    var diseaseDescription: String,
) : Parcelable