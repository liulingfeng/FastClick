package com.lxs.fastclick

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lxs.fastclick.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_second.*

/**
 * @author liuxiaoshuai
 * @date 2019-08-27
 * @desc
 * @email liulingfeng@mistong.com
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tv_content.setOnClickListener {
            ToastUtils.show("同个id是否有影响")
        }
    }
}