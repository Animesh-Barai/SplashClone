package com.jvmori.myapplication.data.source

import com.jvmori.myapplication.data.remote.photodata.PhotoDataResponse
import com.jvmori.myapplication.domain.repositories.RemotePhotosDataSource

class FakeRemoteDataSource(
    private val photos: MutableList<PhotoDataResponse> = mutableListOf()
) : RemotePhotosDataSource<List<PhotoDataResponse>> {

    override suspend fun getPhotos(page: Int): List<PhotoDataResponse> {
       return photos
    }
}