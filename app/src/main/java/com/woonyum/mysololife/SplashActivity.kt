package com.woonyum.mysololife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.woonyum.mysololife.auth.IntroActivity
import com.woonyum.mysololife.utils.FBAuth

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        if (FBAuth.getUid() == null) {
            Handler().postDelayed({
                //3초 뒤 실행
                startActivity(Intent(this, IntroActivity::class.java))
                finish()
            }, 3000)
        } else {
            Handler().postDelayed({
                //3초 뒤 실행
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }, 3000)
        }

    }
}