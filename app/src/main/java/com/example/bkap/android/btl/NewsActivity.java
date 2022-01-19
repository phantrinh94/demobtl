package com.example.bkap.android.btl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.bkap.android.btl.ADAPTER.NewsAdapter;
import com.example.bkap.android.btl.DAO.ITinTucDAO;
import com.example.bkap.android.btl.DAO.ImplTinTucDAO;
import com.example.bkap.android.btl.DTO.TinTuc;

import java.util.List;

public class NewsActivity extends AppCompatActivity {
    private ListView listView;
    private List<TinTuc> listTinTuc;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
        setToolbar();
        loadNews();
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_back_24);
    }

    private void loadNews() {
        ITinTucDAO iTinTucDAO = new ImplTinTucDAO(this);
        listTinTuc = iTinTucDAO.selectAll();
        NewsAdapter adapter = new NewsAdapter(this, R.layout.item_news_layout, listTinTuc);
        listView.setAdapter(adapter);
    }

    private void initView() {
        listView = findViewById(R.id.listView);
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
                Intent intent = new Intent(NewsActivity.this, PostNewActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.menu_xemTin:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}