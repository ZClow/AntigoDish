package com.example.a485project.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes




data class Buy(
    @StringRes val stringResourceId1: Int,
    @StringRes val stringResourceId2: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val stringResourceId3: Int,
    val NumResourceId2: Int,
    @StringRes val stringResourceId4: Int

)

