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

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.android.java.androiddemo.controller.tabview.home.DemoFragmentHome
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

    override fun findTabFragment(i: Int): Fragment {
        val fragment: Fragment
        when (i) {
            0 -> fragment = DemoFragmentHome(mResultProvider)
            1 -> fragment = DemoFragmentSavedList(mResultProvider, mSearchProvider)
            else -> fragment = DemoFragmentProfileMenu()
        }

        return fragment
    }
}