package com.airbnb.lottie.issues

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.issues.databinding.IssueReproActivityBinding
import com.airbnb.lottie.model.KeyPath
import com.airbnb.lottie.value.LottieValueCallback

class IssueReproActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = IssueReproActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val lottieAnimationView: LottieAnimationView = findViewById(R.id.animation_view)
        lottieAnimationView.addLottieOnCompositionLoadedListener { composition ->
            // works
            lottieAnimationView.addValueCallback(
                KeyPath("**", "Stroke 1"),
                LottieProperty.STROKE_COLOR,
                LottieValueCallback(Color.BLUE)
            )
            // doesn't work
            lottieAnimationView.addValueCallback(
                KeyPath("**", "Stroke 1"),
                LottieProperty.COLOR,
                LottieValueCallback(Color.BLUE)
            )
        }

        // Reproduce any issues here.
    }
}
