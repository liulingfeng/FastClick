package com.lxs.fastclick

import android.util.Log
import android.view.View

/**
 * @author liuxiaoshuai
 * @date 2019-08-26
 * @desc
 * @email liulingfeng@mistong.com
 */
class DelegateImp constructor(private var listener: View.OnClickListener?) : DelegateOnClickListener {

    override fun onClick(v: View?) {
        val currentTime = System.currentTimeMillis()
        var lastTime: Long? = null
        if (v?.getTag(v.id) != null) {
            lastTime = v.getTag(v.id) as Long
        }
        if (lastTime == null || currentTime - lastTime > 2000) {
            listener?.onClick(v)
            v?.setTag(v.id, currentTime)
        } else {
            Log.e("德玛", "点击太过于频繁")
        }
    }
}