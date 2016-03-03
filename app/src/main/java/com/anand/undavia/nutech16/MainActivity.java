package com.anand.undavia.nutech16;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    String clubList[];
    DrawerLayout clubDrawerLayout;
    ListView clubDrawerList;
    ActionBar actionBar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    LinearLayout linearLayout;

    private static final int HOME = 0;
    private static final int CHEMOZALE = 1;
    private static final int CIVILCREED = 2;
    private static final int CODEOCRATS = 3;
    private static final int ECTRONICS = 4;
    private static final int EELUMINATI = 5;
    private static final int EUPHORIA = 6;
    private static final int IMANAGE = 7;
    private static final int MECHATRIX = 8;
    private static final int NOESIS = 9;
    private static final int ROBOTICS = 10;
    private static final int THINKIC = 11;
    private static final int WORKSHOPS = 12;
    private static final int SPONSERS = 13;
    private static final int CONTACTUS = 14;
    private static final int ABOUTUS = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clubList = getResources().getStringArray(R.array.clublist);
        clubDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        clubDrawerList = (ListView) findViewById(R.id.left_drawer_list);
        linearLayout = (LinearLayout) findViewById(R.id.left_drawer);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, clubDrawerLayout, R.string.DrawerClose, R.string.DrawerClose);
        clubDrawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        clubDrawerList.setAdapter(new ArrayAdapter<String>(this, R.layout.drawer_list_item, clubList));
        clubDrawerList.setOnItemClickListener(new MyDrawerListener());
        clubDrawerList.setItemChecked(0, true);

        loadFragment(0);
        //clubDrawerLayout.openDrawer(linearLayout);
    }

    private void loadFragment(int n)
    {
        Fragment frag;
        if (n == CHEMOZALE)
        {
            frag = new Chemozale();
        } else if (n == CODEOCRATS)
        {
            frag = new CodeOCrats();
        } else if (n == EUPHORIA)
        {
            frag = new Euphoria();
        } else if (n == ECTRONICS)
        {
            frag = new Ectronics();
        } else if (n == EELUMINATI)
        {
            frag = new Eelluminati();
        } else if (n == CIVILCREED)
        {
            frag = new CivilCreed();
        } else if (n == MECHATRIX)
        {
            frag = new Mechatrix();
        } else if (n == NOESIS)
        {
            frag = new Noesis();
        } else if (n == ROBOTICS)
        {
            frag = new Robotics();
        } else if (n == IMANAGE)
        {
            frag = new IManage();
        } else if (n == ABOUTUS)
        {
            frag = new AboutUs();
        } else if (n == WORKSHOPS)
        {
            frag = new WorkShops();
        } else if (n == SPONSERS)
        {
            frag = new Sponsers();

        } else if (n == CONTACTUS)
        {
            frag = new ContactUs();
        } else if (n == THINKIC)
        {
            frag = new ThinkIc();
        }
         else
        {
            frag = new HomeFragment();
        }

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, frag);
        fragmentTransaction.commit();
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState)
    {
        super.onPostCreate(savedInstanceState, persistentState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if (clubDrawerLayout.isDrawerOpen(linearLayout))
        {
            clubDrawerLayout.closeDrawer(linearLayout);

        } else
        {
            clubDrawerLayout.openDrawer(linearLayout);
        }
        return super.onOptionsItemSelected(item);
    }

    class MyDrawerListener implements ListView.OnItemClickListener
    {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            if (position == 0)
                setTitle(getResources().getString(R.string.app_name));
            else
            {
                setTitle(clubList[position]);
            }
            clubDrawerList.setItemChecked(position, true);
            loadFragment(position);
            clubDrawerLayout.closeDrawer(linearLayout);
        }
    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        System.exit(0);
    }

}
