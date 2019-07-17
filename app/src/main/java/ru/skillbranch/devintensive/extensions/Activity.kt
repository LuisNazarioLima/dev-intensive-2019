package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.content.Context.INPUT_METHOD_SERVICE
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import kotlinx.android.synthetic.main.activity_main.*
import ru.skillbranch.devintensive.R


fun Activity.hideKeyboard() {
    val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    //imm.hideSoftInputFromWindow(et_message.getWindowToken(), 0)
    imm.hideSoftInputFromWindow(et_message.windowToken, 0);
}

fun Activity.isKeyboardOpen(rootView: View): Boolean {
    val visibleBounds = Rect()

    rootView.getRootView().getWindowVisibleDisplayFrame(visibleBounds)
    val dm = rootView.resources.displayMetrics
    val heightDiff = rootView.bottom - visibleBounds.bottom

    return heightDiff > 100 * dm.density
}

fun Activity.isKeyboardClosed(rootView: View): Boolean {
    val visibleBounds = Rect()

    rootView.getRootView().getWindowVisibleDisplayFrame(visibleBounds)
    val dm = rootView.resources.displayMetrics
    val heightDiff = rootView.bottom - visibleBounds.bottom

    return heightDiff < 100 * dm.density
}