package ru.skillbranch.devintensive.models

import android.content.res.Resources
import android.graphics.*
import android.graphics.drawable.Drawable
import android.graphics.Paint.ANTI_ALIAS_FLAG
import androidx.core.view.ViewCompat.setAlpha

class AvatarInitialsDrawable : Drawable() {
    private val mPaint = Paint(ANTI_ALIAS_FLAG)
    private val mPath = Path()
    private var initials = ""

    override fun draw(canvas: Canvas) {
        canvas.drawPath(mPath, mPaint)
        mPaint.reset()
        mPaint.color = Color.WHITE
        mPaint.style = Paint.Style.FILL
        mPaint.textAlign = Paint.Align.CENTER
        mPaint.textSize = canvas.height.toFloat() / 2f
        canvas.drawText(initials, canvas.width.toFloat()/2f, canvas.height.toFloat()*2f/3f, mPaint)
    }

    override fun getOpacity(): Int {
        return PixelFormat.TRANSLUCENT
    }

    override fun setAlpha(alpha: Int) {
        mPaint.alpha = alpha
    }

    override fun setColorFilter(colorFilter: ColorFilter?) {
        mPaint.colorFilter = colorFilter
    }

    override fun onBoundsChange(bounds: Rect) {
        super.onBoundsChange(bounds)
        val width = bounds.width()
        val height = bounds.height()
        val radius: Float = Math.min(width, height).toFloat() / 2f
        mPath.reset()
        mPath.addCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, Path.Direction.CW)
        mPath.close()
    }

    private fun getPaint(): Paint {
        return mPaint
    }
    fun setColor(color: Int){
        mPaint.color = color
    }

    fun setText(text: String) {
        initials = text
    }
}