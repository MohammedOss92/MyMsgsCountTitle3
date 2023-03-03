package com.messages.abdallah.mymessages.db.Dao

import androidx.room.*
import com.messages.abdallah.mymessages.models.FavoriteModel
import com.messages.abdallah.mymessages.models.MsgsModel

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add_fav(fav: FavoriteModel)

    @Query("Select * from Favorite_table")
    suspend fun getAllFav(): List<FavoriteModel>

    // delete favorite item from db
    @Delete
    suspend fun deletefav(item:FavoriteModel)


}