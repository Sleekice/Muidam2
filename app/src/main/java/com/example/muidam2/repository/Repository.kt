package com.example.apicompose.repository

import com.example.muidam2.model.SchoolOpsItemModel


interface Repository {


    //A cetneral pattern that give you access to your data.
    suspend fun getSchoolData(): List<SchoolOpsItemModel>

}