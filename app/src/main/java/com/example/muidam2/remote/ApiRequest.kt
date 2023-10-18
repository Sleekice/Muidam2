package com.example.muidam2.remote


import com.example.muidam2.model.SchoolOpsItemModel
import retrofit2.http.GET

interface ApiRequest {

    @GET(ApiDetails.ENDPOINT)
    suspend fun getSchoolData(): List<SchoolOpsItemModel>
            //suspend -> pauses functionality until resources become available.
            //helps run in the background
            //required to run coroutines



    //API Handling
//    - Imports
//        - Retrofit
//        - OKHttp
//        - Interceptor
//        - Logger
//    -Data Classes
//    -BASE URL& END POINTS
//    - Retrofit Integration -> Interfaces - Suspend Function for accesss.
//    - Request and response expectation
//    Repository Implementation Handles the requests.




}