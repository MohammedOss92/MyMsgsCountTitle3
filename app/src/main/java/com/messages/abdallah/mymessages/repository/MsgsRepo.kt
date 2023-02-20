package com.messages.abdallah.mymessages.repository

import com.messages.abdallah.mymessages.api.ApiService
import com.messages.abdallah.mymessages.db.LocaleSource
import com.messages.abdallah.mymessages.models.MsgsModel
import com.messages.abdallah.mymessages.models.MsgsTypesModel

class MsgsRepo constructor(val apiService: ApiService,private val localeSource: LocaleSource) {

    suspend fun getMsgs_Ser(ID_Type_id:Int)= apiService.getMsgs_Ser(ID_Type_id)

    suspend fun getMsgs_Dao(id:Int) = localeSource.getMsgs_Dao(id)

    suspend fun insert_msgs (msgs:List<MsgsModel>?){
        if(!msgs.isNullOrEmpty()){
            localeSource.insert_msgs(msgs)
        }
    }
}