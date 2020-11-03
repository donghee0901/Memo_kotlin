package com.example.memo_kotlin

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [MemoEntity::class], version = 2)
abstract class MemoDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao?

    companion object {
        private var instance: MemoDatabase? = null
        fun getInstance(context: Context): MemoDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MemoDatabase::class.java, "database-name").fallbackToDestructiveMigration().build()
            }
            return instance
        }
    }
}
