package com.yen.dogbones

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.yen.dogbones.data.service.ImageRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(val imageRepository: ImageRepository): ViewModel(), LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun init() {
        viewModelScope.launch(Dispatchers.IO) {
            val image = imageRepository.getRandomBreedImage()

            if (image != null) {

            }
        }
    }

}
