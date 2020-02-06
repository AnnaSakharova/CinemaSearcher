package com.example.cinemasearcher.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemasearcher.R
import com.example.cinemasearcher.network.MovieModel
import com.example.cinemasearcher.network.PopularMovies
import com.example.cinemasearcher.network.RetrofitService
import com.example.cinemasearcher.recycler.RecyclerAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

//    val KEY_TITLE = "title"
//    val KEY_POSTER_URL = "poster"
//    val KEY_YEAR = "year"
//    val KEY_TYPE = "type"
//    val KEY_IMDB = "imdbID"

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter

    val TAG = "Debug"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
        recyclerAdapter = RecyclerAdapter(this@MainActivity)
        recyclerView.adapter = recyclerAdapter
        Log.d(TAG, "Назначен адаптер")

        responseFromAPI()

    }

    private fun responseFromAPI() {

        var call = RetrofitService.start().getMovies()

        call.enqueue(object : Callback<PopularMovies> {

            var txtWarning: TextView = findViewById(R.id.txt_warning)
            override fun onResponse(
                call: Call<PopularMovies>, response: Response<PopularMovies>
            ) {

                if ((response.isSuccessful)) {
                    if (response.code() == 0) {
                        recyclerView.visibility = View.GONE
                        txtWarning.visibility = View.VISIBLE
                        txtWarning.setText(R.string.notAvaliable)
                        Log.d(TAG, "if (response.code() == 0)")
                    }
                    if (response.code() != 0) {
                        val moviesResponse = response.body()
                        moviesResponse?.let { setDataIntoRecyclerView(it) }
                        Log.d(TAG, "Получение тела ответа")
                    }
                } else {
                    when (response.code()) {
                        404 -> {
                            recyclerView.visibility = View.GONE
                            txtWarning.visibility = View.VISIBLE
                            txtWarning.setText(R.string.warning404)
                            Log.d(TAG, "Ошибка 404")
                        }
                        500 -> {
                            recyclerView.visibility = View.GONE
                            txtWarning.visibility = View.VISIBLE
                            txtWarning.setText(R.string.warning500)
                            Log.d(TAG, "Ошибка 500")
                        }
                        else -> {
                            recyclerView.visibility = View.GONE
                            txtWarning.visibility = View.VISIBLE
                            txtWarning.setText(R.string.unknownError)
                        }

                    }
                }
            }

            override fun onFailure(call: Call<MovieModel>, t: Throwable) {
                recyclerView.visibility = View.GONE
                txtWarning.visibility = View.VISIBLE
                txtWarning.setText(R.string.unknownError)
                t.printStackTrace()
                Log.d(TAG, "Прога упала в onFailure")

            }
        })
    }

    private fun setDataIntoRecyclerView(movieModel: PopularMovies) {

        val listFromResponse: List<MovieModel> = movieModel.results

        recyclerAdapter.resultsList = listFromResponse
        recyclerAdapter.notifyDataSetChanged()
        Log.d(TAG, "setDataIntoRecyclerView")

    }
}
//
//    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//
//        val intent = Intent(this, Activity_Detail::class.java)
//
//        val clickedMovie: Movies = moviesArrayList.get(position)
//
//        intent.putExtra(KEY_TITLE, clickedMovie.title)
//        intent.putExtra(KEY_IMDB, clickedMovie.imdbID)
//        intent.putExtra(KEY_TYPE, clickedMovie.type)
//        intent.putExtra(KEY_YEAR, clickedMovie.year)
//        intent.putExtra(KEY_POSTER_URL, clickedMovie.posterURL)
//
//        startActivity(intent)
//
//    }
//}







