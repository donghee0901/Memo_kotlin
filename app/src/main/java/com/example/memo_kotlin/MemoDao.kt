package com.example.memo_kotlin

import androidx.room.*


@Dao
interface MemoDao {
    @Query("SELECT * FROM MemoEntity")
    fun getMemoAll(): List<MemoEntity>?

    @Query("SELECT * FROM MemoEntity WHERE id = (:id)")
    fun getMemoById(id: Int): MemoEntity?

    @Query("SELECT count(*) FROM MemoEntity")
    fun count(): Int

    @Query("SELECT max(id) FROM MemoEntity")
    fun maxCount(): Int

    @Query("DELETE FROM MemoEntity")
    fun deleteAll()

    @Insert
    fun insert(user: MemoEntity?)

    @Update
    fun update(user: MemoEntity?)

    @Delete
    fun delete(user: MemoEntity?)
}
