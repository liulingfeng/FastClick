package com.lxs.fastclick;

import android.annotation.SuppressLint;
import android.view.View;
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
}
