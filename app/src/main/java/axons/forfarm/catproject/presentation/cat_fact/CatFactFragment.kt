package axons.forfarm.catproject.presentation.cat_fact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import axons.forfarm.catproject.databinding.FragmentCatDetailBinding
import axons.forfarm.catproject.databinding.FragmentCatFactBinding
import axons.forfarm.catproject.presentation.cat_detail.CatDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatFactFragment : Fragment() {
    companion object {
        fun newInstance() = CatFactFragment()
    }
    val viewModel: CatFactViewModel by viewModels()
    lateinit var binding: FragmentCatFactBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_cat_image_list, container, false)

        binding = FragmentCatFactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //เรียก viewModel
        viewModel.init()

        viewModel.fact.observe(viewLifecycleOwner) {
            e -> e.getContentIfNotHandled()?.let {
                binding.catfactText.text = it
            }
        }

        initControl()


    }
    //ไม่มี onAttach เพราะไม่ต้องรับค่าจากหน้าที่แล้ว

    private fun initControl() {
        binding.btnFactRefresh.setOnClickListener() {
            //refresh
            viewModel.init()
        }
    }
}