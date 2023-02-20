package com.messages.abdallah.mymessages.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.messages.abdallah.mymessages.repository.MsgsRepo
import com.messages.abdallah.mymessages.repository.MsgsTypesRepo
import com.messages.abdallah.mymessages.ui.MainActivity

class MyViewModelFactory constructor(private val repository: MsgsTypesRepo,private val repository2: MsgsRepo,val context:MainActivity): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
         if (modelClass.isAssignableFrom(MsgsTypesViewModel::class.java)) {
             return  MsgsTypesViewModel(this.repository,this.repository2,context) as T
        }else if (modelClass.isAssignableFrom(MsgsViewModel::class.java)){
             return  MsgsViewModel(this.repository2) as T
         }else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}