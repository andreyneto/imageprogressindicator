package app.sorocaba.imageprogressindicator

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.layout_image_progress_indicator.view.*

class ImageProgressIndicator @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {
    private val view: View =
        LayoutInflater.from(context).inflate(R.layout.layout_image_progress_indicator, this, false)

    init {
        view.id = View.generateViewId()
        addView(view)
        setProgress(0)
    }

    fun init(percentage: Int, url: String) {
        setProgress(percentage)
        setImage(url)
    }

    @SuppressLint("SetTextI18n")
    fun setProgress(percentage: Int) {
        with(view.backgroundv) {
            viewTreeObserver.addOnGlobalLayoutListener {
                val lp = view.progress.layoutParams
                val w = (measuredWidth * percentage) / 100
                lp.width = if (w == 0) 1 else w
                view.progress.layoutParams = lp
            }
            view.backgroundv.width
            layoutParams.width = 0
            requestLayout()
        }
        view.label_value.text = "$percentage%"
    }

    fun setImage(url: String) {
        Glide.with(this).load(url).into(view.indicator)
    }
}