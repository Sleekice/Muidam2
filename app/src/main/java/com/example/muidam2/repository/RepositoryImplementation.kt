package com.example.apicompose.repository


import com.example.muidam2.remote.ApiRequest
import javax.inject.Inject


class RepositoryImplementation @Inject constructor(val service: ApiRequest) : Repository {
    override suspend fun getSchoolData() =  service.getSchoolData()



}