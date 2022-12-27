package axons.forfarm.catproject.presentation.cat_breeds_list

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.MutableLiveData
import axons.forfarm.catproject.databinding.FragmentCatBreedsBinding
import axons.forfarm.catproject.presentation.cat_breeds_list.controller.CatBreedsListEpoxyController
import axons.forfarm.catproject.presentation.cat_fact.CatFactViewModel
import axons.forfarm.catproject.presentation.cat_image_list.CatImageListFragment
import axons.forfarm.catproject.utils.asLiveData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CatBreedsListFragment : Fragment(){
    companion object {
        fun newInstance() = CatBreedsListFragment()
    }
    val viewModel: CatBreedsListViewModel by viewModels()
    lateinit var binding: FragmentCatBreedsBinding

    val controller = CatBreedsListEpoxyController() //ประกาศตัวแปรเพื่อรับค่าจาก epoxy controller
    private var numberOfBreed :Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatBreedsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getInt("number_of_breed")?.let {
            numberOfBreed = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initControl()

        initViewModel()

        viewModel.init(numberOfBreed)
    }

    private fun initControl() {
        //พอเข้า initControl แล้ว จะเข้าไปที่ CatBreedsListEpoxyController
        // แล้วจะ buildModels ไปพร้อมกัน
        binding.epoxyRecyclerView.setControllerAndBuildModels(controller)

        //controller.viewState =
    }

    private fun initViewModel() {
        //พอมี LiveData ก็ต้องมีการ Observe ค่าที่ Fragment
        //เป็นการ Assign ค่าให้ viewState ใน Controller อีกรอบ ผ่าน LiveData จาก ViewModel
        viewModel.textCatBreedsEpoxy.observe(viewLifecycleOwner){
            //controller.viewState = it //เอาข้อมูลที่ได้จาก viewModel มาใส่ใน viewState ของ CatBreedsListEpoxyController
        }
        
        viewModel.viewState.observe(viewLifecycleOwner){
            controller.viewState = it
        }

    }



}













