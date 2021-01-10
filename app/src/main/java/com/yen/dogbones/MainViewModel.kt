package com.yen.dogbones

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.yen.dogbones.data.service.ImageRepository
import com.yen.dogbones.domain.Image
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel @ViewModelInject constructor(val imageRepository: ImageRepository): ViewModel(), LifecycleObserver {

    val _imagesLiveData: MutableLiveData<List<Image>> = MutableLiveData()
    val imagesLivedata: LiveData<List<Image>> = _imagesLiveData

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            val imagesResponse = imageRepository.getRandomBreedImages(count = 10)

            val images = imagesResponse.message.map {
                Image(url = it)
            }

            withContext(Dispatchers.Main) {
                _imagesLiveData.value = images
            }
        }
    }

}
