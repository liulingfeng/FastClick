package com.lxs.fastclick

import android.util.SparseArray
import android.view.View
import android.widget.AdapterView
import com.lxs.fastclick.listener.DelegateOnItemClickListener
import com.lxs.fastclick.utils.ToastUtils

/**
 * @author liuxiaoshuai
 * @date 2019-08-27
 * @desc
 * @email liulingfeng@mistong.com
 */
class DelegateItemImp constructor(private var listener: AdapterView.OnItemClickListener?) :
    DelegateOnItemClickListener {
    companion object {
        val lastTimes = SparseArray<Long>()
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
        val currentTime = System.currentTimeMillis()
        var lastTime: Long? = null

        if (lastTimes.get(view.id.plus(position)) != null) {
            lastTime = lastTimes.get(view.id.plus(position))
        }
        if (lastTime == null || currentTime - lastTime > 2000) {
            listener?.onItemClick(parent, view, position, id)
            lastTimes.put(view.id.plus(position), currentTime)
        } else {
            ToastUtils.show("点击太过于频繁")
        }
    }
}