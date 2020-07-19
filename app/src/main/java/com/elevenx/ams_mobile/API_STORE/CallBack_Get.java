package com.elevenx.ams_mobile.API_STORE;

import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by cspl-5a on 15/3/18.
 */

public interface CallBack_Get {

//    void response_array(JSONArray response, int UniqueId);
//    void error_array(VolleyError error, int UniqueId);

    void response_object(JSONObject obj, int UniqueId);
    void error_object(VolleyError error, int UniqueId);
}
