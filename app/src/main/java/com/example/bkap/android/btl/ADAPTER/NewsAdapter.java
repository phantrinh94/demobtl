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

import com.example.bkap.android.btl.DTO.GroupNews;
import com.example.bkap.android.btl.DTO.TinTuc;
import com.example.bkap.android.btl.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class NewsAdapter extends ArrayAdapter<TinTuc> {
    private Context mContext;
    private int mLayout;
    private List<TinTuc> mListTT;
    public NewsAdapter(@NonNull Context context, int resource, @NonNull List<TinTuc> objects) {
        super(context, resource, objects);

        this.mContext = context;
        this.mLayout = resource;
        this.mListTT = objects;
    }
    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item = convertView;

        if (item == null) {
            item = LayoutInflater.from(mContext).inflate(mLayout, null);
        }

        TinTuc s = mListTT.get(position);
        TextView tvNamePost = item.findViewById(R.id.tv_namePost);
        TextView tvContentNews = item.findViewById(R.id.tv_contentNews);
        TextView tvAddress = item.findViewById(R.id.tv_address);

        tvNamePost.setText(s.getmNguoiDang());
        tvContentNews.setText(s.getmNoiDung());
        tvAddress.setText(s.getmDiaChi());

        return item;
    }

}
