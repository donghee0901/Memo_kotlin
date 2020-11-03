package com.example.memo_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_memo.*

class AddMemoActivity : AppCompatActivity() {
    var db: MemoDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_memo)
        db = MemoDatabase.getInstance(applicationContext)
        back.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java) //새로운 액티비티로 넘어가기 위한 변수
            startActivity(i) //새 액티비티 띄우기
            finishAffinity()
        })
        submit.setOnClickListener(View.OnClickListener {
            if (add_title.text == null || add_content.text == null || add_title.text.toString() == "" || add_content.text.toString() == "") {
                Toast.makeText(applicationContext, "빈 값을 저장할 수 없습니다.", Toast.LENGTH_SHORT).show()
            } else {
                Thread(Runnable {
                    val test = MemoEntity(id = 0, title = add_title.text.toString(), content = add_content.text.toString())
                    db!!.memoDao()!!.insert(test)
                    val i = Intent(applicationContext, MainActivity::class.java) //새로운 액티비티로 넘어가기 위한 변수
                    startActivity(i) //새 액티비티 띄우기
                    finishAffinity()
                }).start()
            }
        })
    }
}