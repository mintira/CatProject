package axons.forfarm.catproject.domain.model

data class GetCatFactResponse(
    val fact: String, // Some Siamese cats appear cross-eyed because the nerves from the left side of the brain go to mostly the right eye and the nerves from the right side of the brain go mostly to the left eye. This causes some double vision, which the cat tries to correct by “crossing” its eyes.
    val length: Int // 275
)