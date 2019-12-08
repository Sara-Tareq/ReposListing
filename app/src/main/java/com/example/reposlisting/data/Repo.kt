package com.example.reposlisting.data

import android.os.Parcel
import android.os.Parcelable
import com.squareup.moshi.Json

class Repo : Parcelable {
    var id: Int = 0

    var name: String? = null

    @field:Json(name = "stargazers_count")
    var starsCount: Int = 0

    var description: String? = null

    var isBookmarked: Boolean = false



    constructor()

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Repo> = object : Parcelable.Creator<Repo> {
            override fun createFromParcel(source: Parcel): Repo = Repo(source)
            override fun newArray(size: Int): Array<Repo?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel): this(
    ){
        this.id = source.readInt();
        this.name = source.readString();
        this.starsCount = source.readInt();
        this.description = source.readString();
        this.isBookmarked = 1 == source.readInt();
    }


    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(id)
        writeString(name)
        writeInt(starsCount)
        writeString(description)
        writeInt((if (isBookmarked) 1 else 0))
    }
}