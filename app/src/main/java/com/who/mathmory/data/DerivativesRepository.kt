package com.who.mathmory.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Database
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase

interface MathRepository {
    // Производные
    suspend fun insertDerivatives(derivatives: Derivatives)
    suspend fun getAllDerivatives(): List<Derivatives>
    suspend fun getDerivativesBeforeTimestamp(maxTimestamp: Long): List<Derivatives>
    suspend fun updateTimestampForDerivative(question: String, newTimestamp: Long)
    suspend fun getAnswerForQuestionDerivative(question: String): String?
    suspend fun insertAllDerivative(derivatives: List<Derivatives>)
    suspend fun isDerivativeDatabaseEmpty(): Boolean

    // Интегралы
    suspend fun insertIntegrals(integrals: Integrals)
    suspend fun getAllIntegrals(): List<Integrals>
    suspend fun getIntegralsBeforeTimestamp(maxTimestamp: Long): List<Integrals>
    suspend fun updateTimestampForIntegrals(question: String, newTimestamp: Long)
    suspend fun getAnswerForQuestionIntegrals(question: String): String?
    suspend fun insertAllIntegrals(integrals: List<Integrals>)
    suspend fun isIntegralsDatabaseEmpty(): Boolean
}