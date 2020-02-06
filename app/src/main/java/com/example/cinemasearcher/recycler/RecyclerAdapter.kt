package com.example.cinemasearcher.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemasearcher.R
import com.example.cinemasearcher.network.MovieModel
import com.example.cinemasearcher.network.PopularMovies
import com.squareup.picasso.Picasso


class RecyclerAdapter(val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.MovieViewHolder>() {

    var resultsList: List<MovieModel> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view: View =
            LayoutInflater.from(context).inflate(R.layout.item4recycler, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = resultsList.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val currentMovie: MovieModel = resultsList.get(position)

        var URLposter: String? = currentMovie.poster_path

        holder.tvTitle.text = resultsList.get(position).title
        holder.tvImage.text = resultsList.get(position).id.toString()
        holder.tvType.text = resultsList.get(position).release_date
        holder.tvYear.text = resultsList.get(position).original_language

        Picasso.get().load(URLposter).fit().into(holder.tvPoster)

    }

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvPoster: ImageView = itemView.findViewById(R.id.poster)
        val tvType: TextView = itemView.findViewById(R.id.tvType)
        val tvYear: TextView = itemView.findViewById(R.id.tvYear)
        val tvImage: TextView = itemView.findViewById(R.id.tvimdb)

    }

}