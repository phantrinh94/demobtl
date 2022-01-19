package com.example.bkap.android.btl.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bkap.android.btl.DATABASE.DBHelper;
import com.example.bkap.android.btl.DTO.TinTuc;

import java.util.ArrayList;
import java.util.List;

public class ImplTinTucDAO implements ITinTucDAO {
    private Context context;
    private SQLiteDatabase mDB;

    public ImplTinTucDAO(Context context) {
        this.context = context;
        DBHelper helper = new DBHelper(context);
        mDB = helper.getWritableDatabase();
    }

    @Override
    public List<TinTuc> selectAll() {
        String sql = "SELECT * FROM TinTuc";
        Cursor cs = mDB.rawQuery(sql, null);

        List<TinTuc> list = new ArrayList<>();
        while (cs.moveToNext()) {
            int idxID = cs.getColumnIndex("id");
            int id = cs.getInt(idxID);
            int idxNguoiDang = cs.getColumnIndex("nguoidang");
            String nguoiDang = cs.getString(idxNguoiDang);
            int idxSDT = cs.getColumnIndex("sdt");
            String SDT = cs.getString(idxSDT);
            int idxNoiDung = cs.getColumnIndex("noidung");
            String noiDung = cs.getString(idxNoiDung);
            int idxDiaChi = cs.getColumnIndex("diachi");
            String diaChi = cs.getString(idxDiaChi);

            TinTuc tinTuc = new TinTuc(id, nguoiDang, SDT, noiDung, diaChi);
            list.add(tinTuc);
        }
        return list;
    }

    @Override
    public TinTuc selectById(int id) {
        return null;
    }

    @Override
    public boolean insert(TinTuc s) {
        ContentValues cv = new ContentValues();
        cv.put("nguoidang", s.getmNguoiDang());
        cv.put("sdt", s.getmSDT());
        cv.put("noidung", s.getmNoiDung());
        cv.put("diachi", s.getmDiaChi());

        long newID = mDB.insert("TinTuc", null, cv);

        if (newID > 0) {
            return true; // thêm thành công
        } else {
            return false;
        }
    }

    @Override
    public boolean update(TinTuc s) {
        ContentValues cv = new ContentValues();
        cv.put("nguoidang", s.getmNguoiDang());
        cv.put("sdt", s.getmSDT());
        cv.put("noidung", s.getmNoiDung());
        cv.put("diachi", s.getmDiaChi());

        int row = mDB.update("TinTuc", cv, "id = ?", new String[]{String.valueOf(s.getmId())});

        if (row > 0) {
            return true; // thêm thành công
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        int row = mDB.delete("TinTuc", "id = ?", new String[]{String.valueOf(id)});

        if (row > 0) {
            return true; // cập nhật thành công
        } else {
            return false;
        }
    }

}
