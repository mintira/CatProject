package axons.forfarm.catproject.presentation.cat_breeds_detail

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import axons.forfarm.catproject.R
import axons.forfarm.catproject.databinding.FragmentCatBreedsDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatBreedsDetailFragment : Fragment() {

    companion object {
        fun newInstance() = CatBreedsDetailFragment()
    }

    val viewModel: CatBreedsDetailViewModel by viewModels()
    lateinit var binding: FragmentCatBreedsDetailBinding
    lateinit var catBreeds: String
    lateinit var catCountry: String
    lateinit var catCoat: String
    lateinit var catPattern: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatBreedsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getString("breed")?.let {
            catBreeds = it
        }
        arguments?.getString("country")?.let {
            catCountry = it
        }
        arguments?.getString("coat")?.let {
            catCoat = it
        }
        arguments?.getString("pattern")?.let {
            catPattern = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            viewModel.init(catBreeds, catCountry, catCoat, catPattern)

            viewModel.catBreeds.observe(viewLifecycleOwner) {
                binding.catBreedsText.text = it
            }

            viewModel.catCountry.observe(viewLifecycleOwner) {
                binding.catCountryText.text = it
            }

            viewModel.catCoat.observe(viewLifecycleOwner) {
                binding.catCoatText.text = it
            }

            viewModel.catPattern.observe(viewLifecycleOwner) {
                binding.catPatternText.text = it
            }

    }

}