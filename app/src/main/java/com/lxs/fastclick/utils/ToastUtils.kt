package com.lxs.fastclick.utils

import android.widget.Toast
import com.lxs.fastclick.App

/**
 * @author liuxiaoshuai
 * @date 2019-08-27
 * @desc
 * @email liulingfeng@mistong.com
 */
object ToastUtils {
    private var app: App? = null

    fun init(app: App) {
        this.app = app
    }

    fun show(content: String) {
        if (app != null)
            Toast.makeText(app, content, Toast.LENGTH_SHORT).show()
    }
}