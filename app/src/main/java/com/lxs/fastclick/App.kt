package com.lxs.fastclick

import android.app.Application
import com.lxs.fastclick.utils.FastClickUtil
import com.lxs.fastclick.utils.ToastUtils

/**
 * @author liuxiaoshuai
 * @date 2019-08-25
 * @desc
 * @email liulingfeng@mistong.com
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        ToastUtils.init(this)
        FastClickUtil.init(this)
    }
}