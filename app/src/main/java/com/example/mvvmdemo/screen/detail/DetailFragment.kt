package com.example.mvvmdemo.screen.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mvvmdemo.R
import com.example.mvvmdemo.data.model.Sport
import com.example.mvvmdemo.databinding.FragmentDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val viewModel by viewModel<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentDetailBinding>(
            inflater,
            R.layout.fragment_detail,
            container,
            false
        ).apply {
            lifecycleOwner = this@DetailFragment
            viewModel = this@DetailFragment.viewModel
            buttonImageBack.setOnClickListener {
                parentFragmentManager.popBackStack()
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.run {
            val data: Sport? = getParcelable(ARGUMENT_SPORT)
            viewModel.setSport(data)
        }
    }

    companion object {
        const val ARGUMENT_SPORT = "ARGUMENT_SPORT"

        fun newInstance(sport: Sport?) = DetailFragment().apply {
            arguments = bundleOf(ARGUMENT_SPORT to sport)
        }
    }
}
