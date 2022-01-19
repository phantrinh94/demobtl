package com.example.bkap.android.btl.DATABASE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "adsonline.sqlite";
    private static final int DATABASE_VERSION = 1;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TinTuc (\n" +
                "    id        INTEGER       PRIMARY KEY AUTOINCREMENT,\n" +
                "    nguoidang VARCHAR (64)  NOT NULL,\n" +
                "    sdt       VARCHAR (13)  NOT NULL,\n" +
                "    noidung   VARCHAR (128) NOT NULL,\n" +
                "    diachi    VARCHAR (36)  NOT NULL\n" +
                ");";

        db.execSQL(sql);

        sql = "INSERT INTO TinTuc( nguoidang, sdt, noidung,diachi) VALUES ('Nguyễn Văn A', '0334405361', 'Cần bán đất nền','Mỹ Đình,Nam Từ Liêm,Hà Nội');";
        db.execSQL(sql);
        sql = "INSERT INTO TinTuc( nguoidang, sdt, noidung,diachi) VALUES ('Nguyễn Văn B', '0334405361', 'Cần bán đất nền','Mỹ Đình,Nam Từ Liêm,Hà Nội');";
        db.execSQL(sql);
        sql = "INSERT INTO TinTuc( nguoidang, sdt, noidung,diachi) VALUES ('Nguyễn Văn C', '0334405361', 'Cần bán đất nền','Mỹ Đình,Nam Từ Liêm,Hà Nội');";
        db.execSQL(sql);
        sql = "INSERT INTO TinTuc( nguoidang, sdt, noidung,diachi) VALUES ('Nguyễn Văn D', '0334405361', 'Cần bán đất nền','Mỹ Đình,Nam Từ Liêm,Hà Nội');";
        db.execSQL(sql);

        sql = "CREATE TABLE GroupNews (\n" +
                "    id      INTEGER      PRIMARY KEY AUTOINCREMENT,\n" +
                "    hinhanh VARCHAR      NOT NULL,\n" +
                "    tieude  VARCHAR (36) NOT NULL,\n" +
                "    soluong INTEGER (9)  CHECK (soluong >= 0) \n" +
                "                         NOT NULL\n" +
                ");";
        db.execSQL(sql);

        sql = "INSERT INTO GroupNews( hinhanh, tieude, soluong) VALUES ('https://i.9mobi.vn/cf/images/2015/03/nkk/hinh-dep-12.jpg','Bất động sản',1100)";
        db.execSQL(sql);
        sql = "INSERT INTO GroupNews( hinhanh, tieude, soluong) VALUES ('https://i.9mobi.vn/cf/images/2015/03/nkk/hinh-dep-19.jpg','Đồ dân dụng',1300)";
        db.execSQL(sql);
        sql = "INSERT INTO GroupNews( hinhanh, tieude, soluong) VALUES ('https://khoahocphattrien.vn/Images/Uploaded/Share/2016/12/20/Nhung-buc-anh-dep-nhat-2016-chia-se-tren-Flickr_4.jpg','Đồ điện tử',1000)";
        db.execSQL(sql);
        sql = "INSERT INTO GroupNews( hinhanh, tieude, soluong) VALUES ('https://photographer.vn/wp-content/uploads/2016/06/nhung-bi-quyet-de-co-nhung-buc-anh-dep5.jpg','Xe Cộ',1600)";
        db.execSQL(sql);
        sql = "INSERT INTO GroupNews( hinhanh, tieude, soluong) VALUES ('https://aphoto.vn/wp-content/uploads/2019/01/anhdep6.jpg','Hàng Không',1650)";
        db.execSQL(sql);
        sql = "INSERT INTO GroupNews( hinhanh, tieude, soluong) VALUES ('https://fusionsuitesvungtau.com.vn/wp-content/uploads/2021/09/tai-hinh-anh-nen-phong-canh-dep-4.jpg','Quân Sự',600)";
        db.execSQL(sql);
        sql = "INSERT INTO GroupNews( hinhanh, tieude, soluong) VALUES ('https://1.bigdata-vn.com/wp-content/uploads/2021/10/Anh-dep-mua-dong.jpg','Ẩm thực',1700)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
