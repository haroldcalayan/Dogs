package com.haroldcalayan.dogs.ui.main

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import com.haroldcalayan.dogs.R
import com.haroldcalayan.dogs.base.BaseActivity
import com.haroldcalayan.dogs.data.model.Breed
import com.haroldcalayan.dogs.databinding.ActivityMainBinding
import com.haroldcalayan.dogs.util.showToastShort
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override val layoutId = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()

    private lateinit var breedsAdapter: ArrayAdapter<String>
    private lateinit var dogsAdapter: DogsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()
        observe()
        viewModel.getBreeds()
    }

    override fun initViews() {
        super.initViews()
        initBreedList()
        initDogsList()
    }

    override fun observe() {
        super.observe()
        viewModel.breedList.observe(this, {
            updateBreedsList(it ?: emptyList())
        })
        viewModel.breedImageList.observe(this, {
            dogsAdapter.updateData(it ?: emptyList())
        })
        viewModel.errorMessageId.observe(this, {
            showToastShort(it ?: R.string.message_generic_error)
        })
    }

    private fun initBreedList() {
        breedsAdapter = ArrayAdapter<String>(
            this,
            R.layout.spinner_item
        )
        breedsAdapter.setNotifyOnChange(true)
        binding.spinnerBreeds.adapter = breedsAdapter
        binding.spinnerBreeds.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                viewModel.getBreedImages(position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }

    private fun updateBreedsList(list: List<Breed>) {
        breedsAdapter.clear()
        breedsAdapter.addAll(list.map { it.name })
        breedsAdapter.notifyDataSetChanged()
    }

    private fun initDogsList() {
        dogsAdapter = DogsAdapter(emptyList())
        binding.recyclerviewDogs.adapter = dogsAdapter
    }

}