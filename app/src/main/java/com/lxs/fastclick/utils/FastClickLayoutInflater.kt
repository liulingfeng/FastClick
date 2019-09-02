package com.lxs.fastclick.utils

import android.content.Context
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import com.lxs.fastclick.widget.FastClickTextView

/**
 * @author liuxiaoshuai
 * @date 2019-09-02
 * @desc
 * @email liulingfeng@mistong.com
 */
class FastClickLayoutInflater(private val appCompatDelegate: AppCompatDelegate?) : LayoutInflater.Factory2 {
    override fun onCreateView(parent: View?, name: String?, context: Context, attrs: AttributeSet): View? {
        var view = appCompatDelegate?.createView(parent, name, context, attrs)
        when (view) {
            is AppCompatTextView -> {
                view = FastClickTextView(context, attrs)
            }
        }
        return view
    }

    override fun onCreateView(name: String?, context: Context, attrs: AttributeSet): View? {
        return onCreateView(null, name, context, attrs)
    }
}