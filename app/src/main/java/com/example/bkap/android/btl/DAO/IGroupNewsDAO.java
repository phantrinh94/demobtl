package com.example.bkap.android.btl.DAO;

import com.example.bkap.android.btl.DTO.GroupNews;
import com.example.bkap.android.btl.DTO.TinTuc;

import java.util.List;

public interface IGroupNewsDAO {
    public List<GroupNews> selectAllG();

    public GroupNews selectById(int id);

    public boolean insert(GroupNews s);

    public boolean update(GroupNews s);

    public boolean delete(int id);
}
