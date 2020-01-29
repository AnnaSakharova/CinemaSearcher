package com.example.cinemasearcher.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemasearcher.R
import com.example.cinemasearcher.network.Movies
import com.squareup.picasso.Picasso


class RecyclerAdapter(val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.MovieViewHolder>() {

    var moviesAL: ArrayList<Movies> = arrayListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item4recycler, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount() = moviesAL.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie: Movies = moviesAL.get(position)

        var URLposter: String = currentMovie.poster_path

        holder.title.text = moviesAL.get(position).title
        holder.imdb.text = moviesAL.get(position).id.toString()
        holder.type.text = moviesAL.get(position).release_date
        holder.year.text = moviesAL.get(position).original_language.toString()

        Picasso.get().load(URLposter).fit().into(holder.poster)

    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.tvTitle)
        val poster: ImageView = itemView.findViewById(R.id.poster)
        val type: TextView = itemView.findViewById(R.id.tvType)
        val year: TextView = itemView.findViewById(R.id.tvYear)
        val imdb: TextView = itemView.findViewById(R.id.tvimdb)

    }

}