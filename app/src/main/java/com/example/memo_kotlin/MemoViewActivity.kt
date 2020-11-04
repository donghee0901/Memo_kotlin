package com.example.memo_kotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_memo_view.*



class MemoViewActivity : AppCompatActivity() {
    var db: MemoDatabase? = null
    lateinit var title: String
    lateinit var content: String
    var id = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memo_view)
        db = MemoDatabase.getInstance(applicationContext)
        val i = intent
        title = i.extras!!.getString("title", "")
        content = i.extras!!.getString("content", "")
        id = i.extras!!.getString("id")!!.toInt()

        view_title.setText(title)
        view_content.setText(content)

        modify_button.setOnClickListener(View.OnClickListener {
            Thread(Runnable {
                val test = MemoEntity(id, view_title.text.toString(), view_content.text.toString())
                db!!.memoDao()!!.update(test)
                val inte = Intent(applicationContext,MainActivity::class.java) //새로운 액티비티로 넘어가기 위한 변수
                startActivity(inte) //새 액티비티 띄우기
                finishAffinity()
            }).start()
        })
        delete_button.setOnClickListener(View.OnClickListener {
            Thread(Runnable {
                val test = MemoEntity(id,  title,content)
                db!!.memoDao()!!.delete(test)
                val inte = Intent(applicationContext, MainActivity::class.java) //새로운 액티비티로 넘어가기 위한 변수
                startActivity(inte) //새 액티비티 띄우기
                finishAffinity()
            }).start()
        })
        back.setOnClickListener(View.OnClickListener {
            val inte = Intent(applicationContext, MainActivity::class.java) //새로운 액티비티로 넘어가기 위한 변수
            startActivity(inte) //새 액티비티 띄우기
            finishAffinity()
        })
    }
}