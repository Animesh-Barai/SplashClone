package com.jvmori.myapplication.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.*
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.jvmori.myapplication.data.remote.Order
import com.jvmori.myapplication.data.remote.Resource
import com.jvmori.myapplication.data.repositories.PhotosDataSource
import com.jvmori.myapplication.data.repositories.PhotosDataSourceFactory
import com.jvmori.myapplication.domain.entities.PhotoEntity
import com.jvmori.myapplication.domain.usecases.GetPhotosList
import com.jvmori.myapplication.domain.usecases.RefreshPhotos
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import java.lang.Exception

class PhotosViewModel(
    private val photosList: GetPhotosList,
    private val refreshPhotos: RefreshPhotos
) : ViewModel() {

    private val pageSize = 10
    private val order = Channel<String>()
    var photos: LiveData<PagedList<PhotoEntity>> = MutableLiveData()
    //var networkStatus: LiveData<Resource.Status> = MutableLiveData()
    private val config = PagedList.Config.Builder()
        .setPageSize(pageSize)
        .setInitialLoadSizeHint(pageSize)
        .setEnablePlaceholders(false)
        .build()

    fun fetchPhotos(order: String) {
        val photoDataSourceFactory = PhotosDataSourceFactory(viewModelScope, photosList, order)
        initNetworkStatus(photoDataSourceFactory)
        //photos.value?.dataSource?.invalidate()
        photos = LivePagedListBuilder<Int, PhotoEntity>(photoDataSourceFactory, config).build()
    }

    private fun initNetworkStatus(photoDataSourceFactory: PhotosDataSourceFactory) {
//        networkStatus = Transformations.switchMap(
//            photoDataSourceFactory.photosLiveData,
//            PhotosDataSource::networkStatus
//        )
    }

    fun refreshPhotos() {

    }
}