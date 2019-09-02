package com.lxs.fastclick.imp

import android.util.Log
import android.view.View
import com.lxs.fastclick.listener.DelegateOnClickListener
import com.lxs.fastclick.utils.ToastUtils

/**
 * @author liuxiaoshuai
 * @date 2019-08-26
 * @desc
 * @email liulingfeng@mistong.com
 */
class DelegateImp constructor(private var listener: View.OnClickListener?) :
    DelegateOnClickListener {

    private val TAG = "DelegateImp"

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
            //这次点击丢弃
            Log.i(TAG, "本次点击丢弃")
        }
    }
}