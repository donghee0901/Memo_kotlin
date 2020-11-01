package com.example.memo_kotlin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class MemoEntity (
    @PrimaryKey(autoGenerate = true) val id : Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "content") var content: String
)