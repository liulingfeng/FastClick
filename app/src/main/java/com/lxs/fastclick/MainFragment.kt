package com.lxs.fastclick

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lxs.fastclick.utils.ToastUtils
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * @author liuxiaoshuai
 * @date 2019-08-27
 * @desc
 * @email liulingfeng@mistong.com
 */
class MainFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_content.setOnClickListener {
            ToastUtils.show("点我干嘛")
        }
    }
}