package com.woonyum.mysololife.utils

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FBRef {
    companion object {
        val database = Firebase.database

        val contents_all_ref = database.getReference("contents")
        val contents_cook_ref = database.getReference("cookContents")
        val bookmark_ref = database.getReference("bookmarks")
    }
}