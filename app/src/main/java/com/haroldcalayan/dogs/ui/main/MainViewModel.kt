package com.haroldcalayan.dogs.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.haroldcalayan.dogs.base.BaseViewModel
import com.haroldcalayan.dogs.data.model.Breed
import com.haroldcalayan.dogs.data.model.BreedImage
import com.haroldcalayan.dogs.data.repository.DogsRepository
import com.haroldcalayan.dogs.util.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dogsRepository: DogsRepository
) : BaseViewModel() {

    private val _breedList = MutableLiveData<List<Breed>?>()
    val breedList: LiveData<List<Breed>?> = _breedList

    private val _breedImageList = MutableLiveData<List<BreedImage>?>()
    val breedImageList: LiveData<List<BreedImage>?> = _breedImageList

    private val _errorMessageId = MutableLiveData<Int>()
    val errorMessageId: LiveData<Int?> = _errorMessageId

    fun getBreeds() {
        invoke {
            val response = dogsRepository.getBreeds(0, Constants.QUERY_LIMIT)
            _breedList.postValue(response)
        }
    }

    fun getBreedImages(position: Int) {
        if (position < 0) return
        invoke {
            breedList.value?.get(position)?.id?.let {
                val response = dogsRepository.getImages(it, 0, Constants.QUERY_LIMIT)
                _breedImageList.postValue(response)
            }
        }
    }
}