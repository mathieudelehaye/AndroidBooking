//
//  DemoTabViewActivity.kt
//
//  Created by Mathieu Delehaye on 25/07/2023.
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
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.android.java.androiddemo.controller.tabview.result.list.DemoFragmentResultList
import com.android.java.androiddemo.controller.tabview.search.DemoFragmentSuggestion
import com.android.java.androiddemo.controller.tabview.search.DemoSearchResultProvider
import com.android.java.androiddemo.model.user.DemoAuthManager
import com.android.java.androidjavatools.R
import com.android.java.androidjavatools.controller.tabview.TabViewActivity
import com.android.java.androidjavatools.controller.tabview.auth.AuthenticateDialogListener.SigningDialogCredentialViews
import com.android.java.androidjavatools.controller.template.Navigator
import com.android.java.androidjavatools.controller.template.SearchProvider
import com.android.java.androidjavatools.model.user.AuthManager

class DemoTabViewActivity : TabViewActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set layout background
        val coordinatorLayout = findViewById<View>(
            R.id.main_activity_layout
        ) as CoordinatorLayout
        coordinatorLayout.background = resources.getDrawable(com.android.java.androiddemo.R.drawable.background)

        // Set layout logo icon
        val mainActivityIcon: ImageView = findViewById<View>(
            R.id.main_activity_icon
        ) as ImageView
        mainActivityIcon.setImageResource(com.android.java.androiddemo.R.drawable.brand_logo)
    }

    override fun createNavigator() {
        mNavigator = Navigator(
            this, R.id.main_activity_layout
        )

        val searchResultProvider = DemoSearchResultProvider()

        mNavigator.declareFragment("tab", DemoFragmentTabView::class.java, Navigator.FragmentArgument(
            SearchProvider::class.java, searchResultProvider))
        mNavigator.declareFragment("suggestion", DemoFragmentSuggestion::class.java)

        // Some fragments need to be created straightforward, as they require their container view created and a
        // context, in order to instantiate some properties. So, it cannot happen when the fragment is shown for
        // the first time.
        mNavigator.declareAndCreateFragment("list", DemoFragmentResultList::class.java,
            Navigator.FragmentArgument(SearchProvider::class.java, searchResultProvider))

        // TODO: do not commit this auto authentication
        val am = DemoAuthManager(this)
        val emailEditText = EditText(this)
        emailEditText.setText("mathieu.delehaye@gmail.com")
        val passwordEditText = EditText(this)
        passwordEditText.setText("XXX")
        AuthManager.setAppFirstFragment("tab")
        am.onDialogRegisteredSignInClick(null, SigningDialogCredentialViews(
            emailEditText,
            passwordEditText,
            passwordEditText
        ))
    }

    override fun onEnvironmentConditionCheck(): Boolean {
        return false
    }

    override fun onTimeConditionCheck(): Boolean {
        return false
    }

    override fun onEnvironmentDependentActionRun() {
    }

    override fun onTimeDependentActionRun() {
    }
}