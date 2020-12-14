package com.file.saurabh.byline.newsfragment


import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil


import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

import com.file.saurabh.byline.R
import com.file.saurabh.byline.databinding.NewsCardItemLayoutBinding
import com.file.saurabh.byline.network.moshipropertyclasses.Article



class NewsViewAdapter(private val newsViewCardClickedListener: NewsViewCardClickedListener) : RecyclerView.Adapter<NewsViewAdapter.NewsCardViewHolder>() {


    private var currentArticles : MutableList<Article> = mutableListOf()

    class NewsCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val newsSource : TextView = itemView.findViewById(R.id.source)
        val newsDescription : TextView = itemView.findViewById(R.id.description)
        val newsImage : ImageView = itemView.findViewById(R.id.newsImage)
        val progressBar : ProgressBar = itemView.findViewById(R.id.progressBar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsCardViewHolder {
        val layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<NewsCardItemLayoutBinding>(layoutInflater, R.layout.news_card_item_layout,parent,false)

        return  NewsCardViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: NewsCardViewHolder, position: Int) {

        holder.newsSource.text = currentArticles[position].source.name.toUpperCase()
        holder.newsDescription.text = currentArticles[position].description
        holder.newsImage.setImageResource(R.drawable.ic_launcher_foreground)
        holder.progressBar.visibility = ProgressBar.VISIBLE
        Glide.with(holder.itemView.context)
                .load(currentArticles[position].urlToImage)
                .listener(object : RequestListener<Drawable>{
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        holder.progressBar.visibility = ProgressBar.GONE
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        holder.progressBar.visibility = ProgressBar.GONE
                        return false
                    }

                })
                .error(R.drawable.ic_baseline_image_not_supported_24)
                .into(holder.newsImage)

        holder.itemView.setOnClickListener {
                newsViewCardClickedListener.onNewsViewCardClicked(holder.itemView.context,currentArticles[position].url)
        }


    }

    override fun getItemCount(): Int {
        return currentArticles.size
    }

    fun updateArticleList(newArticles : List<Article>){
        currentArticles.clear()
        currentArticles.addAll(newArticles)

        notifyDataSetChanged()
    }

    interface NewsViewCardClickedListener{
        fun onNewsViewCardClicked(context : Context ,url : String)
    }
}