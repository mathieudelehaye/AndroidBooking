//
//  DemoProductBrowserView.kt
//
//  Created by Mathieu Delehaye on 7/08/2023.
//
//  AndroidJavaTools: A framework to develop Android apps with Java Technologies.
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

import android.app.Activity
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.android.java.androidjavatools.controller.tabview.home.ProductBrowserView
import com.android.java.androidjavatools.controller.tabview.product.FragmentProductSelection
import com.android.java.androidjavatools.controller.tabview.search.SearchBox
import com.android.java.androidjavatools.controller.template.FragmentWithSearch
import com.android.java.androidjavatools.controller.template.ResultProvider
import com.android.java.androidjavatools.databinding.FragmentHomeBinding

class DemoProductBrowserView(activity: Activity,
                             container: FragmentWithSearch,
                             binding: FragmentHomeBinding,
                             provider : ResultProvider,
                             search : SearchBox
) : ProductBrowserView(activity, container, binding, provider, search) {

    @Composable
    override fun browserView(
    ) {
        val images = intArrayOf(
            com.android.java.androiddemo.R.drawable.discount01, com.android.java.androiddemo.R.drawable.discount02,
            com.android.java.androiddemo.R.drawable.discount03)

        Column {
            Spacer(modifier = Modifier.height(56.dp))
            mSearchBox.show()

            Spacer(modifier = Modifier.height(5.dp))
            browserPager("Enjoy our new discounts", images, ContentScale.FillBounds) {
                FragmentProductSelection.setFilterField("sustainable")
                mNavigatorManager!!.navigator().showFragment("products")
            }
        }
    }
}