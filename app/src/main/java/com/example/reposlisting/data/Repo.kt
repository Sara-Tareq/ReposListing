package com.example.reposlisting.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Entity(tableName = "repositories")
@JsonClass(generateAdapter = true)
class Repo() : Parcelable {
    @PrimaryKey
    @field:Json(name = "id")
    var id: Int = 0

    @field:Json(name = "name")
    var name: String? = null

    @field:Json(name = "stargazers_count")
    var starsCount: Int = 0

    @field:Json(name = "description")
    var description: String? = null

    var isBookmarked: Boolean = false

    fun getStarsCountString(): String {
        return starsCount.toString()
    }

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