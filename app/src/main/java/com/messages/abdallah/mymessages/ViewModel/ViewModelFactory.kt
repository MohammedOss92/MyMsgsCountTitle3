package com.messages.abdallah.mymessages.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.messages.abdallah.mymessages.repository.MsgsRepo

class ViewModelFactory constructor(private val repository: MsgsRepo): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(MsgsViewModel::class.java)) {
            MsgsViewModel(this.repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}