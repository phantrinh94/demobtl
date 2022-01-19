package com.example.bkap.android.btl.DAO;

import com.example.bkap.android.btl.DTO.TinTuc;

import java.util.List;

public interface ITinTucDAO {
    public List<TinTuc> selectAll();

    public TinTuc selectById(int id);

    public boolean insert(TinTuc s);

    public boolean update(TinTuc s);

    public boolean delete(int id);
}
