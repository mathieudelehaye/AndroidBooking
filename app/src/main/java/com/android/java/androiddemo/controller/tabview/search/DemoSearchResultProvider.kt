//
//  DemoSearchResultProvider.kt
//
//  Created by Mathieu Delehaye on 27/07/2023.
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

package com.android.java.androiddemo.controller.tabview.search

import com.android.java.androiddemo.model.DemoResultInfo
import com.android.java.androidjavatools.controller.tabview.search.SearchResultProvider
import com.android.java.androidjavatools.model.result.ResultInfo
import com.google.firebase.firestore.FirebaseFirestore

class DemoSearchResultProvider : SearchResultProvider() {
    override fun createResultInfo(database : FirebaseFirestore): ResultInfo {
        return DemoResultInfo(database)
    }
}