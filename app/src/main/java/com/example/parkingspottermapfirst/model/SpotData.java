package com.example.parkingspottermapfirst.model;


import android.os.Parcel;
import android.os.Parcelable;

public class SpotData implements Parcelable {
    public int id, max_reserve_time_mins, min_reserve_time_mins;
    public String lat, lng, name, cost_per_minute, reserved_until;
    public boolean is_reserved;

    protected SpotData(Parcel in) {
        id = in.readInt();
        max_reserve_time_mins = in.readInt();
        min_reserve_time_mins = in.readInt();
        lat = in.readString();
        lng = in.readString();
        name = in.readString();
        cost_per_minute = in.readString();
        reserved_until = in.readString();
        is_reserved = in.readByte() != 0;
    }

    public static final Creator<SpotData> CREATOR = new Creator<SpotData>() {
        @Override
        public SpotData createFromParcel(Parcel in) {
            return new SpotData(in);
        }

        @Override
        public SpotData[] newArray(int size) {
            return new SpotData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(max_reserve_time_mins);
        dest.writeInt(min_reserve_time_mins);
        dest.writeString(lat);
        dest.writeString(lng);
        dest.writeString(name);
        dest.writeString(cost_per_minute);
        dest.writeString(reserved_until);
        dest.writeByte((byte) (is_reserved ? 1 : 0));
    }
}
