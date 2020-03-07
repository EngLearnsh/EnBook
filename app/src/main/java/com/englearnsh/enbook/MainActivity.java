package com.englearnsh.enbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static int isExit = 0;
    private DrawerLayout mDrawerLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout swipeRefresh;
    private List<Book> bookList = new ArrayList<>();
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isExit = 0;

        // Create Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create DrawerLayout and ActionBar
        mDrawerLayout = findViewById(R.id.drawer_layout);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
        }

        // Create RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        BookAdapter adapter = new BookAdapter(bookList);
        recyclerView.setAdapter(adapter);

        // final create book list
        createBookList();

        swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.main_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refresh_bookList();
            }
        });

        // Alpha
        Toast.makeText(MainActivity.this, "Test Only", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.download:
                Intent down_intent = new Intent("android.intent.action.DOWN_START");
                startActivity(down_intent);
                break;
            case R.id.search_button:
                onSearchRequested();
                break;
            case R.id.feedback:
                Intent feed_intent = new Intent("android.intent.action.FEED_START");
                startActivity(feed_intent);
                break;
            case R.id.exit:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Exit")
                        .setMessage("Are you sure you want to exit?")
                        .setCancelable(true)
                        .setView(new EditText(this))
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
             default:
                 break;
        }
        return true;
    }

    public void createBookList() {
        Book grimm = new Book("Grimm's Fairy Tales", R.drawable.grimm_pic);
        bookList.add(grimm);
        Book andersen = new Book("Andersen's Fairy Tales", R.drawable.andersen_pic);
        bookList.add(andersen);
        Book taon = new Book("Thousand and one night", R.drawable.taon_pic);
        bookList.add(taon);
    }

    private void refresh_bookList() {
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

    // Handler which implements twice exit
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {
            isExit--;
            return false;
        }
    });

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK) {
            isExit++;
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if(isExit < 2) {
            //Toast.makeText(getApplicationContext(), "again", Toast.LENGTH_SHORT).show();
            Snackbar.make(findViewById(R.id.main_coordinator), R.string.double_exit,
                    Snackbar.LENGTH_SHORT)
                    .show();
            handler.sendEmptyMessageDelayed(0, 2000);
        } else {
            super.onBackPressed();
        }
    }
}

