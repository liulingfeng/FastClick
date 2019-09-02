package com.lxs.fastclick.utils

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ListView
import com.lxs.fastclick.imp.DelegateImp
import com.lxs.fastclick.imp.DelegateItemImp
import com.lxs.fastclick.listener.DelegateOnClickListener
import com.lxs.fastclick.listener.DelegateOnItemClickListener
import java.util.*


/**
 * @author liuxiaoshuai
 * @date 2019-08-26
 * @desc
 * @email liulingfeng@mistong.com
 */
object FastClickUtil {
    fun init(app: Application) {
        app.registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity?) {
            }

            override fun onActivityResumed(activity: Activity?) {
                val content = activity?.findViewById<FrameLayout>(android.R.id.content)
                content?.let {
                    setClickListener(it)
                }
            }

            override fun onActivityStarted(activity: Activity?) {
            }

            override fun onActivityDestroyed(activity: Activity?) {
            }

            override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
            }

            override fun onActivityStopped(activity: Activity?) {
            }

            override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            }

        })
    }

    /**
     * 用广度遍历
     * 用递归性能比较差、递归本质是栈的操作，可能会造成栈溢出
     */
    fun setClickListener(rootView: View) {
        val queue = ArrayDeque<View>()
        queue.addLast(rootView)
        while (!queue.isEmpty()) {
            val temp = queue.first
            if (temp is ViewGroup) {
                for (item in 0 until temp.childCount) {
                    queue.addLast(temp.getChildAt(item))
                }
            }

            val hasOnClick = temp.hasOnClickListeners()
            if (hasOnClick) {
                val listener = ReflectUtils.getOnClickListener(temp)
                if (listener !is DelegateOnClickListener) {//可以处理不需要加快速点击的需求
                    temp.setOnClickListener(DelegateImp(listener))
                }
            } else {
                if (temp is ListView) {
                    val onItemClickListener = ReflectUtils.getOnItemClickListener(temp)
                    if (onItemClickListener !is DelegateOnItemClickListener) {
                        temp.onItemClickListener = DelegateItemImp(onItemClickListener)
                    }
                }
            }

            queue.pollFirst()
        }
    }
}