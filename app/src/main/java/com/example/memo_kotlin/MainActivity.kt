package com.example.memo_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    var db: MemoDatabase? = null
    var MemoData: List<MemoEntity>? = null
    var adapter: MemoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = MemoDatabase.getInstance(applicationContext)

//        new Thread(() ->{
//            db.memoDao().deleteAll();
//        }).start();
        Thread(Runnable {
            MemoData = db?.memoDao()?.getMemoAll()
            val memo = findViewById<RecyclerView>(R.id.MemoRecyclerView)
            adapter = MemoAdapter(MemoData) //어댑터 만들면서 데이터 리스트 넘기기
            memo.adapter = adapter //리사이클러뷰에 어댑터 연결
            memo.layoutManager = LinearLayoutManager(this) //데이터 정렬방식 (LinearLayoutManager : 세로정렬)
        }).start()
        addMemo.setOnClickListener(View.OnClickListener {
            adapter?.notifyDataSetChanged() // adapter 새로고침
            val i = Intent(applicationContext, AddMemoActivity::class.java) //새로운 액티비티로 넘어가기 위한 변수
            startActivity(i) //새 액티비티 띄우기
        })
    }
}
