package com.main.containerspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.main.containerspinner.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        fun loadData(): MutableList<Memo> {
            val data: MutableList<Memo> = mutableListOf()

            for (no in 1..100) {
                val title = "This is Android $no"
                val date = System.currentTimeMillis()
                var memo = Memo(no, title, date)
                data.add(memo)
            }

            return data
        }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val data_re : MutableList<Memo> = loadData()
        var adapter_re = CustomAdapter()
        adapter_re.listData = data_re

        binding.recyclerView.adapter = adapter_re
        binding.recyclerView.layoutManager = LinearLayoutManager(this)



        var data = listOf("-choose-", "January", "February", "March", "April", "June")
        var adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data)
        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                binding.result.text = data.get(p2)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
    }
}