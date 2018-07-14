/*
 * Copyright (c) 2018. All Code CopyRights reserved For Zeinab Mohamed Abdelmawla
 *
 */

package com.org.zm.shutterstockdemo.model.images.dto


import com.google.gson.annotations.SerializedName
import com.org.zm.shutterstockdemo.model.base.BaseResponse

data class SearchImagesResponse(@SerializedName("spellcheck_info")
                                val spellcheckInfo: SpellcheckInfo,
                                @SerializedName("per_page")
                                val perPage: Int = 0,
                                @SerializedName("data")
                                val data: List<DataItem>?,
                                @SerializedName("total_count")
                                val totalCount: Int = 0,
                                @SerializedName("page")
                                val page: Int = 0,
                                @SerializedName("search_id")
                                val searchId: String = ""):BaseResponse()
data class DataItem(@SerializedName("assets")
                    val assets: Assets,
                    @SerializedName("contributor")
                    val contributor: Contributor,
                    @SerializedName("media_type")
                    val mediaType: String = "",
                    @SerializedName("aspect")
                    val aspect: Double = 0.0,
                    @SerializedName("description")
                    val description: String = "",
                    @SerializedName("id")
                    val id: String = "",
                    @SerializedName("image_type")
                    val imageType: String = "")


data class LargeThumb(@SerializedName("width")
                      val width: Int = 0,
                      @SerializedName("url")
                      val url: String = "",
                      @SerializedName("height")
                      val height: Int = 0)


data class Assets(@SerializedName("preview")
                  val preview: Preview,
                  @SerializedName("small_thumb")
                  val smallThumb: SmallThumb,
                  @SerializedName("large_thumb")
                  val largeThumb: LargeThumb,
                  @SerializedName("huge_thumb")
                  val hugeThumb: HugeThumb)


data class Preview(@SerializedName("width")
                   val width: Int = 0,
                   @SerializedName("url")
                   val url: String = "",
                   @SerializedName("height")
                   val height: Int = 0)


data class Contributor(@SerializedName("id")
                       val id: String = "")


data class SpellcheckInfo(@SerializedName("spellchecked_query")
                          val spellcheckedQuery: String,
                          @SerializedName("orig_query")
                          val origQuery: String ,
                          @SerializedName("orig_results_count")
                          val origResultsCount: Int = 0,
                          @SerializedName("spellchecked_results_count")
                          val spellcheckedResultsCount: Int = 0)


data class SmallThumb(@SerializedName("width")
                      val width: Int = 0,
                      @SerializedName("url")
                      val url: String = "",
                      @SerializedName("height")
                      val height: Int = 0)


data class HugeThumb(@SerializedName("width")
                     val width: Int = 0,
                     @SerializedName("url")
                     val url: String = "",
                     @SerializedName("height")
                     val height: Int = 0)


