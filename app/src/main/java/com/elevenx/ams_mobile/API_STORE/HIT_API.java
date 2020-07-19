package com.elevenx.ams_mobile.API_STORE;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cspl-5a on 15/3/18.
 */

public class HIT_API
{

     private RequestQueue requestQueue;
     private CallBack_Get getAPIcallBack;
     private CallBack_Post postAPIcallBack;

     private static String TAG="HIT_API";


//    public void getDataFromServer_ARRAY_REQUEST_activity(final Context context, String API, Activity activity, final int UniqueId)
//    {
//        requestQueue=Volley.newRequestQueue(context);
//        getAPIcallBack=(CallBack_Get)activity;
//
//        JsonArrayRequest request=new JsonArrayRequest(API, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response)
//            {
//                Log.d(TAG, "onResponse: "+response);
//                getAPIcallBack.response(response,UniqueId);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d(TAG, "onErrorResponse: "+error);
//                getAPIcallBack.error(error,UniqueId);
//
//                NetworkResponse response = error.networkResponse;
//                if (error instanceof ServerError && response != null) {
//                    try {
//                        String res = new String(response.data,
//                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
//                        // Now you can use any deserializer to make sense of data
//                        JSONObject obj = new JSONObject(res);
//                    } catch (UnsupportedEncodingException | JSONException e1) {
//                        // Couldn't properly decode data to string
//                        e1.printStackTrace();
//                    }
//                }
//
//
//
//
//
//                if (error instanceof TimeoutError)
//                {
//                    Log.d("VOLLEY","error  TimeoutError=>"+error.toString());
//
//                }
//                else if (error instanceof ServerError) {
//                    Log.d("VOLLEY","error ServerError =>"+error.toString());
//                }
//                else if (error instanceof AuthFailureError) {
//                    Log.d("VOLLEY","error AuthFailureError =>"+error.toString());
//                }
//                else if (error instanceof NetworkError) {
//                    Log.d("VOLLEY","error  NetworkError=>"+error.toString());
//                }
//                else if (error instanceof ParseError) {
//                    Log.d("VOLLEY","error ParseError =>"+error.toString());
//                }
//                else
//                {
//                    Log.d("VOLLEY","error nothingg =>"+error.toString());
//                }
//            }
//        });
//
//        int socketTimeout = 100000;
//        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
//        request.setRetryPolicy(policy);
//
//
//        requestQueue.add(request);
//
//    }

//    public void getDataFromServer_fragment(CallBack_Get interface_get, final Context context, String API, final int UniqueId)
//    {
//        requestQueue=Volley.newRequestQueue(context);
//        getAPIcallBack=interface_get;
//
//        JsonArrayRequest request=new JsonArrayRequest(API, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//                getAPIcallBack.response(response,UniqueId);
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                getAPIcallBack.error(error,UniqueId);
//
//
//                NetworkResponse response = error.networkResponse;
//                if (error instanceof ServerError && response != null) {
//                    try {
//                        String res = new String(response.data,
//                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
//                        // Now you can use any deserializer to make sense of data
//                        Log.d(TAG, "onErrorResponse: string "+res);
//                        JSONObject obj = new JSONObject(res);
//                    } catch (UnsupportedEncodingException | JSONException e1) {
//                        // Couldn't properly decode data to string
//                        e1.printStackTrace();
//                    }
//                }
//
//
//                if (error instanceof TimeoutError)
//                {
//                    Log.d("VOLLEY","error  TimeoutError=>"+error.toString());
//
//                }
//                else if (error instanceof ServerError) {
//                    Log.d("VOLLEY","error ServerError =>"+error.toString());
//                }
//                else if (error instanceof AuthFailureError) {
//                    Log.d("VOLLEY","error AuthFailureError =>"+error.toString());
//                }
//                else if (error instanceof NetworkError) {
//                    Log.d("VOLLEY","error  NetworkError=>"+error.toString());
//                }
//                else if (error instanceof ParseError) {
//                    Log.d("VOLLEY","error ParseError =>"+error.toString());
//                }
//                else
//                {
//                    Log.d("VOLLEY","error nothingg =>"+error.toString());
//                }
//            }
//        });
//
//        int socketTimeout = 100000;
//        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
//                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
//        request.setRetryPolicy(policy);
//
//
//        requestQueue.add(request);
//
//    }

