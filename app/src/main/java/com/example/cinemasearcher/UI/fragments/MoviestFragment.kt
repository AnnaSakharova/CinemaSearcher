package com.example.cinemasearcher.UI.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemasearcher.R
import com.example.cinemasearcher.model.MovieModel
import com.example.cinemasearcher.model.PopularMovies
import com.example.cinemasearcher.network.RetrofitService
import com.example.cinemasearcher.recycler.RecyclerAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class MoviesFragment : Fragment() {


    lateinit var recyclerAdapter: RecyclerAdapter
    //lateinit var onItemFragmentListener: OnItemFragmentListener

    val TAG = "Debug"
    val RXLOG = "RXLOG"

    companion object {
        fun newInstance() =
            MoviesFragment()
    }

//    interface OnItemFragmentListener {
//        fun onItemClicked()
//    }

    /** 1)
     * onAttach мы на вход получаем Activity, к которому присоединен фрагмент.
     * Мы пытаемся привести это Activity к типу интерфейса,
     * чтобы можно было вызывать метод onClick и передать туда строку.
    Теперь Listener ссылается на Activity. */

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//            try {
//                onItemFragmentListener = context as OnItemFragmentListener
//            } catch (e: ClassCastException) {
//                throw ClassCastException("$context должен имплементировать OnItemFragmentListener")
//            }
//    }

    /**    2)
    Cистема вызывает этот метод, когда создает фрагмент. Или пересоздает после сохранения.
     * Разработчик должен инициализировать ключевые компоненты фрагмента, которые требуется сохранить,*/
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//    }

    /**    3)
     * Cистема вызывает при первом отображении пользовательского интерфейса
     *  когда фрагмент должен отобразить свой макет.
    container, является родительским классом ViewGroup (из макета операции), в который будет вставлен макет фрагмента
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_frag, container, false)
        val activity = activity as Context
        val recyclerView = view.findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerAdapter = RecyclerAdapter(activity)
        recyclerView.adapter = recyclerAdapter

//        recycler_view.apply {
//            layoutManager = LinearLayoutManager(activity)
//            recyclerAdapter = RecyclerAdapter(activity)
//            adapter = recyclerAdapter                   //activity?.let { RecyclerAdapter(it) }
//        }
        responseFromAPI()
        return view
    }



    /** Вызывается, когда метод активити onCreate() возвращает управление.
     * Доступ к иерархии представлений родительского Activity должен быть выполнен в onActivityCreated.
    На этом этапе безопасно выполнять поиск объектов View, например, по их идентификатору. */
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//    }



//
//
//    override fun onDetach() {
//        super.onDetach()
//
//    }

    private fun responseFromAPI() {

        val disposable: Disposable = RetrofitService.start().getMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { setDataIntoList(it) },
                onError = {
                    it.printStackTrace().toString()
                    Log.d(RXLOG, "Произошла ошибка")
                })
    }

    private fun setDataIntoList(popularMovies: PopularMovies): List<MovieModel> {

        var listMov: List<MovieModel> = popularMovies.results
        return setDataIntoRecyclerView(listMov)
    }

    private fun setDataIntoRecyclerView(listOfMovieModel: List<MovieModel>): List<MovieModel> {
       // txtWarning.visibility = View.GONE
        recyclerAdapter.resultsList = listOfMovieModel
        recyclerAdapter.notifyDataSetChanged()
        Log.d(TAG, "setDataIntoRecyclerView")
        return listOfMovieModel
    }
}

