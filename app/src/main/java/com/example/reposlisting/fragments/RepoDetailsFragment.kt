package com.example.reposlisting.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.reposlisting.R
import com.example.reposlisting.data.Repo
import com.example.reposlisting.databinding.RepoDetailsFragmentBinding
import com.example.reposlisting.view_models.RepoViewModel

class RepoDetailsFragment: Fragment() {

    private val viewModel: RepoViewModel by viewModels()
    private lateinit var mDetailsBinding: RepoDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mDetailsBinding  =
            DataBindingUtil.inflate(inflater, R.layout.repo_details_fragment, container, false)

        viewModel.repo.value = arguments?.getParcelable("repo")

        return mDetailsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.repo.observe(this, Observer {
            mDetailsBinding.repo = it
        })


    }

    companion object {
        fun getRepoDetailsFragment(repo:Repo): RepoDetailsFragment{

            val detailsFragment = RepoDetailsFragment()
            detailsFragment.arguments = Bundle()
            detailsFragment.arguments?.putParcelable("repo",repo)
            return detailsFragment
        }
    }
}