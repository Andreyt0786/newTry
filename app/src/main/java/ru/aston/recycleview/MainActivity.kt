package ru.aston.recycleview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.aston.recycleview.adapter.CountryAdapter
import ru.aston.recycleview.databinding.ActivityMainBinding
import ru.aston.recycleview.ui.theme.RecycleViewTheme
import ru.aston.recycleview.viewModel.CountryViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: CountryViewModel by viewModels()
        val adapter = CountryAdapter()
        binding.list.adapter = adapter
        viewModel.data.observe(this) { country ->
            adapter.submitList(country)

        }
    }
}
