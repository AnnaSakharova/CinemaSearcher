package com.example.cinemasearcher.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.cinemasearcher.R
import kotlinx.android.synthetic.main.detail_fragment.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_fragment)

        // это с активити
        //val titl = intent.extras("tvTitle")
        val movieTitle: TextView = findViewById(R.id.movie_title)
        //movieTitle.text = titl

        /**
         * из фрагмента в активити через приведение к интерфейсу
         *
         * */

        // с фрагментами через аргументы
        /** это там, откуда хочется передать данные
         *  val bundle = Bundle()
         *  bundle.putString("token", "kdjfhg")
         *  ListFragment.newInstance(args = bundle )
         *
         *  фрагмент создается с уже заполенными данными
         *
         *  дальше во фрагменте можно все эти параметры использовать
         *
         * это ListFragment
         * companion object {
         *      fun newInstance( movieModel: MovieModel ) : ListFragment {
         *              val listFragment = ListFragment()
         *              listFragment.arguments?.putParcelable("movieModel", movieModel)
         *              return listFragment
         *      }
         * }
         *
         * argumemnts это по сути тот же самый экстрас, у него тип тот же самый - БАНДЛ
         *
         * обращение фрагмента к активити должно происходить только в ключе передачи инфы
         * через интерфейс
         * (activity as InterfaceName).showSmth()
         * */

    }
}
