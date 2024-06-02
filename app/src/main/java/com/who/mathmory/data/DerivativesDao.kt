package com.who.mathmory.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DerivativesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDerivatives(derivatives: Derivatives)
    @Query("SELECT * FROM derivatives")
    suspend fun getAllDerivatives(): List<Derivatives>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addDerivatives(derivatives: Derivatives)
    @Query("SELECT * FROM derivatives WHERE timestamp <= :maxTimestamp ORDER BY timestamp DESC")
    suspend fun getDerivativesBeforeTimestamp(maxTimestamp: Long): List<Derivatives>

    @Query("UPDATE derivatives SET timestamp = :newTimestamp WHERE question = :question")
    suspend fun updateTimestampForDerivative(question: String, newTimestamp: Long)

    @Query("SELECT answer FROM derivatives WHERE question = :question LIMIT 1")
    suspend fun getAnswerForQuestionDerivative(question: String): String?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllDerivative(derivatives: List<Derivatives>)
}