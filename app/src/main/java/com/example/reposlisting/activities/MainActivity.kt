package com.example.reposlisting.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.reposlisting.R
import com.example.reposlisting.data.Repo
import com.example.reposlisting.fragments.RepoDetailsFragment
import com.example.reposlisting.fragments.ReposListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ReposListFragment(), "repos_list_frag").commit()
        }

    }

    fun showDetailsScreen(repo: Repo) {
        supportFragmentManager.beginTransaction()
            .addToBackStack("repo")
            .replace(R.id.fragment_container, RepoDetailsFragment.getRepoDetailsFragment(repo),"repo_details").commit()
    }
}
