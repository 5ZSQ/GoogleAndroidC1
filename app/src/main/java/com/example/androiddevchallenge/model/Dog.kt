package com.example.androiddevchallenge.model

import android.os.Parcel
import android.os.Parcelable
import com.example.androiddevchallenge.R

data class Dog(
    val id: Long,
    val name: String?,
    val birthday: String?,
    val size: String?,
    val imgResId: Int,
    var desc: String?
) : Parcelable {
    
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(birthday)
        parcel.writeString(size)
        parcel.writeInt(imgResId)
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Dog> {
        override fun createFromParcel(parcel: Parcel): Dog {
            return Dog(parcel)
        }

        override fun newArray(size: Int): Array<Dog?> {
            return arrayOfNulls(size)
        }
    }
}

val dogs = listOf(

    Dog(
        id = 10000,
        name = "Apple",
        birthday = "01/11/2017",
        size = "34",
        imgResId = R.drawable.dog_1,
        desc = "My name is Apple . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10001,
        name = "Pan",
        birthday = "01/11/2017",
        size = "25",
        imgResId = R.drawable.dog_1,
        desc = "My name is Pan . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10002,
        name = "Bear",
        birthday = "01/11/2017",
        size = "11",
        imgResId = R.drawable.dog_2,
        desc = "My name is Bear . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10003,
        name = "BiLi",
        birthday = "01/11/2017",
        size = "22",
        imgResId = R.drawable.dog_2,
        desc = "My name is BiLi . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10004,
        name = "Bear",
        birthday = "01/11/2017",
        size = "11",
        imgResId = R.drawable.dog_1,
        desc = "My name is Bear . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10005,
        name = "BiLi",
        birthday = "01/11/2017",
        size = "22",
        imgResId = R.drawable.dog_2,
        desc = "My name is BiLi . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10006,
        name = "Bear",
        birthday = "01/11/2017",
        size = "11",
        imgResId = R.drawable.dog_1,
        desc = "My name is Bear . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10007,
        name = "BiLi",
        birthday = "01/11/2017",
        size = "22",
        imgResId = R.drawable.dog_2,
        desc = "My name is BiLi . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    )

)