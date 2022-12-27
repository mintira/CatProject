package axons.forfarm.catproject.domain.model

data class GetCatBreedsResponseItem(
    val current_page: Int, // 1
    val `data`: List<Data>,
    val first_page_url: String, // https://catfact.ninja/breeds?page=1
    val from: Int, // 1
    val last_page: Int, // 4
    val last_page_url: String, // https://catfact.ninja/breeds?page=4
    val links: List<Link>,
    val next_page_url: String, // https://catfact.ninja/breeds?page=2
    val path: String, // https://catfact.ninja/breeds
    val per_page: Int, // 25
    val prev_page_url: Any, // null
    val to: Int, // 25
    val total: Int // 98
) {
    data class Data(
        val breed: String, // Abyssinian
        val coat: String, // Short
        val country: String, // Ethiopia
        val origin: String, // Natural/Standard
        val pattern: String // Ticked
    )

    data class Link(
        val active: Boolean, // false
        val label: String, // Previous
        val url: String // https://catfact.ninja/breeds?page=1
    )
}