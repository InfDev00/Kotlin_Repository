package com.main.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.main.fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy{ActivityMainBinding.inflate(layoutInflater)}

    lateinit var listFragment: ListFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setFragment()
        binding.btnSend.setOnClickListener {
            listFragment.setValue("send value")
        }
    }

    private fun setFragment() {
        listFragment = ListFragment()
        var bundle = Bundle()
        bundle.putString("key1", "List Fragment")
        bundle.putInt("key2", 20230101)
        listFragment.arguments = bundle

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, listFragment)
        transaction.commit()
    }

    fun goDetail() {
        val detailFragment = DetailFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameLayout, detailFragment)
        transaction.addToBackStack("detail")
        transaction.commit()
    }

    fun goBack() {
        onBackPressed()
    }
}