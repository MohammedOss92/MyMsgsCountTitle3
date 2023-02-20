package com.messages.abdallah.mymessages.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.messages.abdallah.mymessages.R
import com.messages.abdallah.mymessages.databinding.MsgsDesignBinding
import com.messages.abdallah.mymessages.models.MsgsModel

class Msgs_Adapter : RecyclerView.Adapter<Msgs_Adapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: MsgsDesignBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    private val diffCallback = object :DiffUtil.ItemCallback<MsgsModel>(){
        override fun areItemsTheSame(oldItem: MsgsModel, newItem: MsgsModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MsgsModel, newItem: MsgsModel): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)
    var msgsModel: List<MsgsModel>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(MsgsDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current_msgsModel = msgsModel[position]
        holder.binding.apply {
            tvTitleM.text=current_msgsModel.ID_Type_id.toString()
            tvMsgM.text=current_msgsModel.MessageName
            newMsgM.setImageResource(R.drawable.new_msg)

            if (current_msgsModel.new_msgs == 0){

                newMsgM.setVisibility(View.INVISIBLE)
            }
            else {
                newMsgM.setVisibility(View.VISIBLE)
            }
        }
    }

    override fun getItemCount(): Int {
        return msgsModel.size
    }
}