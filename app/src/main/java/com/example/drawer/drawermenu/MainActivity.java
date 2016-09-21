package com.example.drawer.drawermenu;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private NavigationView mNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }


    public void init(){
        mToolbar = (Toolbar) findViewById(R.id.activity_main_toolbar);
        mNavigationView = (NavigationView) findViewById(R.id.activity_main_navigationView);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.activity_main_drawerlayout);

        /**
         * 添加Toolbar的menu部分
         */
        mToolbar.inflateMenu(R.menu.toobar_menu);

        mActionBarDrawerToggle = new ActionBarDrawerToggle(this , mDrawerLayout , mToolbar , R.string.drawer_open , R.string.drawer_close){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        /**
         * 禁止使用ActionBarDrawerToggle默认的导航图标
         */
        mActionBarDrawerToggle.setDrawerIndicatorEnabled(false);
        mActionBarDrawerToggle.setHomeAsUpIndicator(R.mipmap.ic_drawer_home);
        /**
         *  将导航图标设置成自己的图片后，导航图标会失去点击打开抽屉菜单的效果，所以需要自己添加点击事件
         */
        mActionBarDrawerToggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        /**
         * 给抽屉菜单的菜单项设置点击事件
         */
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.drawer_menu_home:
                        Toast.makeText(MainActivity.this , "Home" ,Toast.LENGTH_LONG).show();
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.drawer_menu_setting:
                        Toast.makeText(MainActivity.this , "setting" ,Toast.LENGTH_LONG).show();
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.drawer_menu_notification:
                        Toast.makeText(MainActivity.this , "notification" ,Toast.LENGTH_LONG).show();
                        mDrawerLayout.closeDrawers();
                        break;
                    case R.id.drawer_menu_logout:
                        Toast.makeText(MainActivity.this , "logout" ,Toast.LENGTH_LONG).show();
                        mDrawerLayout.closeDrawers();
                        break;
                }
                return true;
            }
        });
    }
}
