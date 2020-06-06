package com.example.cinemasearcher.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemasearcher.R
import com.example.cinemasearcher.model.MovieModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item4recycler.view.*


class RecyclerAdapter(val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.MovieViewHolder>(){

    var resultsList: List<MovieModel> = emptyList()
    //var listener = ListFragment.newInstance().onItemFragmentListener

    // var mm = MovieModel

    val TAG = "Debug"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item4recycler, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = resultsList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        var postersURL: String? = resultsList.get(position).poster_path

        val fullImgUrl: String? = buildImageURL(postersURL)

        Picasso.get().isLoggingEnabled = true
        Picasso.get().load(fullImgUrl)
            .fit()
            .placeholder(R.drawable.nedostupno)
            .error(R.drawable.nedostupno)
            .into(holder.tvPoster)

        holder.tvTitle.text = resultsList.get(position).title
        holder.tvId.text = resultsList.get(position).id.toString()
        holder.tvReleaseDate.text = resultsList.get(position).release_date
        holder.tvOriginalLanguage.text = resultsList.get(position).original_language
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        var tvPoster: ImageView = itemView.poster
        var tvTitle: TextView = itemView.tvTitle
        var tvOriginalLanguage: TextView = itemView.tv_original_language
        var tvReleaseDate: TextView = itemView.tv_release_date
        var tvId: TextView = itemView.tv_id

        val itempos: Int = getAdapterPosition()


         val itView = itemView.setOnClickListener { onClick(itemView) }
        //val bundle = Bundle()


        override fun onClick(v: View?) {
            val itempos: Int = getAdapterPosition()
           // onItemFragmentListener.onItemClicked(v, itempos)
            //val intent = Intent(context, DetailActivity::class.java)

            //intent.putExtra("movie", )
            //startActivity(context, intent, Bundle())
        }
    }

    private fun buildImageURL(posterPath: String?): String? {
        val base_img_URL = "http://image.tmdb.org/t/p/"
        val size = "original"
        val fullURL: String? = base_img_URL + size + posterPath
        return fullURL
    }
//    interface OnItemFragmentListener {
//        fun onItemClicked(v: View?, posit: Int)
//    }
}


//        fun bind(popularMovies: PopularMovies){
//            tvTitle.text = popularMovies.results.t
//

