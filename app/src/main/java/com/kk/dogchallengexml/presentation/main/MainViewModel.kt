package com.kk.dogchallengexml.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kk.dogchallengexml.core.utils.ResponseHandler
import com.kk.dogchallengexml.data.repository.RepositoryImp
import com.kk.dogchallengexml.domain.model.Dog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: RepositoryImp): ViewModel() {

    private val _dog = MutableLiveData<Dog>()
    val dog : LiveData<Dog> get() = _dog

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> get() = _error

    init {
        getDog()
    }

    fun getDog(){
        viewModelScope.launch(Dispatchers.IO) {
            when(val response = repository.getDog()){
                is ResponseHandler.Error -> {
                    _error.postValue(response.message)
                }
                is ResponseHandler.Success -> {
                    _dog.postValue(response.data)
                }
            }
        }
    }
}