package com.messages.abdallah.mymessages.models

import androidx.room.Embedded

data class MsgsTypeWithCount(
    @Embedded
    var msgTypes: MsgsTypesModel? = null,
    val subCount: Int = 0
)
