package com.sopt.android_hyebin.presentation.profile.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.sopt.android_hyebin.data.FollowerData
import com.sopt.android_hyebin.databinding.ItemFollowerListBinding
import com.sopt.android_hyebin.presentation.profile.DetailActivity

class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val followerList = mutableListOf<FollowerData>()

    class FollowerViewHolder(val binding : ItemFollowerListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: FollowerData) {
           binding.apply {
               follow = data
               executePendingBindings()
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
        holder.binding.root.setOnClickListener {
            val intent = Intent(holder.itemView?.context, DetailActivity::class.java)
            intent.putExtra("name", followerList[position].name)
            intent.putExtra("introduction", followerList[position].introduction)
            startActivity(holder.itemView.context, intent, null)

        }
    }

    override fun getItemCount(): Int = followerList.size
}