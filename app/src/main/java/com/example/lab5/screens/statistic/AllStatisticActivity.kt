package com.example.lab5.screens.statistic

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab5.Dependencies
import com.example.lab5.databinding.ActivityAllStatisticBinding

class AllStatisticActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAllStatisticBinding
    private val viewModel by lazy { AllStatisticViewModel(Dependencies.statisticRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        Dependencies.init(applicationContext)
        super.onCreate(savedInstanceState)
        binding = ActivityAllStatisticBinding.inflate(layoutInflater).also { setContentView(it.root) }

        viewModel.allStatic.observe(this) { allStatistic ->
            val adapter = StatisticAdapter(viewModel.statisticItemListener)
            adapter.data = allStatistic.reversed()

            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }
}