package com.yen.dogbones.feature.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.airbnb.epoxy.EpoxyRecyclerView
import com.yen.dogbones.R
import com.yen.dogbones.data.service.ImageRepository
import com.yen.dogbones.ui.ImageModel_
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var imageRepository: ImageRepository
    val mainViewModel: MainViewModel by viewModels()

    lateinit var rvImages: EpoxyRecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycle.addObserver(mainViewModel)
        setContentView(R.layout.activity_main)

        rvImages = findViewById(R.id.rvImages)

        mainViewModel.imagesLivedata.observe(this) {
            images ->
            rvImages.withModels {

                images.forEach {
                    ImageModel_()
                        .id(it.hashCode())
                        .imageUrl(it.url)
                        .addTo(this)
                }

            }
        }
    }
}