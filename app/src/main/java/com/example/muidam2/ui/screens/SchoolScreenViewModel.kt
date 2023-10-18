package com.example.muidam2.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apicompose.repository.Repository
import com.example.muidam2.model.SchoolOpsItemModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolScreenViewModel @Inject constructor(
    private val repository : Repository
): ViewModel() {
    //read and wirte mutable
    private val _schoolCount = MutableStateFlow<List<SchoolOpsItemModel>>(emptyList())

    //read only state
    val schoolCount: StateFlow<List<SchoolOpsItemModel>> = _schoolCount


    //intializing whenever we create an object it calls it
    //will be called automatically whenever an instance/object is create
    init {
        schoolData()
    }


    fun schoolData() {
        viewModelScope.launch {
            val response = repository.getSchoolData()
            //we use this census count because we need to write to it
            _schoolCount.value = response ?: emptyList()
            _schoolCount.emit(response ?: emptyList())
        }
    }
}