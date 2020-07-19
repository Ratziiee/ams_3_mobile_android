package com.elevenx.ams_mobile.API_STORE;




public interface API_Store {


    String BASE_URL = "https://ams-v3.herokuapp.com/";

    String GET_TEST = BASE_URL;
    String GET_DETAILS_FROM_MOBILE = BASE_URL+"get_userFromMobileNo?mobile=";
    String GET_LOGIN = BASE_URL+"get_Login?mobile=";

    String POST_LOGIN_DETAILS= BASE_URL+"post_loginDataToServer?mobile=";
    String POST_UPDATE_PASSWORD = BASE_URL+"post_updatePassword?mobile=";
    //------------------------------>  GET APIS  <----------------------------------------------------------

    /*String GET_EDIT_PROFILE=AppConstant.PUBLIC_IP+"/api/m_getprofile?email=";
      String GET_POINT_INFO_LIST=AppConstant.PUBLIC_IP+"/api/m_getPoly";
      String GET_POINT_INFO_DETAIL=AppConstant.PUBLIC_IP+"/api/m_getPolyPoints";
    String GET_POINT_DETAIL=AppConstant.PUBLIC_IP+"/api/m_getPolyPointsById";




    //---------------------------->  POST APIS  <--------------------------------------------------------
    String POST_SIGNUP=AppConstant.PUBLIC_IP+"/api/m_signup";
    String POST_SIGNIN=AppConstant.PUBLIC_IP+"/api/m_signin";
    //String POST_SIGNIN=AppConstant.PUBLIC_IP+"/m_signin";
    String POST_EDIT_PROFILE=AppConstant.PUBLIC_IP+"/api/m_updateprofile";
    String POST_ADD_POINT_INFO=AppConstant.PUBLIC_IP+"/api/m_submitPoint";
    String POST_UPDATE_POINT_DETAIL=AppConstant.PUBLIC_IP+"/api/m_updatePolyPointsById";
    String POST_DELETE_POINT=AppConstant.PUBLIC_IP+"/api/m_polyDelete";
    String POST_RENAME_POLYGON_NAME=AppConstant.PUBLIC_IP+"/api/m_polyRename";
*/

    //------------------------------>  GET APIS  <----------------------------------------------------------

   /* String GET_EDIT_PROFILE=AppConstant.IP+"/api/m_getprofile?email=";
    String GET_POINT_INFO_LIST=AppConstant.IP+"/api/m_getPoly";
    String GET_POINT_INFO_DETAIL=AppConstant.IP+"/api/m_getPolyPoints";
    String GET_POINT_DETAIL=AppConstant.IP+"/api/m_getPolyPointsById";
    String GET_DELETE_POINT=AppConstant.IP+"";

    //---------------------------->  POST APIS  <--------------------------------------------------------
    String POST_SIGNUP=AppConstant.IP+"/api/m_signup";
    String POST_SIGNIN=AppConstant.IP+"/api/m_signin";
    String POST_EDIT_PROFILE=AppConstant.IP+"/api/m_updateprofile";
    String POST_ADD_POINT_INFO=AppConstant.IP+"/api/m_submitPoint";
    String POST_UPDATE_POINT_DETAIL=AppConstant.IP+"/api/m_updatePolyPointsById";*/




    //---------------------------->  POST APIS  <--------------------------------------------------------



    //------------------>>Elevation api<<---------------------------





}
