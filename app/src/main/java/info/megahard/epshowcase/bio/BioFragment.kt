package info.megahard.epshowcase.bio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import info.megahard.epshowcase.R
import info.megahard.epshowcase.base.BaseFragment
import info.megahard.epshowcase.databinding.BioFragmentBinding

class BioFragment : BaseFragment() {

    private val viewModel: BioViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        val binding: BioFragmentBinding = DataBindingUtil.inflate(inflater, R.layout.bio_fragment, container, false)

        lifecycle.addObserver(viewModel)

        setHasOptionsMenu(true)

        with(binding) {
            model = viewModel

            setLifecycleOwner(viewLifecycleOwner)

            recyclerView.setHasFixedSize(true)

            swipeRefresh.setOnRefreshListener { binding.model!!.refresh() }

            viewModel.refresh()
            viewModel.isLoading.observe(viewLifecycleOwner, Observer {
                if (it == false) {
                    swipeRefresh.isRefreshing = false
                }
            })

            return root
        }
    }
}