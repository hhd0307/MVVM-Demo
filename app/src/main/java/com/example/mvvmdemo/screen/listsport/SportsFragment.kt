package com.example.mvvmdemo.screen.listsport

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.mvvmdemo.R
import com.example.mvvmdemo.data.model.Sport
import com.example.mvvmdemo.databinding.FragmentSportsBinding
import com.example.mvvmdemo.screen.detail.DetailFragment
import com.example.mvvmdemo.screen.listsport.adapter.SportAdapter
import com.example.mvvmdemo.utils.Status
import com.example.mvvmdemo.utils.extension.addFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val TAG = "SportsFragment"
class SportsFragment : Fragment() {

    private val sportsViewModel by viewModel<SportsViewModel>()
    private val sportAdapter by lazy {
        SportAdapter {
            showSportDetail(it)
        }
    }

    private lateinit var binding: FragmentSportsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentSportsBinding>(
            inflater,
            R.layout.fragment_sports,
            container,
            false
        ).apply {
            lifecycleOwner = this@SportsFragment
            adapter = sportAdapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserver()
    }

    private fun setupObserver() {
        sportsViewModel.sports.observe(viewLifecycleOwner, Observer {
            sportAdapter.updateData(it)
        })
        sportsViewModel.status.observe(viewLifecycleOwner, Observer {
            when  (it) {
                Status.SUCCESS -> {}
                Status.ERROR -> {
                    Toast.makeText(context,getString(R.string.no_result_return), Toast.LENGTH_SHORT).show()
                }
                Status.LOADING -> {
                    Toast.makeText(context,getString(R.string.loading), Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun showSportDetail(sport: Sport) {
        addFragment(R.id.fragmentContainer, DetailFragment.newInstance(sport))
    }

    companion object {
        fun newInstance() = SportsFragment()
    }
}
