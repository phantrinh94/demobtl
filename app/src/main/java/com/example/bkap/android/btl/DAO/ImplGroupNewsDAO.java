package com.example.bkap.android.btl.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bkap.android.btl.DATABASE.DBHelper;
import com.example.bkap.android.btl.DTO.GroupNews;
import com.example.bkap.android.btl.DTO.TinTuc;

import java.util.ArrayList;
import java.util.List;

public class ImplGroupNewsDAO implements IGroupNewsDAO{
    private Context context;
    private SQLiteDatabase mDB;

    public ImplGroupNewsDAO(Context context) {
        this.context = context;
        DBHelper helper = new DBHelper(context);
        mDB = helper.getWritableDatabase();
    }

    @Override
    public List<GroupNews> selectAllG() {
        String sql = "SELECT * FROM GroupNews";
        Cursor cs = mDB.rawQuery(sql,null);

        List<GroupNews> listG = new ArrayList<>();
        while (cs.moveToNext()){
            int idxID = cs.getColumnIndex("id");
            int id = cs.getInt(idxID);
            int idxHinhAnh = cs.getColumnIndex("hinhanh");
            String hinhAnh = cs.getString(idxHinhAnh);
            int idxTieuDe = cs.getColumnIndex("tieude");
            String tieuDe = cs.getString(idxTieuDe);
            int idxSoLuong = cs.getColumnIndex("soluong");
            int soLuong = cs.getInt(idxSoLuong);

            GroupNews grNews = new GroupNews(id,hinhAnh,tieuDe,soLuong);
            listG.add(grNews);
        }
        return listG;
    }

    @Override
    public GroupNews selectById(int id) {
        return null;
    }

    @Override
    public boolean insert(GroupNews s) {
        return false;
    }

    @Override
    public boolean update(GroupNews s) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
