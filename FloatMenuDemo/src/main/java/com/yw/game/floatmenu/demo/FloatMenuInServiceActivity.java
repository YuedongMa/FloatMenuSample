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

package com.yw.game.floatmenu.demo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.yw.game.floatmenu.FloatMenu;
import com.yw.game.floatmenu.MenuItemView;
import com.yw.game.floatmenu.OnMenuActionListener;

public class FloatMenuInServiceActivity extends AppCompatActivity implements View.OnClickListener, OnMenuActionListener {
    private FloatMenuService mFloatMenuService;
    private FloatMenu mFloatMenu;
    private Handler mHandler = new Handler();
    private final ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mFloatMenuService = ((FloatMenuService.FloatViewServiceBinder) iBinder).getService();
            if (mFloatMenuService != null) {
                mFloatMenuService.showFloat();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mFloatMenuService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_menu_in_service);

      //  startFloatMenu(this);
init();
    }
void  init(){
    if(mFloatMenu!=null)mFloatMenu.destroy();
    mFloatMenu = new FloatMenu.Builder(this)
            .floatLoader(R.drawable.yw_anim_background)
            .floatLogo(R.drawable.yw_image_float_logo)
            .addMenuItem(android.R.color.transparent, R.drawable.yw_menu_account, Const.MENU_ITEMS[0], android.R.color.black, this)
            .addMenuItem(android.R.color.transparent, R.drawable.yw_menu_favour, Const.MENU_ITEMS[1], android.R.color.black, this)
            .addMenuItem(android.R.color.transparent, R.drawable.yw_menu_fb, Const.MENU_ITEMS[2], android.R.color.black, this)
            .addMenuItem(android.R.color.transparent, R.drawable.yw_menu_msg, Const.MENU_ITEMS[3], android.R.color.black, this)
            .addMenuItem(android.R.color.transparent, R.drawable.yw_menu_close, Const.MENU_ITEMS[4], android.R.color.black, this)
            .menuBackground(R.drawable.yw_menu_bg)
            .onMenuActionListner(this)
            .build();


    mFloatMenu.show();
}
    public boolean startFloatMenu(Context context) {
        boolean startFloatMenuSuccessed;
        try {
            Intent intent = new Intent(context, FloatMenuService.class);
            context.startService(intent);
            context.bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
            startFloatMenuSuccessed = true;
        } catch (Exception ignored) {
            startFloatMenuSuccessed = false;
        }
        return startFloatMenuSuccessed;
    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mFloatMenu != null)
            mFloatMenu.show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mFloatMenu != null) {
            mFloatMenu.destroy();
        }
    }

    @Override
    public void onClick(View v) {

        if (v instanceof MenuItemView) {
            MenuItemView menuItemView = (MenuItemView) v;
            String menuItemLabel = menuItemView.getMenuItem().getLabel();
            Toast.makeText(this, menuItemLabel, Toast.LENGTH_SHORT).show();
            switch (menuItemLabel) {
                case Const.HOME:
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            mHandler.post(new Runnable() {
                               @Override
                               public void run() {
                                   mFloatMenu.stopLoaderAnim();
                                   goHomeIndex(FloatMenuInServiceActivity.this);
                               }
                           }) ;
                        }
                    }).start();

                    break;
                case Const.FAVOUR:

                    break;
                case Const.FEEDBACK:


                    break;
                case Const.MESSAGE:

                    break;
                case Const.CLOSE:

                    break;
            }
        }
    }
    @Override
    public void onMenuOpen() {
mFloatMenu.clickMenu();
    }

    @Override
    public void onMenuClose() {

    }
    private void goHomeIndex(Context context) {
        Uri uri = Uri.parse(Const.GAME_URL);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
