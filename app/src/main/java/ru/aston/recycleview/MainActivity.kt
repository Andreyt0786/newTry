package ru.aston.recycleview

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.findNavController
import ru.aston.recycleview.adapter.CountryAdapter
import ru.aston.recycleview.databinding.ActivityMainBinding
import ru.aston.recycleview.fragments.FirstFragment
import ru.aston.recycleview.ui.theme.RecycleViewTheme
import ru.aston.recycleview.viewModel.CountryViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.nav_container,FirstFragment()).commit()
    }
}


