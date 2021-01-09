package com.yen.dogbones.data.service

import com.yen.dogbones.data.api.Api
import com.yen.dogbones.domain.Image
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(val api: Api): ImageRepository {

    override suspend fun getRandomBreedImage(): Image {
        return api.getRandomBreedImage()
    }
}
