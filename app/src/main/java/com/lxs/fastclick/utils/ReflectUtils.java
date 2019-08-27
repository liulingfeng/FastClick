package com.lxs.fastclick.utils;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.AdapterView;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liuxiaoshuai
 * @date 2019-08-26
 * @desc
 * @email liulingfeng@mistong.com
 */
public class ReflectUtils {
    public static View.OnClickListener getOnClickListener(View view) {
        boolean hasOnClick = view.hasOnClickListeners();
        if (hasOnClick) {
            try {
                @SuppressLint("PrivateApi")
                Method method = View.class.getDeclaredMethod("getListenerInfo");
                method.setAccessible(true);
                Object object = method.invoke(view);
                if (null != object) {
                    Class listenerInfoClazz = object.getClass();
                    Field mOnClickListener = listenerInfoClazz.getDeclaredField("mOnClickListener");
                    mOnClickListener.setAccessible(true);
                    Object listener = mOnClickListener.get(object);
                    if (listener instanceof View.OnClickListener) {
                        return (View.OnClickListener) listener;
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static AdapterView.OnItemClickListener getOnItemClickListener(View view) {
        try {
            Field field = AdapterView.class.getDeclaredField("mOnItemClickListener");
            field.setAccessible(true);
            Object onItemClickListener = field.get(view);
            if (onItemClickListener instanceof AdapterView.OnItemClickListener) {
                return (AdapterView.OnItemClickListener) onItemClickListener;
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
