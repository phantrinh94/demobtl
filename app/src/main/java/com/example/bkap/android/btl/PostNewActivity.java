package com.example.bkap.android.btl;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bkap.android.btl.DAO.ITinTucDAO;
import com.example.bkap.android.btl.DAO.ImplTinTucDAO;
import com.example.bkap.android.btl.DTO.TinTuc;

public class PostNewActivity extends AppCompatActivity {
    private EditText edtFullName;
    private EditText edtPhoneNumber;
    private EditText edtContent;
    private EditText edtAddress;
    private Button btnPostNews;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_new);
        initView();
        addNews();
        setToolbar();
    }

    private void setToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.drawable.ic_back_24);
    }

    /**
     * Ánh xạ View
     */
    private void initView() {
        edtFullName = findViewById(R.id.edt_fullName);
        edtPhoneNumber = findViewById(R.id.edt_phoneNumber);
        edtContent = findViewById(R.id.edt_content);
        edtAddress = findViewById(R.id.edt_addressPost);
        btnPostNews = findViewById(R.id.btn_postNew);
        toolbar = findViewById(R.id.toolbar);
    }

    /**
     * Thêm mới tin tức
     */
    public void addNews() {
        btnPostNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtFullName.getText().toString();
                String phone = edtPhoneNumber.getText().toString();
                String content = edtContent.getText().toString();
                String address = edtAddress.getText().toString();
                AlertDialog.Builder builder = new AlertDialog.Builder(PostNewActivity.this);
                if (name.isEmpty() || phone.isEmpty() || content.isEmpty() || address.isEmpty()) {
                    builder.setTitle("Đăng tin không thành công!");
                    builder.setMessage("Thông tin rao vặt không được để trống vui lòng xem lại.");
                    builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                } else {
                    TinTuc s = new TinTuc(name, phone, content, address);
                    ITinTucDAO sDAO = new ImplTinTucDAO(PostNewActivity.this);
                    boolean isOK = sDAO.insert(s);
                    if (isOK) {
                        builder.setTitle("Rao vặt online");
                        builder.setMessage("Tin rao vặt đã đăng thành công!");
                        builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                        //Set lại ô edittext về chuỗi rỗng
                        edtFullName.setText("");
                        edtPhoneNumber.setText("");
                        edtContent.setText("");
                        edtAddress.setText("");
                    } else {
                        builder.setTitle("Rao vặt online");
                        builder.setMessage("Tin rao vặt đã đăng không thành công!");
                        builder.setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                    }
                    builder.setCancelable(false);
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }


    /**
     * Khởi tạo menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    /**
     * Sự kiện click từng item menu
     */
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.menu_dangTin:

                break;
            case R.id.menu_xemTin:
                Intent intent = new Intent(PostNewActivity.this, NewsActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}