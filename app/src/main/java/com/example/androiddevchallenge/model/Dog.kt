/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
        birthday = "21/01/2021",
        size = "34",
        imgResId = R.drawable.dog_1,
        desc = "My name is Apple . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10001,
        name = "Momo",
        birthday = "12/09/2020",
        size = "25",
        imgResId = R.drawable.dog_2,
        desc = "My name is Momo . I am a Grey Female Dachshund Hound Cross (Spayed) and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10002,
        name = "Molly",
        birthday = "11/06/2020",
        size = "11",
        imgResId = R.drawable.dog_3,
        desc = "My name is Molly . I am a Black & Tan Female Rottweiler Cross and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10003,
        name = "Lulu",
        birthday = "20/07/2020",
        size = "22",
        imgResId = R.drawable.dog_4,
        desc = "My name is Lulu . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10004,
        name = "Sa Sa",
        birthday = "20/06/2020",
        size = "11",
        imgResId = R.drawable.dog_5,
        desc = "My name is Sa Sa . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10005,
        name = "Ah Bo",
        birthday = "18/03/2020",
        size = "22",
        imgResId = R.drawable.dog_6,
        desc = "My name is Ah Bo . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
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
    ),
    Dog(
        id = 10008,
        name = "BiLi",
        birthday = "01/11/2017",
        size = "22",
        imgResId = R.drawable.dog_3,
        desc = "My name is BiLi . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10009,
        name = "BiLi",
        birthday = "01/11/2017",
        size = "22",
        imgResId = R.drawable.dog_4,
        desc = "My name is BiLi . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10010,
        name = "BiLi",
        birthday = "01/11/2017",
        size = "22",
        imgResId = R.drawable.dog_5,
        desc = "My name is BiLi . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    ),
    Dog(
        id = 10011,
        name = "BiLi",
        birthday = "01/11/2017",
        size = "22",
        imgResId = R.drawable.dog_6,
        desc = "My name is BiLi . I am a Tan & White Female Mongrel and I was rescued by Inspectors. I am currently living in Hong Kong Centre, please come to see me and give me a home."
    )
)
