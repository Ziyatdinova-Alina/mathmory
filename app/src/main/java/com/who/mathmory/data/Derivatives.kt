package com.who.mathmory.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "derivatives")
data class Derivatives(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val timestamp: Long,
    val question: String,
    val answer: String,
)
