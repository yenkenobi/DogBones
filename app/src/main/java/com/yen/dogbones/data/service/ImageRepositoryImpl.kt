package com.yen.dogbones.data.service

import com.yen.dogbones.data.api.Api
import com.yen.dogbones.data.api.model.ImageResponse
import com.yen.dogbones.data.api.model.ImagesResponse
import javax.inject.Inject

class ImageRepositoryImpl @Inject constructor(val api: Api): ImageRepository {

    override suspend fun getRandomBreedImage(): ImageResponse {
        return api.getRandomBreedImage()
    }

    override suspend fun getRandomBreedImages(count: Int): ImagesResponse {
        return api.getRandomBreedImages(count)
    }
}
