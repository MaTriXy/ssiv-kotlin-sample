/*
Copyright 2014 David Morrissey

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package com.davemorrissey.labs.subscaleview.sample.extension

import android.util.Log

import com.davemorrissey.labs.subscaleview.sample.AbstractFragmentsActivity
import com.davemorrissey.labs.subscaleview.sample.Page
import com.davemorrissey.labs.subscaleview.sample.R.id
import com.davemorrissey.labs.subscaleview.sample.imagedisplay.ImageDisplayActivity

import java.util.Arrays

import com.davemorrissey.labs.subscaleview.sample.R.layout.fragments_activity
import com.davemorrissey.labs.subscaleview.sample.R.string.extension_p1_subtitle
import com.davemorrissey.labs.subscaleview.sample.R.string.extension_p1_text
import com.davemorrissey.labs.subscaleview.sample.R.string.extension_p2_subtitle
import com.davemorrissey.labs.subscaleview.sample.R.string.extension_p2_text
import com.davemorrissey.labs.subscaleview.sample.R.string.extension_p3_subtitle
import com.davemorrissey.labs.subscaleview.sample.R.string.extension_p3_text
import com.davemorrissey.labs.subscaleview.sample.R.string.extension_title

class ExtensionActivity : AbstractFragmentsActivity(extension_title, fragments_activity, Arrays.asList(
        Page(extension_p1_subtitle, extension_p1_text),
        Page(extension_p2_subtitle, extension_p2_text),
        Page(extension_p3_subtitle, extension_p3_text)
)) {

    override fun onPageChanged(page: Int) {
        try {
            supportFragmentManager
                    .beginTransaction()
                    .replace(id.frame, FRAGMENTS[page].newInstance())
                    .commit()
        } catch (e: Exception) {
            Log.e(ImageDisplayActivity::class.java.name, "Failed to load fragment", e)
        }
    }

    companion object {

        private val FRAGMENTS = Arrays.asList(
                ExtensionPinFragment::class.java,
                ExtensionCircleFragment::class.java,
                ExtensionFreehandFragment::class.java
        )
    }

}
