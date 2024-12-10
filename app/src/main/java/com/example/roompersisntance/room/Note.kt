package com.example.roompersisntance.room

import android.icu.text.CaseMap.Title
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.net.IDN
import java.sql.Timestamp

@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val timestamp: Timestamp
)
