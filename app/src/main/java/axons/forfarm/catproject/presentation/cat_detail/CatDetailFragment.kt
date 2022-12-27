package axons.forfarm.catproject.presentation.cat_detail

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import axons.forfarm.catproject.R
import axons.forfarm.catproject.databinding.FragmentCatDetailBinding
import axons.forfarm.catproject.databinding.FragmentCatImageListBinding
import axons.forfarm.catproject.presentation.cat_image_list.CatImageListFragment
import axons.forfarm.catproject.presentation.cat_image_list.CatImageListViewModel
import axons.forfarm.catproject.presentation.cat_image_list.controller.CatImageListEpoxyController
import axons.forfarm.catproject.utils.loadUrlCacheCenterCrop
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CatDetailFragment : Fragment() {

    companion object {
        fun newInstance() = CatDetailFragment()
    }
    val viewModel: CatDetailViewModel by viewModels()
    lateinit var binding: FragmentCatDetailBinding
    lateinit var catId: String
    lateinit var catImage: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //return inflater.inflate(R.layout.fragment_cat_image_list, container, false)

        binding = FragmentCatDetailBinding.inflate(inflater, container, false)
        return binding.root

    }
    //รับค่ามาจากหน้า list
    override fun onAttach(context: Context) {
        super.onAttach(context)

        arguments?.getString("image")?.let {
            catImage = it
        }

        arguments?.getString("id")?.let {
            catId = it
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.init(catImage, catId) //เรียกตัวแปรที่ประกาศไว้ส่งเข้าไปในฟังก์ชั้น init

        viewModel.image.observe(viewLifecycleOwner) {
            //ผูก image ที่ถูกส่งมากับไฟล์ xml
            binding.image.loadUrlCacheCenterCrop(requireContext(), it) //แปะรูปจากการโหลด url
        }

        viewModel.textID.observe(viewLifecycleOwner) {
            binding.textID.text = it // it คือ observe อะไรมาได้ ก็จะโชว์อันนั้นออกมาเลย
        }



        //การผูกค่าแบบยังไม่ผ่าน ViewModel
//        binding.image.loadUrlCacheCenterCrop(requireContext(), catImage) //แปะรูปจากการโหลด url
//        binding.textID.text = catId
    }


    //สร้างตัวแปรสำหรับทำการ data binding
//    private lateinit var binding: FragmentCatDetailBinding
//    // สร้างตัวแปรไว้เก็บหมายเลข id ที่ส่งมาจากหน้า cat image list
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)

        //Data Binding View
        //binding = FragmentCatDetailBinding.inflate(layoutInflater)
        //setContentView(binding.root)

        //รับค่า id จาก  Cat Image List
//        val bundle: Bundle ? = intent.extras
//        if(bundle != null) {
//            id = bundle.getInt("id")
//            println("Cat ID: $id")
//        }
    //}
}