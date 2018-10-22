package gatech.a2340.donationtracker.models

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class Item(val timestamp: Date, val Location: Location, val description: String, val value: Double,
           val category: ItemType) : Parcelable {

    constructor(): this( Date(),Location(),"",0.0,ItemType.Other);

    constructor(parcel: Parcel) : this(
            parcel.readSerializable() as Date,
            parcel.readSerializable() as Location,
            parcel.readString(),
            parcel.readDouble(),
            parcel.readSerializable() as ItemType
    )

    override fun writeToParcel(p: Parcel, p1: Int) {
        p.writeSerializable(timestamp)
        p.writeString(description)
        p.writeString(description)
        p.writeDouble(value)
        p.writeSerializable(category)
    }

    override fun describeContents(): Int {
        return 0;
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }

}


//class user(val username: String, val password: String, val userType: UserType) : Parcelable {
//
//    constructor(): this("","",UserType.ADMIN);
//    constructor(parcel: Parcel) : this(
//            parcel.readString(),
//            parcel.readString(),
//            parcel.readSerializable() as UserType
//    )
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(username)
//        parcel.writeString(password)
//        parcel.writeSerializable(userType)
//    }
//

//}