package com.elevenx.ams_mobile.Utils;

import android.content.Context;
import android.content.Intent;



public class Utils {

    public static Intent Intent(Context context,Class NextActivity)
    {
        Intent i = new Intent(context, NextActivity);

        return i;
    }
}
