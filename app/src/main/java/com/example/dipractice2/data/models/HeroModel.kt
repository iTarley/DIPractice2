package com.example.dipractice2.data.models

import com.squareup.moshi.Json

data class HeroModel(
    val status: Int,
    val count: Int,
    val heroes: List<Heroes>
) {
    data class Heroes(
        @Json(name = "localized_name")
        val localizedName: String?,
        @Json(name = "url_full_portrait")
        val urlFullPortrait: String?,
        val name: String?,
        @Json(name = "url_small_portrait")
        val urlSmallPortrait: String?,
        @Json(name = "url_large_portrait")
        val urlLargePortrait: String?,
        @Json(name = "url_vertical_portrait")
        val urlVerticalPortrait: String?,
        val id: Int?
    )
}