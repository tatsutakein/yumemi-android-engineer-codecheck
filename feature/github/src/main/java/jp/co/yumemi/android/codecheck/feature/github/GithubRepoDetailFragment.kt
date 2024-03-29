/*
 * Copyright © 2021 YUMEMI Inc. All rights reserved.
 */
package jp.co.yumemi.android.codecheck.feature.github

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import dagger.hilt.android.AndroidEntryPoint
import jp.co.yumemi.android.codecheck.feature.github.databinding.FragmentGithubrepoDetailBinding

@AndroidEntryPoint
class GithubRepoDetailFragment : Fragment(R.layout.fragment_githubrepo_detail) {

    private val githubRepoDetailViewModel: GithubRepoDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentGithubrepoDetailBinding.bind(view)

        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            githubRepoDetailViewModel.githubRepo.collect { githubRepo ->
                binding.ownerIconView.load(githubRepo.ownerIconUrl)
                binding.ownerNameView.text = githubRepo.ownerName

                binding.nameView.text = githubRepo.name
                binding.descriptionView.text = githubRepo.description

                binding.languageView.text =
                    getString(R.string.github_repo_detail_writtenLanguage, githubRepo.language)
                binding.starsView.text =
                    getString(R.string.github_repo_detail_stars, githubRepo.stargazersCount)
                binding.watchersView.text =
                    getString(R.string.github_repo_detail_watchers, githubRepo.watchersCount)
                binding.forksView.text =
                    getString(R.string.github_repo_detail_forks, githubRepo.forksCount)
                binding.openIssuesView.text =
                    getString(R.string.github_repo_detail_openIssues, githubRepo.openIssuesCount)
            }
        }
    }
}
