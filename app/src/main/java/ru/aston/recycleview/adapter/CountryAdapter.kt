package ru.aston.recycleview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.aston.recycleview.databinding.CardCountryBinding
import ru.aston.recycleview.dto.Country

class CountryDiffCallback : DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }
}

class CountryAdapter() : ListAdapter<Country, CountryViewHolder>(CountryDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = CardCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)
        holder.bind(country)
    }
}

class CountryViewHolder(
    private val binding: CardCountryBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(country: Country) {
        binding.apply {
            countryName.text = country.name

            val url = country.url
            Glide.with(binding.flag)
                .load(url)
                .timeout(10000)
                .into(binding.flag)
        }
    }

}