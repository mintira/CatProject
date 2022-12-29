package axons.forfarm.catproject.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GetCatBreedsResponse(
    val current_page: Int,
    val data: List<Data>,
    val first_page_url: String,
    val from: Int,
    val last_page: Int,
    val last_page_url: String,
    val links: List<Link>,
    val next_page_url: String,
    val path: String,
    val per_page: String,
    val prev_page_url: String,
    val to: Int,
    val total: Int
): Parcelable

@Parcelize
data class Link(
    val active: Boolean,
    val label: String,
    val url: String
): Parcelable

@Parcelize
data class Data(
    val breed: String,
    val coat: String,
    val country: String,
    val origin: String,
    val pattern: String
): Parcelable

