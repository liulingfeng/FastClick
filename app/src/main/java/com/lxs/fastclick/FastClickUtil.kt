package com.lxs.fastclick

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.FrameLayout


/**
 * @author liuxiaoshuai
 * @date 2019-08-26
 * @desc
 * @email liulingfeng@mistong.com
 */
object FastClickUtil {
    fun init(app: Application) {
        app.registerActivityLifecycleCallbacks(object :Application.ActivityLifecycleCallbacks{
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

    fun setClickListener(view: View) {
        val hasOnClick = view.hasOnClickListeners()

        if (hasOnClick) {
            val listener = ReflectUtils.getOnClickListener(view)
            if (view !is AdapterView<*>) {
                if (listener !is DelegateOnClickListener) {
                    view.setOnClickListener(DelegateImp(listener))
                }
            }
        }

        if (view is ViewGroup) {
            for (item in 0 until view.childCount) {
                val childView = view.getChildAt(item)
                setClickListener(childView)
            }
        }
    }
}