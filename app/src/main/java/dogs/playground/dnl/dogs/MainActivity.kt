package dogs.playground.dnl.dogs

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dogs.playground.dnl.dogs.databinding.ActivityMainBinding
import dogs.playground.dnl.dogs.model.DogPhoto
import dogs.playground.dnl.dogs.services.ServicesProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //init data binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //first retrofit call
        ServicesProvider().dogsService().getBreedsList().enqueue(object : Callback<DogPhoto> {
            override fun onResponse(call: Call<DogPhoto>?, response: Response<DogPhoto>?) {

                val textResponse = response.toString()
                binding.title.text = textResponse

                Log.d(TAG, "onResponse: $response")
            }

            override fun onFailure(call: Call<DogPhoto>?, t: Throwable?) {
                val error = t.toString()
                binding.title.text = error

                Log.d(TAG, "onFailure: $error")
            }
        })

    }
}
