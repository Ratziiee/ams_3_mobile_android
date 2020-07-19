package com.elevenx.ams_mobile.API_STORE;

import com.android.volley.VolleyError;

/**
 * Created by cspl-5a on 16/3/18.
 */

public interface CallBack_Post {

    void Onresponse(String response, int uniqueId);
    void Onerror(VolleyError error, int uniqueId);
}
