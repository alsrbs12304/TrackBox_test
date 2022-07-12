package com.example.trackbox.view.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.annotation.UiThread
import com.example.trackbox.R
import com.example.trackbox.databinding.ActivitySplashBinding
import com.example.trackbox.view.ui.base.BaseActivity
import com.example.trackbox.view.ui.main.MainActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply {
            splashAnimation()
        }
    }

    @UiThread
    private fun splashAnimation(){
        val imageAnim = AnimationUtils.loadAnimation(this, R.anim.anim_splash_logo)
        binding.splashLogo.startAnimation(imageAnim)

        imageAnim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {}
            override fun onAnimationRepeat(p0: Animation?) {}
            override fun onAnimationEnd(p0: Animation?) {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        })
    }
}