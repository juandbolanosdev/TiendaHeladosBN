package com.example.bottomnavtienda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bottomnavtienda.databinding.ItemCommentBinding

class CommentAdapter(val items:List<Comment>): RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    var listener:OnCommentListener? = null

    class ViewHolder(val view: ItemCommentBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCommentBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = items[position]
        holder.view.itemCommentName.text = comment.name
        holder.view.itemCommentMessage.text = comment.message
        Glide.with(holder.itemView).load(comment.image).into(holder.view.itemCommentPhoto)

        holder.view.root.setOnClickListener{
            listener?.onClick(comment)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}