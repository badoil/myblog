package com.myblog.blog.common

class ResponseMessage {

    companion object {
        //200
        val SUCCESS:String = "Success"

        //400
        val VALIDATION_FAILED = "Validation Failed"
        val DUPLICATE_EMAIL = "Duplicate Email"
        val DUPLICATE_NICKNAME = "Duplicate Nickname"
        val DUPLICATE_TEL_NUMBER = "Duplicate tel number"
        val NOT_EXISTED_USER = "This user does not exist"
        val NOT_EXISTED_BOARD = "This board does not exist"

        //401
        val SIGN_IN_FAIL = "Login information mismatch"
        val AUTHORIZATION_FAIL = "Authorization Failed"

        //403
        val NO_PERMISSION = "Do not have permission"

        //500
        val DATABASE_ERROR = "Database Error"
    }
}