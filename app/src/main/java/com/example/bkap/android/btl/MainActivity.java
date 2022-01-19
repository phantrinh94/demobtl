package com.example.bkap.android.btl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toolbar;

import com.example.bkap.android.btl.ADAPTER.GroupNewsAdapter;
import com.example.bkap.android.btl.DAO.IGroupNewsDAO;
import com.example.bkap.android.btl.DAO.ImplGroupNewsDAO;
import com.example.bkap.android.btl.DTO.GroupNews;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<GroupNews> mListGr;
    private GridView gridView;
    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        loadGroupNews();
        setToolbar();

    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_back_24);
    }


    private void loadGroupNews() {
        IGroupNewsDAO iGroupNewsDAO = new ImplGroupNewsDAO(this);
        mListGr = iGroupNewsDAO.selectAllG();
        GroupNewsAdapter adapter = new GroupNewsAdapter(this, R.layout.item_title_news_layout, mListGr);
        gridView.setAdapter(adapter);
    }

    private void initView() {
        gridView = findViewById(R.id.grv_GroupNews);
        toolbar = findViewById(R.id.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.menu_dangTin:
                Intent intent = new Intent(MainActivity.this, PostNewActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_xemTin:
                Intent i = new Intent(MainActivity.this, NewsActivity.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}