package com.lxs.fastclick

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import java.util.*
import android.widget.FrameLayout as FrameLayout1

/**
 * @author liuxiaoshuai
 * @date 2019-08-25
 * @desc
 * @email liulingfeng@mistong.com
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        FastClickUtil.init(this)
    }

    /**
     * 深度遍历
     */
    private fun depthTravelView(rootView: View?) {
        val queue = ArrayDeque<View>()
        queue.addLast(rootView)
        while (!queue.isEmpty()) {
            val temp = queue.first
            if (temp is ViewGroup) {
                for (item in 0 until temp.childCount) {
                    queue.addLast(temp.getChildAt(item))
                }
            }

            val listener = ReflectUtils.getOnClickListener(temp)
            if (listener != null) {
                Log.e("德玛", "你好${temp.javaClass.name}")
            } else {
                Log.e("德玛", temp.javaClass.name)
            }
            queue.pollFirst()
        }
    }
}