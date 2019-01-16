package info.megahard.epshowcase.skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import info.megahard.epshowcase.databinding.PlaceholderFragmentBinding

class SkillsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = PlaceholderFragmentBinding.inflate(inflater)
        binding.name = "Skills"
        return binding.root
    }
}