package com.example.reposlisting.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.reposlisting.R
import com.example.reposlisting.data.Repo
import com.example.reposlisting.databinding.RepoListItemBinding

class RepoAdapter(repoClickCallback: RepoClickCallback) :
    RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    private var reposList: List<Repo>? = null
    private val mCallback: RepoClickCallback = repoClickCallback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {

        val repoListItemBinding: RepoListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.repo_list_item,
            parent,
            false
        )
        repoListItemBinding.callback = mCallback
        return RepoViewHolder(repoListItemBinding)
    }

    override fun getItemCount(): Int {
        return reposList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {

        holder.repoItemBinding.repo = reposList?.get(position)
    }


    class RepoViewHolder(repoListItemBinding: RepoListItemBinding) :
        RecyclerView.ViewHolder(repoListItemBinding.root) {
        val repoItemBinding: RepoListItemBinding = repoListItemBinding

    }

    fun setReposList(reposDataList: List<Repo>) {

        if (reposList == null) {
            reposList = reposDataList
            notifyItemRangeInserted(0, reposDataList.size)
        } else {

            val result = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
                override fun getOldListSize(): Int {
                    return reposList?.size ?: 0
                }

                override fun getNewListSize(): Int {
                    return reposDataList.size
                }

                override fun areItemsTheSame(
                    oldItemPosition: Int,
                    newItemPosition: Int
                ): Boolean {
                    return reposList?.get(oldItemPosition)?.id ===
                            reposDataList.get(newItemPosition).id
                }

                override fun areContentsTheSame(
                    oldItemPosition: Int,
                    newItemPosition: Int
                ): Boolean {
                    val newRepo: Repo = reposList?.get(newItemPosition) ?: Repo()
                    val oldRepo: Repo = reposDataList.get(oldItemPosition)
                    return (newRepo.id === oldRepo.id && newRepo.name == oldRepo.name
                            && newRepo.description == oldRepo.description
                            && newRepo.starsCount === oldRepo.starsCount && newRepo.isBookmarked == oldRepo.isBookmarked)
                }
            })
            reposList = reposDataList
            result.dispatchUpdatesTo(this)
        }

    }

}