    public void postDataToSERVER_activity(Context context, Activity activity, String API, final String key, final String body, final int UniqueId)
    {

        requestQueue=Volley.newRequestQueue(context);
        postAPIcallBack=(CallBack_Post)activity;

        StringRequest request=new StringRequest(Request.Method.POST, API, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("VOLLEY", "onResponse: "+response);
                postAPIcallBack.Onresponse(response,UniqueId);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                postAPIcallBack.Onerror(error,UniqueId);


                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        // Now you can use any deserializer to make sense of data
                        JSONObject obj = new JSONObject();
                    } catch (UnsupportedEncodingException e1 ) {
                        // Couldn't properly decode data to string
                        e1.printStackTrace();
                    }
                }


                if (error instanceof TimeoutError)
                {
                    Log.d("VOLLEY","error  TimeoutError=>"+error.toString());

                }
                else if (error instanceof ServerError) {
                    Log.d("VOLLEY","error ServerError =>"+error.toString());
                }
                else if (error instanceof AuthFailureError) {
                    Log.d("VOLLEY","error AuthFailureError =>"+error.toString());
                }
                else if (error instanceof NetworkError) {
                    Log.d("VOLLEY","error  NetworkError=>"+error.toString());
                }
                else if (error instanceof ParseError) {
                    Log.d("VOLLEY","error ParseError =>"+error.toString());
                }
                else
                {
                    Log.d("VOLLEY","error nothingg =>"+error.toString());
                }
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> postData = new HashMap<>();
                postData.put(key,body);
                return postData;
            }
        };

        int socketTimeout = 100000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);

        requestQueue.add(request);


    }

    public void postDataToSERVER_fragment(Context context, CallBack_Post interface_post, String API, final String key, final String body, final int UniqueId)
    {

        requestQueue=Volley.newRequestQueue(context);
        postAPIcallBack=interface_post;

        StringRequest request=new StringRequest(Request.Method.POST, API, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("VOLLEY", "onResponse: "+response);
                postAPIcallBack.Onresponse(response,UniqueId);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                postAPIcallBack.Onerror(error,UniqueId);


                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        // Now you can use any deserializer to make sense of data
                        JSONObject obj = new JSONObject(res);
                    } catch (UnsupportedEncodingException | JSONException e1) {
                        // Couldn't properly decode data to string
                        e1.printStackTrace();
                    }
                }


                if (error instanceof TimeoutError)
                {
                    Log.d("VOLLEY","error  TimeoutError=>"+error.toString());

                }
                else if (error instanceof ServerError) {
                    Log.d("VOLLEY","error ServerError =>"+error.toString());
                }
                else if (error instanceof AuthFailureError) {
                    Log.d("VOLLEY","error AuthFailureError =>"+error.toString());
                }
                else if (error instanceof NetworkError) {
                    Log.d("VOLLEY","error  NetworkError=>"+error.toString());
                }
                else if (error instanceof ParseError) {
                    Log.d("VOLLEY","error ParseError =>"+error.toString());
                }
                else
                {
                    Log.d("VOLLEY","error nothingg =>"+error.toString());
                }
            }
        })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> postData = new HashMap<>();
                postData.put(key,body);
                return postData;
            }
        };

        int socketTimeout = 100000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);

        requestQueue.add(request);
    }

    public void GET_REQUEST_JSONOBJECT(final Context context, String API, Activity activity, final int UniqueId,int REQUEST_METHOD)
    {

        requestQueue=Volley.newRequestQueue(context);
        getAPIcallBack=(CallBack_Get)activity;
        JsonObjectRequest request=new JsonObjectRequest(REQUEST_METHOD,API, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                getAPIcallBack.response_object(response,UniqueId);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                getAPIcallBack.error_object(error,UniqueId);

                NetworkResponse response = error.networkResponse;
                if (error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data,
                                HttpHeaderParser.parseCharset(response.headers, "utf-8"));
                        // Now you can use any deserializer to make sense of data
                        JSONObject obj = new JSONObject(res);
                    } catch (UnsupportedEncodingException | JSONException e1) {
                        // Couldn't properly decode data to string
                        e1.printStackTrace();
                    }
                }





                if (error instanceof TimeoutError)
                {
                    Log.d("VOLLEY","error  TimeoutError=>"+error.toString());

                }
                else if (error instanceof ServerError) {
                    Log.d("VOLLEY","error ServerError =>"+error.toString());
                }
                else if (error instanceof AuthFailureError) {
                    Log.d("VOLLEY","error AuthFailureError =>"+error.toString());
                }
                else if (error instanceof NetworkError) {
                    Log.d("VOLLEY","error  NetworkError=>"+error.toString());
                }
                else if (error instanceof ParseError) {
                    Log.d("VOLLEY","error ParseError =>"+error.toString());
                }
                else
                {
                    Log.d("VOLLEY","error nothingg =>"+error.toString());
                }
            }
        });

        int socketTimeout = 100000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTimeout, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        request.setRetryPolicy(policy);


        requestQueue.add(request);
    }


}
