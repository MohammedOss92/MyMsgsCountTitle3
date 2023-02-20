package com.messages.abdallah.mymessages.db.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.messages.abdallah.mymessages.models.MsgsTypeWithCount
import com.messages.abdallah.mymessages.models.MsgsTypesModel

@Dao
interface MsgsTypesDao {

    @Query("SELECT * FROM msg_types_table")
    fun getPosts(): LiveData<List<MsgsTypesModel>>

    @Query("SELECT * FROM msg_types_table")
    fun getPosts2():  List<MsgsTypesModel>

    // get last id to compare with server data
    @Query("SELECT * FROM msg_types_table ORDER BY id DESC LIMIT 1")
    fun getLastId(): MsgsTypesModel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(msgsTypesModels: MsgsTypesModel)

    @Update
    suspend fun update(note: MsgsTypesModel)

    @Delete
    suspend fun delete(note: MsgsTypesModel)

    /************************/

    @Query("SELECT * FROM msg_types_table")
    suspend fun getMsgsTypes_Dao():  List<MsgsTypesModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(posts: List<MsgsTypesModel>)

    @Query("DELETE FROM msg_types_table")
    fun deleteALlPosts()

    @Query(
        "SELECT e.subCount AS subCount, c.* " +
                "FROM msgTypes c " +
                "LEFT JOIN ( " +
                "   SELECT TypeDescription, COUNT(*) subCount " +
                "   from msg " +
                "   GROUP BY TypeDescription) e " +
                "ON e.TypeDescription = c.TypeID"
    )
    suspend fun getAllMsgTypesWithCounts(): LiveData<List<MsgsTypeWithCount?>?>?
}