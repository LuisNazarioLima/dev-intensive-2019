package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_profile.*
import ru.skillbranch.devintensive.R

/*
fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(et_message.windowToken, 0);
}

fun Activity.isKeyboardOpen(): Boolean {
    val visibleBounds = Rect()
    tv_text.rootView.getWindowVisibleDisplayFrame(visibleBounds)
    val dm = tv_text.rootView.resources.displayMetrics
    val heightDiff = tv_text.rootView.bottom - visibleBounds.bottom

    return heightDiff > 100 * dm.density
}

fun Activity.isKeyboardClosed(): Boolean {
    val visibleBounds = Rect()

    tv_text.rootView.getWindowVisibleDisplayFrame(visibleBounds)
    val dm = tv_text.rootView.resources.displayMetrics
    val heightDiff = tv_text.rootView.bottom - visibleBounds.bottom

    return heightDiff < 100 * dm.density
}
        */