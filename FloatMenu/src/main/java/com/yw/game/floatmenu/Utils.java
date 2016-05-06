/*
 * Copyright (c) 2016, Shanghai YUEWEN Information Technology Co., Ltd.
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *  Neither the name of Shanghai YUEWEN Information Technology Co., Ltd. nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY SHANGHAI YUEWEN INFORMATION TECHNOLOGY CO., LTD. AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package com.yw.game.floatmenu;


import android.content.Context;
import android.support.annotation.DimenRes;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
public class Utils {

    private static final String TAG = "Utils";

    public static int getDimension(Context context, @DimenRes int id) {
        return context.getResources().getDimensionPixelSize(id);
    }

    public static int px2dp(float pxVal, Context mContext) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, pxVal, mContext.getResources().getDisplayMetrics()));
    }

    public static int dp2Px(float dp, Context mContext) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                mContext.getResources().getDisplayMetrics());
    }

    public static final FrameLayout.LayoutParams createLayoutParams(int width, int height) {
        return new FrameLayout.LayoutParams(width, height);
    }

    public static final FrameLayout.LayoutParams createMatchParams() {
        return createLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public static final FrameLayout.LayoutParams createWrapParams() {
        return createLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    public static final FrameLayout.LayoutParams createWrapMatchParams() {
        return createLayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
    }

    public static final FrameLayout.LayoutParams createMatchWrapParams() {
        return createLayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

//    public static void setInsets(Activity context, View view) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return;
//        SystemBarTintManager tintManager = new SystemBarTintManager(context);
//        SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
//        view.setPadding(0, config.getPixelInsetTop(false), config.getPixelInsetRight(), config.getPixelInsetBottom());
//    }
//
//    public static int getInsetsTop(Activity context, View view) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return 0;
//        SystemBarTintManager tintManager = new SystemBarTintManager(context);
//        SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
//        return config.getPixelInsetTop(false);
//    }
//
//    public static int getInsetsBottom(Activity context, View view) {
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) return 0;
//        SystemBarTintManager tintManager = new SystemBarTintManager(context);
//        SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
//        return config.getPixelInsetBottom();
//    }
}
