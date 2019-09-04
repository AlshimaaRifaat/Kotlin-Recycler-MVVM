package com.example.kotlinrecyclertask


import com.google.gson.annotations.SerializedName
//import android.support.annotation.Keep
import androidx.annotation.Keep

@Keep
data class DataModel(
    @SerializedName("AltAttribute") var altAttribute: Any,
    @SerializedName("Category_Id") var categoryId: Int,
    @SerializedName("Description") var description: String,
    @SerializedName("IncludeInTopMenu") var includeInTopMenu: Boolean,
    @SerializedName("MimeType") var mimeType: String,
    @SerializedName("Name") var name: String,
    @SerializedName("PictureBinary") var pictureBinary: Any,
    @SerializedName("PictureId") var pictureId: Int,
    @SerializedName("PictureUrl") var pictureUrl: String,
    @SerializedName("ShowOnHomePage") var showOnHomePage: Boolean
)