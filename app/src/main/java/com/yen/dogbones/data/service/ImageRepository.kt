package com.yen.dogbones.data.service

import com.yen.dogbones.domain.Image

interface ImageRepository {

    suspend fun getRandomBreedImage(): Image
}