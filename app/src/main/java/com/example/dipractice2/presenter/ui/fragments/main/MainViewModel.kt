package com.example.dipractice2.presenter.ui.fragments.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dipractice2.data.models.HeroModel
import com.example.dipractice2.domain.repository.HeroRepository
import com.example.dipractice2.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val repository:HeroRepository) : ViewModel() {

    private val _heroFlow = MutableSharedFlow<Resource<List<HeroModel.Heroes>>>()
    val heroFlow get() = _heroFlow.asSharedFlow()

    fun getHero() {
        viewModelScope.launch {
            repository.getHeroes().collect {
                when (it) {
                    is Resource.Error -> _heroFlow.emit(it)
                    is Resource.Loading -> _heroFlow.emit(it)
                    is Resource.Success -> _heroFlow.emit(it)
                }
            }
        }
    }

}