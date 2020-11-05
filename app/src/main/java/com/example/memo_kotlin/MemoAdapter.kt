package com.example.memo_kotlin
import android.content.Intent
import android.os.Build.ID
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.memobar.view.*


class MemoAdapter internal constructor(val list: List<MemoEntity>?) :
    RecyclerView.Adapter<MemoAdapter.ViewHolder>() {
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
        holder.itemView.title.text = list!![position].title
        holder.itemView.content.text = list!![position].content
        holder.itemView.ID.text = list!![position].id.toString()
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener {
                val i = Intent(itemView.context, MemoViewActivity::class.java)
                i.putExtra("title", itemView.title.text.toString())
                i.putExtra("content", itemView.content.text.toString())
                i.putExtra("id", itemView.ID.text.toString())
                itemView.context.startActivity(i) //새 액티비티 띄우기
            }
        }
    }
}

