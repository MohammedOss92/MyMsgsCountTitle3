package com.messages.abdallah.mymessages.db.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert

import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.messages.abdallah.mymessages.models.MsgsModel

@Dao
interface MsgsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert_msgs(msgs: List<MsgsModel>)



    @Query("Select * from msg_table where ID_Type_id =:ID_Type_id")
    suspend fun getAllMsgsDao(ID_Type_id: Int): List<MsgsModel>

//    @Query(" select m.*,t.TypeDescription from msg_table m" +
//            " Left Join msg_types_table t on" +
//            " m.TypeDescription = t.TypeID " +
//            "where TypeDescription" +
//            "=:TypeDescription")
//    suspend fun getAllMsgsDa(TypeDescription: Int): List<MsgsModel>

    @Query("delete from msg_table")
    fun deleteAllmessage()
}