package com.lxs.fastclick.widget

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import com.lxs.fastclick.imp.DelegateImp

/**
 * @author liuxiaoshuai
 * @date 2019-09-02
 * @desc
 * @email liulingfeng@mistong.com
 */
class FastClickTextView : AppCompatTextView {
    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun setOnClickListener(l: OnClickListener?) {
        super.setOnClickListener(DelegateImp(l))
    }
}