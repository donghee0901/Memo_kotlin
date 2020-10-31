package com.example.memo_kotlin

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class MemoEntity {
    @PrimaryKey(autoGenerate = true)
    var id = 0

    @ColumnInfo(name = "title")
    var title: String? = null

    @ColumnInfo(name = "content")
    var content: String? = null
}
