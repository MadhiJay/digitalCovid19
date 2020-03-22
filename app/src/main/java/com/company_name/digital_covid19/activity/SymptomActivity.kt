/*
*  SymptomActivity.kt
*  digitalCovid19
*
*  Created by Erandra Jayasundara.
*  Copyright © 2018 keliya. All rights reserved.
*/

package com.company_name.digital_covid19.activity

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.company_name.digital_covid19.R
import com.company_name.digital_covid19.databinding.SymptomActivityBinding


class SymptomActivity: AppCompatActivity() {

	companion object {
		
		fun newIntent(context: Context): Intent {
		
			// Fill the created intent with the data you want to be passed to this Activity when it's opened.
			return Intent(context, SymptomActivity::class.java)
		}
	}
	
	private lateinit var binding: SymptomActivityBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
	
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.symptom_activity)
		this.init()
	}
	
	private fun init() {
	
		// Configure No component
		binding.noButton.setOnClickListener({ view ->
			this.onNoPressed()
		})
		
		// Configure Yes component
		binding.yesButton.setOnClickListener({ view ->
			this.onYesPressed()
		})
	}
	
	fun onNoPressed() {
	
		this.startSymptomsSecondActivity()
	}
	
	fun onYesPressed() {
	
	}
	
	private fun startSymptomsSecondActivity() {
	
		this.startActivity(SymptomsSecondActivity.newIntent(this))
	}
}