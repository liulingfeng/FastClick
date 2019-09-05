package com.lxs.fastclick

import android.view.View

/**
 * @author liuxiaoshuai
 * @date 2019-09-05
 * @desc
 * @email liulingfeng@mistong.com
 */
/**
 * filter fastCLick
 * 扩展函数——第三种方式：个人认为对原先代码侵入性太强，不适合用于适配老代码
 */
fun View._setOnClickListener(block: (v: View?) -> Unit) {
    setOnClickListener(object : View.OnClickListener {
        var lastTime = 0L
        override fun onClick(v: View?) {
            if (System.currentTimeMillis() - lastTime > 2000L) {
                block.invoke(v)
                lastTime = System.currentTimeMillis()
            }
        }

    })
}