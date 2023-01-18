package com.main.containerspinner

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.main.containerspinner.databinding.ItemRecyclerBinding
import java.text.SimpleDateFormat

class CustomAdapter: RecyclerView.Adapter<Holder>() {
    var listData = mutableListOf<Memo>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = listData.get(position)
        holder.setMemo(memo)
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}

class Holder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root)  {
    init {
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "Clicked item = ${binding.textTitle.text}",
                Toast.LENGTH_LONG).show()
        }
    }
    fun setMemo(memo: Memo){
        binding.textNo.text = "${memo.no}"
        binding.textTitle.text = "${memo.title}"
        var sdf = SimpleDateFormat("yyyy/MM/dd")
        binding.textDate.text = "${sdf.format(memo.timestamp)}"
    }
}