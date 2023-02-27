package com.messages.abdallah.mymessages.db.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.messages.abdallah.mymessages.models.FavoriteModel
import com.messages.abdallah.mymessages.models.MsgsModel

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add_fav(fav: List<FavoriteModel>)

    @Query("Select * from Favorite_table ")
    suspend fun getAllFav(): List<FavoriteModel>
}