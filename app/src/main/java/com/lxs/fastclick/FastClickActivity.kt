package com.lxs.fastclick

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.view.LayoutInflaterCompat
import android.support.v7.app.AppCompatActivity
import com.lxs.fastclick.utils.FastClickLayoutInflater

/**
 * @author liuxiaoshuai
 * @date 2019-09-02
 * @desc 用factory代理的方式实现
 * @email liulingfeng@mistong.com
 */
@SuppressLint("Registered")
open class FastClickActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        LayoutInflaterCompat.setFactory2(layoutInflater, FastClickLayoutInflater(delegate))
        super.onCreate(savedInstanceState)
    }
}