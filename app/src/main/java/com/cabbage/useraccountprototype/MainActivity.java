package com.cabbage.useraccountprototype;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.toolbar) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setUpAppBar();
        setUpDrawer();
    }

    private void setUpAppBar() {
//        if (mAppBarLayout != null && AndroidApiUtils.hasLollipop()) {
//            mAppBarLayout.setPadding(0, AndroidApiUtils.getStatusBarHeight(this), 0, 0);
//        }
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("");
        } else {
            throw new RuntimeException("Can not find toolbar");
        }
    }

    private void setUpDrawer() {
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .withTranslucentStatusBar(true)
                .addProfiles(
                        new ProfileDrawerItem().withName("John Doe").withEmail("J.Doe@gmail.com")
                ).withSelectionListEnabledForSingleProfile(false)
                .build();

        PrimaryDrawerItem userAccountItem = new PrimaryDrawerItem()
                .withIdentifier(0)
                .withName(R.string.drawer_menu_label_register)
                .withIcon(GoogleMaterial.Icon.gmd_people)
                .withSelectable(false);

        PrimaryDrawerItem placeholderItem = new PrimaryDrawerItem()
                .withIdentifier(1)
                .withName("Something")
                .withIcon(GoogleMaterial.Icon.gmd_traffic)
                .withSelectable(false);


        //create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withAccountHeader(headerResult)
                .withActivity(this)
                .withFullscreen(true)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        userAccountItem,
                        new DividerDrawerItem(),
                        placeholderItem
                )
                .withSelectedItem(-1)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem.getIdentifier() == 0) {
                            Toast.makeText(MainActivity.this, "Register", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                })
                .build();

        if (Build.VERSION.SDK_INT >= 19) {
            // Fuck yea!
            result.getDrawerLayout().setFitsSystemWindows(false);
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, true);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
}
