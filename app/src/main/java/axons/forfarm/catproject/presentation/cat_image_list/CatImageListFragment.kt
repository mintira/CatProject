package axons.forfarm.catproject.presentation.cat_image_list

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import axons.forfarm.catproject.R
import axons.forfarm.catproject.databinding.FragmentCatDetailBinding
import axons.forfarm.catproject.databinding.FragmentCatImageListBinding
import axons.forfarm.catproject.databinding.FragmentCatMainMenuBinding
import axons.forfarm.catproject.presentation.cat_image_list.controller.CatImageListEpoxyController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CatImageListFragment : Fragment() {

    companion object {
        fun newInstance() = CatImageListFragment()
    }

    val viewModel: CatImageListViewModel by viewModels()

    lateinit var binding: FragmentCatImageListBinding

    @Inject //เอาไว้ใช้กับ list
    lateinit var controller: CatImageListEpoxyController

    private var numberOfImage: Int = 0
    lateinit var catImage: String
    lateinit var catId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_cat_image_list, container, false)

        binding = FragmentCatImageListBinding.inflate(inflater, container, false)
        return binding.root

    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getInt("number_of_image")?.let {
            numberOfImage = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initControl()
        initViewModel()

        viewModel.init(numberOfImage)
    }

    private fun initControl() {
        binding.epoxyRecyclerView.setController(controller)
    }

    private fun initViewModel() {

        viewModel.toast.observe(viewLifecycleOwner) { e ->
            e.getContentIfNotHandled()?.let {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.viewState.observe(viewLifecycleOwner) {
            controller.viewState = it
        }

        //step3 observe
        viewModel.navigateToCatDetail.observe(viewLifecycleOwner) {

            //step 4
            e ->
            e.getContentIfNotHandled()?.let {
                findNavController().navigate(
                    R.id.catDetailFragment,
                    bundleOf("image" to it.url, "id" to it.id)
                )
            } //ครอบ e-> เพราะต้องการให้เป็น Event โหลดแค่ครั้งเดียว
        }

        controller.onClickImage.observe(viewLifecycleOwner) { e ->
            e.getContentIfNotHandled()?.let {
                viewModel.onClickImage(it)
            }
        }
    }


}