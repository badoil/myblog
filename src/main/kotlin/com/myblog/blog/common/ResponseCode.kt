package com.myblog.blog.common

class ResponseCode {

    companion object {
        //200
        val SUCCESS:String = "SU"

        //400
        val VALIDATION_FAILED = "VF"
        val DUPLICATE_EMAIL = "DE"
        val DUPLICATE_NICKNAME = "DN"
        val DUPLICATE_TEL_NUMBER = "DT"
        val NOT_EXISTED_USER = "NU"
        val NOT_EXISTED_BOARD = "NB"

        //401
        val SIGN_IN_FAIL = "SF"
        val AUTHORIZATION_FAIL = "AF"

        //403
        val NO_PERMISSION = "NP"

        //500
        val DATABASE_ERROR = "DBE"
    }
}