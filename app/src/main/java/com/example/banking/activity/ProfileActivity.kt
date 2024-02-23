package com.example.banking.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.example.banking.R
import com.example.banking.databinding.ActivityProfileBinding

class ProfileActivity : BaseActivity<ActivityProfileBinding>(ActivityProfileBinding::inflate) {
    private var isExpandedKyc = false
    private var isExpandedPassReset = false
    private var isExpandedChangeMpin = false





    override fun onClick() {
        // Set click listeners
        binding.apply {
            btKycdetail.setOnClickListener {
                toggleLinearLayoutVisibility(isExpandedKyc, llKycDetail)
                animateArrow(btKycdetail, isExpandedKyc)
                animateLinearLayout(llKycDetail, isExpandedKyc)
                isExpandedKyc = !isExpandedKyc
            }
            btPassReset.setOnClickListener {
                toggleLinearLayoutVisibility(isExpandedPassReset, llPassReset)
                animateArrow(btPassReset, isExpandedPassReset)
                animateLinearLayout(llPassReset, isExpandedPassReset)
                isExpandedPassReset = !isExpandedPassReset
            }
            btChangeMpin.setOnClickListener {
                toggleLinearLayoutVisibility(isExpandedChangeMpin, llChangeMpin)
                animateArrow(btChangeMpin, isExpandedChangeMpin)
                animateLinearLayout(llChangeMpin, isExpandedChangeMpin)
                isExpandedChangeMpin = !isExpandedChangeMpin
            }
            ivEditProfile.setOnClickListener{
                val intent = Intent(applicationContext,EditProfileActivity::class.java)
                startActivity(intent)
                finish()
            }
            icProfileBack.setOnClickListener {
                val intent = Intent(applicationContext,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun toggleLinearLayoutVisibility(isExpanded: Boolean, layout: View) {
        layout.visibility = if (isExpanded) View.GONE else View.VISIBLE
    }

    private fun animateArrow(button: View, isExpanded: Boolean) {
        val drawable = resources.getDrawable(if (isExpanded) R.drawable.ic_arrow_drop_down else R.drawable.ic_arrow_drop_up)
        drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
        when (button) {
            binding.btKycdetail -> binding.btKycdetail.setCompoundDrawablesRelative(null, null, drawable, null)
            binding.btPassReset -> binding.btPassReset.setCompoundDrawablesRelative(null, null, drawable, null)
            binding.btChangeMpin -> binding.btChangeMpin.setCompoundDrawablesRelative(null, null, drawable, null)
        }
    }

    private fun animateLinearLayout(linearLayout: View, isExpanded: Boolean) {
        val slideAnimation = if (isExpanded) {
            AnimationUtils.loadAnimation(this, R.anim.slide_up)
        } else {
            AnimationUtils.loadAnimation(this, R.anim.slide_down)
        }

        slideAnimation.interpolator = AccelerateDecelerateInterpolator()
        linearLayout.startAnimation(slideAnimation)
    }
}
