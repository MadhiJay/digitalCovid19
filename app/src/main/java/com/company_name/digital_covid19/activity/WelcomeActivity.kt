/*
*  WelcomeActivity.kt
*  digitalCovid19
*
*  Created by Erandra Jayasundara.
*  Copyright © 2018 keliya. All rights reserved.
*/

package com.company_name.digital_covid19.activity

import android.animation.*
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.databinding.DataBindingUtil
import android.graphics.Color
import android.os.Bundle
import androidx.core.view.animation.PathInterpolatorCompat
import androidx.appcompat.app.AppCompatActivity
import android.util.TypedValue
import android.view.View
import com.company_name.digital_covid19.R
import com.company_name.digital_covid19.databinding.WelcomeActivityBinding
import com.company_name.digital_covid19.methods.Methods
import com.google.firebase.auth.FirebaseAuth
import io.supernova.uitoolkit.animation.ViewBackgroundProperties


class WelcomeActivity: AppCompatActivity() {

	companion object {
		
		fun newIntent(context: Context): Intent {
			return Intent(context, WelcomeActivity::class.java)
		}
	}
	
	private lateinit var binding: WelcomeActivityBinding
	private lateinit var mAuth: FirebaseAuth
	private lateinit var sharedPreferences: SharedPreferences
	private lateinit var methodObj: Methods
	override fun onCreate(savedInstanceState: Bundle?) {
		methodObj= Methods()
		sharedPreferences=this.getSharedPreferences("digitalCovidPrefs",0)
		super.onCreate(savedInstanceState)
		mAuth = FirebaseAuth.getInstance()
		binding = DataBindingUtil.setContentView(this, R.layout.welcome_activity)
		this.startAnimationOne()
		this.init()
		

	}
	
	private fun init() {
		if (mAuth.currentUser!=null){
			if (methodObj.readSharedPreferences("addSymptom",sharedPreferences)=="null") {
						this.startSymptomActivity()
			} else
				this.startHomeActivity()
		}
		// Configure Register component
		binding.registerButton.setOnClickListener {
			this.onRegisterPressed()
		}

		// Configure Login component
		binding.loginButton.setOnClickListener {
			this.onLoginPressed()
		}

		// Configure g+ component
		binding.gButton.setOnClickListener {
			this.onGPressed()
		}

		// Configure facebook component
		binding.facebookButton.setOnClickListener {
			this.onFacebookPressed()
		}
	}
	
	private fun onRegisterPressed() {
		this.startRegisterActivity()
	}
	
	private fun onLoginPressed() {
	
		this.startSignInActivity()
	}
	
	private fun onGPressed() {
	
	}
	
	private fun onFacebookPressed() {
	
	}
	
	private fun startSignInActivity() {
	
		this.startActivity(SignInActivity.newIntent(this))
		finish()
	}
	private fun startRegisterActivity() {

		this.startActivity(RegisterActivity.newIntent(this))
		finish()
	}
	private fun startHomeActivity() {

		this.startActivity(MapsActivity.newIntent(this))
		finish()
	}
	private fun startSymptomActivity() {
		this.startActivity(SymptomActivity.newIntent(this))
		finish()
	}
	private fun startAnimationOne() {
	
		val animator1 = ObjectAnimator.ofPropertyValuesHolder(binding.registerButton, PropertyValuesHolder.ofKeyframe(View.SCALE_X, Keyframe.ofFloat(0f, 0.3f), Keyframe.ofFloat(0.2f, 1.1f), Keyframe.ofFloat(0.4f, 0.9f), Keyframe.ofFloat(0.6f, 1.03f), Keyframe.ofFloat(0.8f, 0.97f), Keyframe.ofFloat(1f, 1f)), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, Keyframe.ofFloat(0f, 0.3f), Keyframe.ofFloat(0.2f, 1.1f), Keyframe.ofFloat(0.4f, 0.9f), Keyframe.ofFloat(0.6f, 1.03f), Keyframe.ofFloat(0.8f, 0.97f), Keyframe.ofFloat(1f, 1f)))
		animator1.duration = 1000
		animator1.interpolator = PathInterpolatorCompat.create(0.22f, 0.61f, 0.36f, 1f)
		
		val animator2 = ObjectAnimator.ofPropertyValuesHolder(binding.registerButton, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)))
		animator2.duration = 1000
		animator2.interpolator = PathInterpolatorCompat.create(0.22f, 0.61f, 0.36f, 1f)
		
		val animatorSet1 = AnimatorSet()
		animatorSet1.playTogether(animator1, animator2)
		animatorSet1.setTarget(binding.registerButton)
		
		val animator3 = ObjectAnimator.ofPropertyValuesHolder(binding.loginButton, PropertyValuesHolder.ofKeyframe(View.SCALE_X, Keyframe.ofFloat(0f, 0.3f), Keyframe.ofFloat(0.2f, 1.1f), Keyframe.ofFloat(0.4f, 0.9f), Keyframe.ofFloat(0.6f, 1.03f), Keyframe.ofFloat(0.8f, 0.97f), Keyframe.ofFloat(1f, 1f)), PropertyValuesHolder.ofKeyframe(View.SCALE_Y, Keyframe.ofFloat(0f, 0.3f), Keyframe.ofFloat(0.2f, 1.1f), Keyframe.ofFloat(0.4f, 0.9f), Keyframe.ofFloat(0.6f, 1.03f), Keyframe.ofFloat(0.8f, 0.97f), Keyframe.ofFloat(1f, 1f)))
		animator3.duration = 1000
		animator3.interpolator = PathInterpolatorCompat.create(0.22f, 0.61f, 0.36f, 1f)
		
		val animator4 = ObjectAnimator.ofPropertyValuesHolder(binding.loginButton, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)))
		animator4.duration = 1000
		animator4.interpolator = PathInterpolatorCompat.create(0.22f, 0.61f, 0.36f, 1f)
		
		val animatorSet2 = AnimatorSet()
		animatorSet2.playTogether(animator3, animator4)
		animatorSet2.setTarget(binding.loginButton)
		
		val animator5 = ObjectAnimator.ofPropertyValuesHolder(binding.socialConstraintLayout, PropertyValuesHolder.ofKeyframe(View.TRANSLATION_Y, Keyframe.ofFloat(0f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3000f, this.resources.displayMetrics)), Keyframe.ofFloat(0.6f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -25f, this.resources.displayMetrics)), Keyframe.ofFloat(0.75f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 10f, this.resources.displayMetrics)), Keyframe.ofFloat(0.9f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -5f, this.resources.displayMetrics)), Keyframe.ofFloat(1f, TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0f, this.resources.displayMetrics))))
		animator5.duration = 1000
		animator5.interpolator = PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f)
		
		val animator6 = ObjectAnimator.ofPropertyValuesHolder(binding.socialConstraintLayout, PropertyValuesHolder.ofKeyframe(View.ALPHA, Keyframe.ofFloat(0f, 0f), Keyframe.ofFloat(0.6f, 1f), Keyframe.ofFloat(1f, 1f)))
		animator6.duration = 1000
		animator6.interpolator = PathInterpolatorCompat.create(0.22f, 0.61f, 0.61f, 1f)
		
		val animatorSet3 = AnimatorSet()
		animatorSet3.playTogether(animator5, animator6)
		animatorSet3.setTarget(binding.socialConstraintLayout)
		
		val animatorSet4 = AnimatorSet()
		animatorSet4.playTogether(animatorSet1, animatorSet2, animatorSet3)
		animatorSet4.start()
	}
}


