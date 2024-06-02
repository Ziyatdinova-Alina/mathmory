package com.who.mathmory.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Derivatives::class, Integrals::class], version = 1)
abstract class MathBase : RoomDatabase() {
    abstract fun derivativesDAO(): DerivativesDao
    abstract fun integralsDAO(): IntegralsDao
}

class MathDatabase(context: Context) : MathRepository {
    private val room = Room.databaseBuilder(
        context,
        MathBase::class.java,
        DATABASE_NAME
    ).build()
    private val derivativesDao = room.derivativesDAO()
    private val integralDao = room.integralsDAO()

    override suspend fun insertDerivatives(derivatives: Derivatives) {
        derivativesDao.insertDerivatives(derivatives)
    }

    override suspend fun getAllDerivatives(): List<Derivatives> {
        return derivativesDao.getAllDerivatives()
    }


    override suspend fun getDerivativesBeforeTimestamp(maxTimestamp: Long): List<Derivatives> {
        return derivativesDao.getDerivativesBeforeTimestamp(maxTimestamp)
    }

    override suspend fun updateTimestampForDerivative(question: String, newTimestamp: Long) {
        derivativesDao.updateTimestampForDerivative(question, newTimestamp)
    }

    override suspend fun getAnswerForQuestionDerivative(question: String): String? {
        return derivativesDao.getAnswerForQuestionDerivative(question)
    }

    override suspend fun insertAllDerivative(derivatives: List<Derivatives>){
        derivativesDao.insertAllDerivative(derivatives)
    }

    override suspend fun isDerivativeDatabaseEmpty(): Boolean {
        return derivativesDao.getAllDerivatives().isEmpty()
    }

    override suspend fun insertIntegrals(integrals: Integrals) {
        integralDao.insertIntegrals(integrals)
    }

    override suspend fun getAllIntegrals(): List<Integrals> {
        return integralDao.getAllIntegrals()
    }

    override suspend fun getIntegralsBeforeTimestamp(maxTimestamp: Long): List<Integrals> {
        return integralDao.getIntegralsBeforeTimestamp(maxTimestamp)
    }

    override suspend fun updateTimestampForIntegrals(question: String, newTimestamp: Long) {
        return integralDao.updateTimestampForIntegrals(question, newTimestamp)
    }

    override suspend fun getAnswerForQuestionIntegrals(question: String): String? {
        return integralDao.getAnswerForQuestionIntegrals(question)
    }

    override suspend fun insertAllIntegrals(integrals: List<Integrals>) {
        integralDao.insertAllIntegrals(integrals)
    }

    override suspend fun isIntegralsDatabaseEmpty(): Boolean {
        return integralDao.getAllIntegrals().isEmpty()
    }

    companion object {
        private const val DATABASE_NAME = "math_database"
    }
}