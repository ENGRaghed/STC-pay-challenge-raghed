package com.safcsp.android.stcpaychallenge

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
data class dataClassJson(
    val meta: Meta,
    val objects: List<Object>
)
@JsonClass(generateAdapter = true)
data class Meta(
    val limit: Int,
    val offset: Int,
    val total_count: Int
)
@Parcelize
@JsonClass(generateAdapter = true)
data class Object(
//    val caucus: Any,
    val congress_numbers: List<Int> ?= emptyList(),
    val current: Boolean ?= false,
    val description: String ?= "",
//    val district: Any,
    val enddate: String? = "",
    val extra: Extra,
//    val leadership_title: Any,
    val party: String ?= "",
    val person: Person ,
    val phone: String ?= "",
    val role_type: String ?= "",
    val role_type_label: String ?= "",
    val senator_class: String ?= "",
    val senator_class_label: String? = "",
    val senator_rank: String ?= "",
    val senator_rank_label: String ?= "",
    val startdate: String ?= "",
    val state: String ?= "",
    val title: String ?= "",
    val title_long: String ?= "",
    val website: String ?= ""
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class Extra(
    val address: String ? = "",
    val contact_form: String ?="",
//            val end-type: String,
    val fax: String ?= "",
    val how: String ?= "",
    val office: String ?= "",
    val rss_url: String ?= ""
): Parcelable
@Parcelize
@JsonClass(generateAdapter = true)
data class Person(
    val bioguideid: String ?= "",
    val birthday: String ?= "",
    val cspanid: Int ?= 0,
    val firstname: String? = "",
    val gender: String? = "",
    val gender_label: String ?= "",
    val lastname: String ?= "",
    val link: String ?= "",
    val middlename: String ?= "",
    val name: String ?= "",
    val namemod: String ?= "",
    val nickname: String ?= "",
    val osid: String ?= "",
    val pvsid: String ?= "",
    val sortname: String ?= "",
    val twitterid: String ?= "",
    val youtubeid: String ?= ""
): Parcelable