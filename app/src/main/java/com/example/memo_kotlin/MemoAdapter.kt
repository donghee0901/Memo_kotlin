package com.example.memo_kotlin
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MemoAdapter internal constructor(list: List<MemoEntity>?) :
    RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
    private var mData: List<MemoEntity>? = null
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.memobar, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.title.text = mData!![position].title
        holder.content.text = mData!![position].content
        holder.ID.text = mData!![position].id.toString()
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var title = itemView.findViewById<TextView>(R.id.title)
        var content = itemView.findViewById<TextView>(R.id.content)
        var ID = itemView.findViewById<TextView>(R.id.ID)

        init {
            itemView.setOnClickListener {
                val i = Intent(itemView.context, MemoViewActivity::class.java)
                i.putExtra("title", title.text.toString())
                i.putExtra("content", content.text.toString())
                i.putExtra("id", ID.text.toString())
                itemView.context.startActivity(i) //새 액티비티 띄우기
            }
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    init {
        mData = list
    }
}

