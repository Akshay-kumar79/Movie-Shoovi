package com.example.movieshoovi.movieDetailsfragment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movieshoovi.models.SingleCastModel
import com.example.movieshoovi.databinding.CastListItemBinding

class CastListAdapter(private val context: Context, private val castList: List<SingleCastModel>)
    : RecyclerView.Adapter<CastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(castList[position], context)
    }

    override fun getItemCount(): Int {
        return castList.size
    }



    class ViewHolder private constructor(private val binding: CastListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(cast: SingleCastModel, context: Context) {
            binding.actualName.text = cast.actualName
            binding.onScreenName.text = cast.onScreenName
            binding.castImage.setImageResource(cast.imageUrl)
        }

        companion object {
                fun from(parent: ViewGroup): ViewHolder {
                    val inflater = LayoutInflater.from(parent.context)
                    val binding = CastListItemBinding.inflate(inflater, parent, false)
                    return ViewHolder(binding)
            }
        }
    }
}