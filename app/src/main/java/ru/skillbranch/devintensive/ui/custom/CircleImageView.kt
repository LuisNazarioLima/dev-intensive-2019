package ru.skillbranch.devintensive.ui.custom

import android.content.Context
import android.content.res.Resources
import android.graphics.*
import android.util.AttributeSet
import android.widget.ImageView
import android.view.View
import ru.skillbranch.devintensive.R
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.annotation.ColorRes
import androidx.annotation.Dimension
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import kotlinx.android.synthetic.main.activity_profile.view.*
import ru.skillbranch.devintensive.extensions.toDp
import ru.skillbranch.devintensive.extensions.toPx
import ru.skillbranch.devintensive.utils.Utils.toInitials


class CircleImageView @JvmOverloads constructor(
    context:Context,
    attrs:AttributeSet? = null,
    defStyleAttr:Int = 0
) : ImageView(context, attrs, defStyleAttr) {
    companion object{
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
        private const val DEFAULT_BORDER_WIDTH = 6.0f
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var cv_borderColor = DEFAULT_BORDER_COLOR
    private var cv_borderWidth = DEFAULT_BORDER_WIDTH

    private val mPath = Path()

    init {
        if (attrs != null) {
            val a = context.obtainStyledAttributes(attrs, R.styleable.CircleImageView)
            cv_borderColor = a.getColor(R.styleable.CircleImageView_cv_borderColor, DEFAULT_BORDER_COLOR)
            cv_borderWidth = a.getDimension(R.styleable.CircleImageView_cv_borderWidth, DEFAULT_BORDER_WIDTH)
            a.recycle()
        }
    }

    override fun draw(canvas: Canvas?) {
        val width: Int = width
        val height: Int = height
        val radius: Float = Math.min(width, height).toFloat() / 2f
        mPath.addCircle((width / 2).toFloat(), (height / 2).toFloat(), radius, Path.Direction.CW)
        canvas!!.clipPath(mPath)
        super.draw(canvas)
    }
        override fun onDraw(canvas: Canvas) {
            super.onDraw(canvas)
            //if ((et_first_name != null) or (et_last_name != null)) {
                drawBackground(canvas)
              //  drawAvatar(canvas)
             //   drawText(canvas)
            //}
            //setBorderWidth(6)
            //getBorderWidth()
        }

    private fun drawText(canvas: Canvas) {
        paint.reset()
        paint.color = Color.WHITE
        paint.style = Paint.Style.FILL
        paint.textAlign = Paint.Align.CENTER
        paint.textSize = height.toFloat() / 2f
        canvas.drawText("${et_first_name.text.toString().substring(0,1)}${et_last_name.text.toString().substring(0,1)}", width.toFloat()/2f, height.toFloat()*2f/3f, paint)
    }

    private fun drawAvatar(canvas: Canvas) {
        var dra: Drawable? = ContextCompat.getDrawable(context, R.drawable.avatar_default)
        var bit = dra?.toBitmap(width, height)
        canvas.drawBitmap(bit!!, 0f, 0f, paint)
        //canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius - cv_borderWidth / 2f, paint)
    }

    private fun drawBackground(canvas: Canvas) {
            val width: Int = canvas.width
            val height: Int = canvas.height
            val radius: Float = Math.min(width, height).toFloat() / 2f
            paint.color = cv_borderColor
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = cv_borderWidth
            canvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), radius - cv_borderWidth / 2f, paint)
    }

        @Dimension fun getBorderWidth() : Int {
            Log.d("GetBorder","GetBorder ${cv_borderWidth.toInt().toDp()}")
            return cv_borderWidth.toInt().toDp()
        }

        fun setBorderWidth(@Dimension dp: Int) {
            cv_borderWidth = dp.toPx().toFloat()
            Log.d("SetBorder","SetBorder $cv_borderWidth")
            invalidate()
        }

        fun getBorderColor():Int {
            Log.d("getBorderColor","GetBorderColor $cv_borderColor")
            return cv_borderColor
        }

        fun setBorderColor(hex:String) {
            cv_borderColor =  Color.parseColor(hex)
            paint.color = cv_borderColor
            invalidate()
        }

        fun setBorderColor(@ColorRes colorId: Int) {
            cv_borderColor = resources.getColor(colorId, context.theme) //colorId
            paint.color = cv_borderColor
            invalidate()
        }
        override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
            //val size = Math.min(measuredWidth, measuredHeight)
            setMeasuredDimension(measuredWidth, measuredHeight)
        }

    override fun setImageDrawable(drawable: Drawable?) {
        super.setImageDrawable(drawable)
    }

    override fun setImageBitmap(bm: Bitmap?) {
        super.setImageBitmap(bm)
    }
}
