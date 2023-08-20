//
//  DemoFragmentHome.kt
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

package com.android.java.androiddemo.controller.tabview.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import com.android.java.androiddemo.R
import com.android.java.androidjavatools.controller.tabview.home.FragmentHome
import com.android.java.androidjavatools.controller.tabview.home.ProductBrowserView
import com.android.java.androidjavatools.controller.template.ResultProvider

class DemoFragmentHome(provider : ResultProvider) : FragmentHome(provider) {

    var mSharedPref : SharedPreferences? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState);
        mSharedPref = mContext.getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    override fun searchAndDisplayItems() {
        TODO("Not yet implemented")
    }

    override fun getProductBrowserView(): ProductBrowserView {
        return DemoProductBrowserView(requireActivity(), this, mBinding, mResultProvider, mSearchBox)
    }
}