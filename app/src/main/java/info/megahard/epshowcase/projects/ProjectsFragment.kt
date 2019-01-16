package info.megahard.epshowcase.projects

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import info.megahard.epshowcase.databinding.PlaceholderFragmentBinding

class ProjectsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = PlaceholderFragmentBinding.inflate(inflater)
        binding.name = "Projects"
        return binding.root
    }
}