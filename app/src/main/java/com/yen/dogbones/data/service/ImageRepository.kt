package com.yen.dogbones.data.service

import com.yen.dogbones.data.api.model.ImageResponse
import com.yen.dogbones.data.api.model.ImagesResponse

interface ImageRepository {

    suspend fun getRandomBreedImage(): ImageResponse

    suspend fun getRandomBreedImages(count: Int): ImagesResponse
}