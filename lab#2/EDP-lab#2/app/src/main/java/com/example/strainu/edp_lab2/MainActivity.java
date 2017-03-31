package com.example.strainu.edp_lab2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.example.strainu.edp_lab2.OnSwipeTouchListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RelativeLayout content_layout = (RelativeLayout) findViewById(R.id.content_layout);

        content_layout.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            View root = findViewById(R.id.content_layout).getRootView();


            public void onSwipeTop(float diff) {
//                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
                Log.i("mytag", "top" + diff);
                int color = Color.TRANSPARENT;
                Drawable background = root.getBackground();
                if (background instanceof ColorDrawable) {
                    color = ((ColorDrawable) background).getColor();
                    color += diff * diff;
                    root.setBackgroundColor(color);
                }
            }

            public void onSwipeRight(float diff) {
//                Toast.makeText(MainActivity.this, "right", Toast.LENGTH_SHORT).show();
                Log.i("mytag", "right" + diff);
                int color = Color.TRANSPARENT;
                Drawable background = root.getBackground();
                if (background instanceof ColorDrawable) {
                    color = ((ColorDrawable) background).getColor();
                    color += diff * diff * diff;
                    root.setBackgroundColor(color);
                }
            }

            public void onSwipeLeft(float diff) {
//                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
                Log.i("mytag", "left" + diff);
                int color = Color.TRANSPARENT;
                Drawable background = root.getBackground();
                if (background instanceof ColorDrawable) {
                    color = ((ColorDrawable) background).getColor();
                    color += diff * diff * diff;
                    root.setBackgroundColor(color);
                }
            }

            public void onSwipeBottom(float diff) {

//                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
                Log.i("mytag", "bottom" + diff);
                int color = Color.TRANSPARENT;
                Drawable background = root.getBackground();
                if (background instanceof ColorDrawable) {
                    color = ((ColorDrawable) background).getColor();
                    color += diff * diff;
                    root.setBackgroundColor(color);
                }
            }

        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Alert Dialog in Android, link below")
                        .setMessage("http://stackoverflow.com/questions/2115758/how-do-i-display-an-alert-dialog-on-android")
                        .setCancelable(false)
                        .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Whatever...
                            }
                        }).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onKeyDown(int keycode, KeyEvent e) {

        View root = findViewById(R.id.content_layout).getRootView();
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        switch(keycode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                Toast.makeText(MainActivity.this, "Volume Up", Toast.LENGTH_SHORT).show();
                break;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                root.setBackgroundColor(color);
                break;
        }

        return super.onKeyDown(keycode, e);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
        View root = findViewById(R.id.content_layout).getRootView();

        switch (id) {
            case R.id.action_toast:
                Toast.makeText(MainActivity.this, getString(R.string.action_toast), Toast.LENGTH_LONG).show();
                break;
            case R.id.action_change_bg:
                Random rnd = new Random();
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                root.setBackgroundColor(color);
                break;
            case R.id.action_default_bg:
                root.setBackgroundColor(Color.WHITE);
                break;

        }

        return super.onOptionsItemSelected(item);
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
