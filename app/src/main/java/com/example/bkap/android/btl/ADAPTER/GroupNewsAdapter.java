package com.example.bkap.android.btl.ADAPTER;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.bkap.android.btl.DTO.GroupNews;
import com.example.bkap.android.btl.DTO.TinTuc;
import com.example.bkap.android.btl.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class GroupNewsAdapter extends ArrayAdapter<GroupNews> {
    private Context mContext;
    private int mLayout;
    private List<GroupNews> mListGNs;
    public GroupNewsAdapter(@NonNull Context context, int resource, @NonNull List<GroupNews> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.mLayout = resource;
        this.mListGNs = objects;
    }
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;

        if (item == null) {
            item = LayoutInflater.from(mContext).inflate(mLayout, null);
        }

        GroupNews s = mListGNs.get(position);
        ImageView imgGroupNews = item.findViewById(R.id.img_titleNews);
        TextView tvTitleGroup = item.findViewById(R.id.tv_titleNews);
        TextView tvCount = item.findViewById(R.id.tv_count);

        Glide.with(mContext).load(s.getgHinhAnh()).override(150,150).centerCrop().into(imgGroupNews);
        tvTitleGroup.setText(s.getgTieuDe());
        tvCount.setText("Số tin : " + s.getgSoLuong());

        return item;
    }
}
