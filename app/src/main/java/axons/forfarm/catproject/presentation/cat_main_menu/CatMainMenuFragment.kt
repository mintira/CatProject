package axons.forfarm.catproject.presentation.cat_main_menu

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import axons.forfarm.catproject.R
import axons.forfarm.catproject.databinding.ActivityMainBinding
import axons.forfarm.catproject.databinding.FragmentCatMainMenuBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CatMainMenuFragment : Fragment() {

    companion object {
        fun newInstance() = CatMainMenuFragment()
    }

    val viewModel: CatMainMenuViewModel by viewModels()

    private lateinit var binding: FragmentCatMainMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatMainMenuBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initControl()
        initViewModel()

    }


    private fun initControl() {

        binding.buttonCatFactApi.setOnClickListener {
            findNavController().navigate(
                R.id.catFactFragment,
            )
        }

        binding.buttonCatImageApi.setOnClickListener {
            findNavController().navigate(
                R.id.catImageListFragment,
                bundleOf("number_of_image" to 10)
            )
        }

        binding.buttonCatBreedsApi.setOnClickListener {
            findNavController().navigate(
                R.id.catBreedsListFragment,
                bundleOf("number_of_breed" to 10)
            )
        }
    }

    private fun initViewModel() {


    }

}