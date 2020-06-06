package com.example.cinemasearcher.UI

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.ListFragment
import androidx.viewpager.widget.ViewPager
import com.example.cinemasearcher.R
import com.example.cinemasearcher.UI.fragments.MoviesFragment
import com.example.cinemasearcher.UI.fragments.MoviesFragment.Companion.newInstance
import com.example.cinemasearcher.ViewPagerAdapter


class MainActivity : AppCompatActivity() {

    lateinit var txtWarning: TextView

//    val TAG = "Debug"
//    val RXLOG = "RXLOG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtWarning = findViewById(R.id.txt_warning)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.root_layout, MoviesFragment.newInstance(), "ListFrag")
                .commit()
        }

        val vievPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.pager)
        viewPager.adapter = vievPagerAdapter
    }


//    override fun onItemClicked() {
//       // Toast.makeText(this, "Click", Toast.LENGTH_SHORT)
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.root_layout, DetailFragment.newInstanceDetail(), "DetailFrag")
//            .addToBackStack(null)
//            .commit()
//    }

}


/** К каждой транзакции с фрагментом можно применить анимацию перехода, вызвав setTransition() до фиксации.
Вызов метода commit() не приводит к немедленному выполнению транзакции.
Метод запланирует ее выполнение в потоке пользовательского интерфейса операции (в «главном» потоке),
как только у потока появится возможность для этого. */


//
//    override fun onItemClick(view: View, position: Int) {
//        super.onItemClick(view, position)
//        val list = recyclerAdapter.resultsList
//        list.get(position)
//        val intent = Intent(this, DetailActivity::class.java)
//        startActivity(intent)
//    }
//
//    private fun responseFromAPI() {
//
//        val disposable: Disposable = RetrofitService.start().getMovies()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeBy(
//                onSuccess = { it: PopularMovies -> setDataIntoList(it) },
//                onError = { it: Throwable ->
//                    it.printStackTrace().toString()
//                    Log.d(RXLOG, "Произошла ошибка")
//                })
//    }


//    private fun responseFromAPI() {
//        val call: Call<PopularMovies> = RetrofitService.start().getMovies()
//
//        val single: Single<NetworkResult> =
//            Single.create<NetworkResult> { emitter: SingleEmitter<NetworkResult> ->
//
//                emitter.setDisposable(Disposables.fromAction { call.cancel() })
//
//                call.enqueue(object : Callback<PopularMovies> {
//                    override fun onResponse(
//                        call: Call<PopularMovies>, response: Response<PopularMovies>
//                    ) {
//                        if (response.body() != null) {
//                            response.body()?.let { emitter.onSuccess(NetworkResult.Success(it)) }
//                            if (response.body() == null) {
//                                emitter.onSuccess()
//                            }
//                            if (response.code() != 200) {
//                                val responseCode = response.code()
//                                emitter.onError(NetworkResult.Error())
//                            } else {
//                                val erorBody = response.errorBody().toString()
//                                emitter.onError(Throwable(erorBody, Throwable()))
//                            }
//                        }
//                    }
//
//                    override fun onFailure(call: Call<PopularMovies>, t: Throwable) {
//                        emitter.onError(t)
//                    }
//                })
//            }
//
//        val disposable: Disposable = single.subscribeBy(
//            onSuccess = {
//                val success = it as NetworkResult.Success
//                val movies = success.popularMovies
//                setDataIntoList(movies)
//            },
//            onError = {
//                recyclerView.visibility = View.GONE
//                txtWarning.visibility = View.VISIBLE
//                it.printStackTrace()
//                handleErrors(it)
//            }
//        )
//    }

//    private fun handleErrors(t: Throwable) {
//        when (t) {
//            is HttpException -> {
//                when (t.code()) {
//                    404 -> {
//                        txtWarning.setText(R.string.warning404)
//                        Log.d(TAG, "Ошибка 404")
//                    }
//                    500 -> {
//                        txtWarning.setText(R.string.warning500)
//                        Log.d(TAG, "Ошибка 500")
//                    }
//                    else -> {
//                        txtWarning.setText(R.string.unknownError)
//                        val errorBody = t.response()?.errorBody().toString()
//                        Log.d(RXLOG, "Неизвестная ошибка $errorBody")
//
//                    }
//                }
//            }
//            is IOException -> {
//
//            }
//            else -> {
//                txtWarning.visibility = View.VISIBLE
////              val errorBody = t.response()?.errorBody().toString()
////              Log.d(RXLOG, "Неизвестная ошибка $errorBody")
//                Log.d(
//                    RXLOG,
//                    "Неизвестная ошибка. Message:  ${t.message}, StackTrace ${t.getStackTrace()}"
//                )
//            }
//        }
//    }


//                if( == null) {
//                    val emptyBody = NetworkResult.EmptyResponse
//                    Log.d(RXLOG, "Список фильмов пуст $emptyBody")}

//
//    private fun setDataIntoList(popularMovies: PopularMovies): List<MovieModel> {
//
//        var listMov: List<MovieModel> = popularMovies.results
//        return setDataIntoRecyclerView(listMov)
//    }
//
//    private fun setDataIntoRecyclerView(listOfMovieModel: List<MovieModel>): List<MovieModel> {
//
//        txtWarning.visibility = View.GONE
//        recyclerAdapter.resultsList = listOfMovieModel
//        recyclerAdapter.notifyDataSetChanged()
//        Log.d(TAG, "setDataIntoRecyclerView")
//        return listOfMovieModel
//    }


//
//    val observable: Observable<ClickEvent> = Observable.create<ClickEvent> { emitter ->
//
//        val listener = View.OnClickListener { view ->
//            if(!emitter.isDisposed) {
//            emitter.onNext(ClickEvent) }
//        }
//
//        button.setOnClickListener(listener)
//        emitter.setDisposable(Disposables.fromAction {
//            button.setOnClickListener(null)
//        })
//
//    }
//
//    val disposable: Disposable = observable
//        .map { сlickEvent: ClickEvent -> "$сlickEvent is happened" }
//        .subscribeBy(
//            onNext = { Log.d(RXLOG, it) },
//            onError = { Log.d(RXLOG, "onError")})
//


//
//    fun setClick (){
//
//        val movieId: Int = intent.getIntExtra("id", 1)
//
//        val intent = Intent(this@MainActivity, Activity_Detail::class.java) {
//            intent.putExtra("id", movieId)
//            this.startActivity(intent)
//        }
//    }


//    override fun onDestroy() {
//        super.onDestroy()
//        if(!disposable.isDisposed) {
//            disposable.dispose()
//        }
