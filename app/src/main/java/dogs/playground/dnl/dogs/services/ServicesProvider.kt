package dogs.playground.dnl.dogs.services

import dogs.playground.dnl.dogs.DOGS_API_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ServicesProvider {

    //init retrofit
    private val retrofit = Retrofit.Builder()
            .baseUrl(DOGS_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    //Single-Expression function
    fun dogsService(): DogsApiService = retrofit.create(DogsApiService::class.java)

}