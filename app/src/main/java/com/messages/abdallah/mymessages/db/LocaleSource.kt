package com.messages.abdallah.mymessages.db

import android.content.Context
import com.messages.abdallah.mymessages.db.Dao.MsgsDao
import com.messages.abdallah.mymessages.db.Dao.MsgsTypesDao
import com.messages.abdallah.mymessages.models.MsgsModel
import com.messages.abdallah.mymessages.models.MsgsTypesModel

class LocaleSource(context: Context) {

    private var TypesDao: MsgsTypesDao?
    private var Msgs_Dao: MsgsDao?
    var ID_Type_id: Int?=null


    init {
        val dataBase = PostDatabas.getInstance(context.applicationContext)
        TypesDao = dataBase.TypesDao()
        Msgs_Dao = dataBase.Msgs_Dao()
    }

    companion object {
        private var sourceConcreteClass: LocaleSource? = null
        fun getInstance(context: Context): LocaleSource {
            if (sourceConcreteClass == null)
                sourceConcreteClass = LocaleSource(context)
            return sourceConcreteClass as LocaleSource
        }
    }

    suspend fun getMsgsTypes_Dao(): List<MsgsTypesModel> {
        return TypesDao?.getMsgsTypes_Dao()!!
    }

    suspend fun getMsgs_Dao(id:Int): List<MsgsModel> {
        return Msgs_Dao?.getAllMsgsDao(id)!!
    }

    suspend fun insertPosts(posts: List<MsgsTypesModel>) {
        TypesDao?.insertPosts(posts)!!
    }

    suspend fun insert_msgs(msgs: List<MsgsModel>) {
        Msgs_Dao?.insert_msgs(msgs)!!
    }



    suspend fun deletePosts() {
        TypesDao?.deleteALlPosts()
    }

}