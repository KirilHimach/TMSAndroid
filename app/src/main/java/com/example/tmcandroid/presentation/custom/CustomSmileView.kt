package com.example.tmcandroid.presentation.custom

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.example.tmcandroid.R.color.borderSmileColor
import com.example.tmcandroid.R.color.faceSmileColor
import com.example.tmcandroid.R.color.leftEyeSmileColor
import com.example.tmcandroid.R.color.mouthSmileColor
import com.example.tmcandroid.R.color.rightEyeSmileColor
import kotlin.math.min

/**
 * TODO Refactor
 * - add companion object
 * - apply kotlin
 * - single responsibility
 * - naming parameters
 * - internal - и изучить что это
 *
 */
internal class CustomSmileView(
    context: Context,
    attributes: AttributeSet
) : View(context, attributes) {

    companion object {
        private var paint = Paint(Paint.ANTI_ALIAS_FLAG)
        private val styleFill = Paint.Style.FILL
        private var borderWidth = 4.0f
        private var size = 320
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        size = getSize()
        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        drawBackground(canvas)
        drawBorder(canvas)
        drawRightEye(canvas)
        drawLeftEye(canvas)
        drawMouth(canvas)
    }

    private fun getSize(): Int {
        return min(measuredWidth, measuredHeight)
    }

    private fun drawBackground(canvas: Canvas) {
        paint.apply {
            color = ContextCompat.getColor(context, faceSmileColor)
            style = styleFill
        }
        canvas.drawCircle(size / 2f, size / 2f, size / 2f, paint)
    }

    private fun drawBorder(canvas: Canvas) {
        paint.apply {
            color = ContextCompat.getColor(context, borderSmileColor)
            style = Paint.Style.STROKE
            strokeWidth = borderWidth
        }
        canvas.drawCircle(
            size / 2f,
            size / 2f,
            (size / 2f) - borderWidth / 2f,
            paint
        )
    }

    private fun drawRightEye(canvas: Canvas) {
        paint.apply {
            color = ContextCompat.getColor(context, rightEyeSmileColor)
            style = styleFill
        }
        val rightEyeRect = RectF(
            size * 0.57f,
            size * 0.23f,
            size * 0.68f,
            size * 0.50f
        )
        canvas.drawOval(rightEyeRect, paint)
    }

    private fun drawLeftEye(canvas: Canvas) {
        paint.apply {
            color = ContextCompat.getColor(context, leftEyeSmileColor)
            style = styleFill
        }
        val leftEyeRect = RectF(
            size * 0.32f,
            size * 0.23f,
            size * 0.43f,
            size * 0.50f
        )
        canvas.drawOval(leftEyeRect, paint)
    }

    private fun drawMouth(canvas: Canvas) {
        val mouthPath = Path()
        mouthPath.moveTo(
            size * 0.22f,
            size * 0.7f
        )
        mouthPath.quadTo(
            size * 0.50f,
            size * 0.80f,
            size * 0.78f,
            size * 0.70f
        )
        mouthPath.quadTo(
            size * 0.50f,
            size * 0.90f,
            size * 0.22f,
            size * 0.70f
        )
        paint.apply {
            color = ContextCompat.getColor(context, mouthSmileColor)
            style = styleFill
        }
        canvas.drawPath(mouthPath, paint)
    }
}