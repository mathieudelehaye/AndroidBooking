//
//  DemoSearchSuggestionProvider.kt
//
//  Created by Mathieu Delehaye on 9/08/2023.
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

import android.app.SearchManager
import android.database.Cursor
import android.database.MatrixCursor
import android.net.Uri
import android.util.Log
import com.android.java.androidjavatools.controller.tabview.search.SearchSuggestionProvider

class DemoSearchSuggestionProvider : SearchSuggestionProvider {

    constructor() {

    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        val userInput = selectionArgs?.get(0)
        Log.v("AJT", "Received the query: $userInput")
        val columns = arrayOf("_ID", SearchManager.SUGGEST_COLUMN_TEXT_1)
        val cursor = MatrixCursor(columns)
        cursor.addRow(arrayOf<Any>(0, "Around current location"))
        //cursor.addRow(new Object[] {1, userInput});
        cursor.addRow(arrayOf<Any>(1, "London"))
        cursor.addRow(arrayOf<Any>(2, "NYC"))
        cursor.addRow(arrayOf<Any>(3, "Paris"))
        return cursor
    }
}