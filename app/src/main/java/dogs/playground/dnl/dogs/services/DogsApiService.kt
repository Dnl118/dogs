package dogs.playground.dnl.dogs.services

import dogs.playground.dnl.dogs.model.DogPhoto
import retrofit2.Call
import retrofit2.http.GET

interface DogsApiService {

    @GET("breeds/image/random")
    fun getRandomDog()

    @GET("breeds/list/all")
    fun getBreedsList() : Call<DogPhoto>
}