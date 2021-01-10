package com.yen.dogbones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yen.dogbones.data.service.ImageRepository
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var imageRepository: ImageRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch(context = Dispatchers.IO) {
            val image = imageRepository.getRandomBreedImage()

            if (image != null) {

            }
        }
    }
}