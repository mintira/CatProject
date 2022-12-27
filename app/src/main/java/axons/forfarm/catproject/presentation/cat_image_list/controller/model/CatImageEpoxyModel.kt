package axons.forfarm.catproject.presentation.cat_image_list.controller.model

import axons.forfarm.catproject.R
import axons.forfarm.catproject.databinding.ListItemCatImageBinding
import axons.forfarm.catproject.domain.model.GetCatImageResponseItem
import axons.forfarm.catproject.utils.ViewBindingKotlinModel
import axons.forfarm.catproject.utils.loadUrlCacheCenterCrop

class CatImageEpoxyModel(
    private val data: GetCatImageResponseItem,
    private val callbackOnCLick: (GetCatImageResponseItem) -> Unit
) :
    ViewBindingKotlinModel<ListItemCatImageBinding>(R.layout.list_item_cat_image) {

    override fun ListItemCatImageBinding.bind() {
        //เรียกไม่เหมือนกับหน้า Fragment ไม่ใช่ fragment เลยต้อง .context เพื่อให้รับค่าเป็น context จาก loadUrlCacheCenterCrop
        image.loadUrlCacheCenterCrop(image.context, data.url)
        textID.text = data.id

        rootView.setOnClickListener {
            callbackOnCLick.invoke(data)
        }


    }

}