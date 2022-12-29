package axons.forfarm.catproject.presentation.cat_breeds_list.controller

import androidx.lifecycle.MutableLiveData
import axons.forfarm.catproject.domain.model.Data
import axons.forfarm.catproject.domain.model.GetCatBreedsResponse
import axons.forfarm.catproject.presentation.cat_breeds_list.controller.model.CatBreedsEpoxyModel
import axons.forfarm.catproject.utils.Event
import axons.forfarm.catproject.utils.asLiveData
import com.airbnb.epoxy.EpoxyController

class CatBreedsListEpoxyController : EpoxyController() {
    private val _onClickItem = MutableLiveData<Event<Data>>()
    val onClickItem = _onClickItem.asLiveData()

    var viewState: GetCatBreedsResponse? = null
        set(value) {
            field = value
            requestModelBuild()
        }

    override fun buildModels() {
        //แปะ Epoxymodel
        //CatBreedsEpoxyModel(viewState ?: return).id(1).addTo(this)

        //ดักไว้ ถ้าเป็นค่า null ให้ return ออกไป ไม่ต้องทำอะไร
        val viewState = viewState ?: return

        try {
            viewState.data.forEach { data ->
                CatBreedsEpoxyModel(data){
                    _onClickItem.value = Event(it)
                }.id("${data.breed}").addTo(this)
                //id ต้องเป็นค่า unique ไม่ซ้ำกัน
                //เป็น Keyword ของ Data ที่เราจะใช้ในการแสดงผล
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}









//class CatBreedsListEpoxyController : EpoxyController() { //ใช้แปะ EpoxyModel ลงไปใน RecyclerView
//
//    //รับค่าจาก viewModel มาเก็บไว้ในตัวแปร viewState
//    var viewState: String? = null //เอาข้อมูลที่ได้จาก viewModel มาใส่ใน viewState ของ CatBreedsListEpoxyController
//        //ถ้าถูก set ใหม่ จะเรียก requestModelBuild()
//        set(value) {
//            field = value
//            requestModelBuild() //เมื่อมีการเปลี่ยนแปลงข้อมูล จะทำการ buildModels ใหม่
//        }
//
//    //จะต้องมีฟังก์ชัน buildModels
//    override fun buildModels() { //แปะ model ที่เราสร้างไว้ มีกี่ Model ก็ได้
//    //สร้าง viewState แล้วเอามากำหนดค่าไว้ใน CatBreedsEpoxyModel
//        CatBreedsEpoxyModel(viewState?: "").id("1").addTo(this)
//        // addTo คือแปะเข้าไปในอะไรซักอย่างที่อยู่ใน () ในที่นี้คือ this คือคลาส CatBreedsListEpoxyController
//        // คีย์เวิร์ด This คือ คีย์เวิร์ดที่ใช้ในการอ้างอิงตัวแปรหรือฟังก์ชันของคลาสเอง
//        // viewState?: "" คือ ถ้า viewState เป็น null ให้ใช้ค่าว่างแทน
//    }
//}