package axons.forfarm.catproject.presentation.cat_breeds_list.controller.model

import axons.forfarm.catproject.R
import axons.forfarm.catproject.databinding.ListItemCatBreedsBinding
import axons.forfarm.catproject.domain.model.Data
import axons.forfarm.catproject.domain.model.GetCatBreedsResponse
import axons.forfarm.catproject.domain.model.GetCatBreedsResponseItem
import axons.forfarm.catproject.utils.ViewBindingKotlinModel

data class CatBreedsEpoxyModel(
    private val data: Data ,
    private val callbackOnCLick: (Data) -> Unit
    ):
ViewBindingKotlinModel<ListItemCatBreedsBinding> (R.layout.list_item_cat_breeds) {
    override fun ListItemCatBreedsBinding.bind() {
        //แปะข้อความเข้าไปใน TextView
        catBreedsText.text = data.breed
        //catBreedsText คือ id ของ TextView ในไฟล์ layout xml ที่เราสร้างไว้
        rootView.setOnClickListener {
            callbackOnCLick.invoke(data)
        }
    }

}
    //ListItemCatBreedsBinding คือ ชื่อไฟล์ xml ที่เราสร้างไว้
    // ที่จะต้องเป็นตั้งชื่อ xml เป็น list_item_......... เท่านั้น
    // ถึงจะสามารถใช้ ViewBindingKotlinModel กับ EpoxyRecyclerView ได้
























//data class CatBreedsEpoxyModel (private val catbreedsText: String) :
//    ViewBindingKotlinModel<ListItemCatBreedsBinding>(R.layout.list_item_cat_breeds) {
//    override fun ListItemCatBreedsBinding.bind() {
//        catBreedsText.text = catbreedsText
//    }
//}
