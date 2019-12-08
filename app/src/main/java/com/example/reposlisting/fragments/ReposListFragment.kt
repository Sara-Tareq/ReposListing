package com.example.reposlisting.fragments

import android.database.Observable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.reposlisting.R
import com.example.reposlisting.data.Repo
import com.example.reposlisting.databinding.RepoListFragmentBinding
import com.example.reposlisting.ui.RepoAdapter
import com.example.reposlisting.view_models.RepoListViewModel

class ReposListFragment : Fragment() {

    private lateinit var mListBinding: RepoListFragmentBinding
    private  val repoAdapter: RepoAdapter = RepoAdapter()

    val viewModel :RepoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mListBinding =
            DataBindingUtil.inflate(inflater, R.layout.repo_list_fragment, container, false)

        mListBinding.repoList.adapter = repoAdapter

        return mListBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.repoDataList.observe(this,Observer<List<Repo>>() {

            repoAdapter.setReposList(it)

        })
    }
}