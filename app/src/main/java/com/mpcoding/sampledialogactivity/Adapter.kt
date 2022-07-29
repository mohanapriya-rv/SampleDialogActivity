package com.mpcoding.sampledialogactivity

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.mpcoding.sampledialogactivity.databinding.RowReferralBindingBinding

class FIReferralAdapter(val requireActivity: FragmentActivity) :
    RecyclerView.Adapter<FIReferralAdapter.ViewHolder>() {
    private var referralList: MutableList<String> = mutableListOf()

    inner class ViewHolder(val binding: RowReferralBindingBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(items: String) {
            binding.text.text = items
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            RowReferralBindingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(referralList[position])
        holder.binding.text.setOnClickListener {
            val i = Intent(Intent(requireActivity, DialogActivity::class.java))
            i.putExtra("position", position)

            val options = ActivityOptions
                .makeSceneTransitionAnimation(
                    requireActivity as Activity?,
                    holder.binding.text,
                    "transition"
                )
            requireActivity.startActivity(i, options.toBundle())
        }
    }

    override fun getItemCount() = referralList.size
    fun setData(referralList_: List<String>) {
        referralList.addAll(referralList_)
        notifyDataSetChanged()
    }
}
