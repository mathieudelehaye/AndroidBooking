//
//  DemoCollectionPagerAdapter.kt
//
//  Created by Mathieu Delehaye on 6/08/2023.
//
//  AndroidDemo: A demo mobile app to rent an accommodation, re-using the AndroidJavaTools library.
//
//  Copyright © 2023 Mathieu Delehaye. All rights reserved.
//
//
//  This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General
//  Public License as published by
//  the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
//
//  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
//  warranty of MERCHANTABILITY or FITNESS
//  FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License for more details.
//
//  You should have received a copy of the GNU Affero General Public License along with this program. If not, see
//  <https://www.gnu.org/licenses/>.

package com.android.java.androiddemo.controller.tabview

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.android.java.androiddemo.controller.tabview.home.DemoFragmentHome
import com.android.java.androiddemo.controller.tabview.order.DemoFragmentOrderList
import com.android.java.androiddemo.controller.tabview.profile.DemoFragmentProfileMenu
import com.android.java.androiddemo.controller.tabview.saved.DemoFragmentSavedList
import com.android.java.androidjavatools.controller.tabview.CollectionPagerAdapter
import com.android.java.androidjavatools.controller.template.ResultProvider
import com.android.java.androidjavatools.controller.template.SearchProvider

class DemoCollectionPagerAdapter(
    fm: FragmentManager?,
    fa: FragmentActivity?,
    rProvider: ResultProvider?,
    sProvider: SearchProvider?
) : CollectionPagerAdapter(fm, fa, rProvider, sProvider) {

    // TODO: check if the fragments be stored in a hashtable, rather than re-creating them each time.
    override fun findTabFragment(i: Int): Fragment {
        val fragment: Fragment = when (i) {
            0 -> DemoFragmentHome(mResultProvider)
            1 -> DemoFragmentSavedList(mResultProvider, mSearchProvider)
            2 -> DemoFragmentOrderList()
            else -> DemoFragmentProfileMenu()
        }

        return fragment
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun getPageTitle(position: Int): CharSequence? {
        val image: Drawable = when (position) {
            0 -> mActivity.resources.getDrawable(com.android.java.androidjavatools.R.drawable.magnify)
            1 -> mActivity.resources.getDrawable(com.android.java.androidjavatools.R.drawable.heart_outline)
            2 -> mActivity.resources.getDrawable(com.android.java.androiddemo.R.drawable.bag_suitcase_outline)
            3 -> mActivity.resources.getDrawable(com.android.java.androidjavatools.R.drawable.dots_horizontal)
            else -> mActivity.resources.getDrawable(com.android.java.androidjavatools.R.drawable.dots_horizontal)
        }
        image.setBounds(0, 0, image.intrinsicWidth, image.intrinsicHeight)
        val sb = SpannableString(" ")
        val imageSpan = ImageSpan(image, ImageSpan.ALIGN_BOTTOM)
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return sb
    }
}