package mac01.democucthue.controller;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.clans.fab.FloatingActionButton;

import mac01.democucthue.LichChiTietTrongNgay;
import mac01.democucthue.LichCongTacVer2Activity;
import mac01.democucthue.R;

/**
 * Created by mac01 on 6/1/17.
 */

public class FloatingButtonController {
    private AppCompatActivity context;
    private FloatingActionButton fabLichCongTacCaNhanTheoNgay;
    private FloatingActionButton fabLichCongTacCaNhanTheoTuan;
    private FloatingActionButton fabLichBoTriXeTheoNgay;
    private FloatingActionButton fabLichBoTriXeTheoTuan;
    private FloatingActionButton fabLichBoTriCoQuanTheoNgay;
    private FloatingActionButton fabLichBoTriCoQuanTheoTuan;


    public FloatingButtonController(AppCompatActivity context){
        this.context = context;
        fabLichCongTacCaNhanTheoNgay = (FloatingActionButton) context.findViewById(R.id.fabLichCongTacCaNhanTheoNgay);
        fabLichCongTacCaNhanTheoTuan = (FloatingActionButton) context.findViewById(R.id.fabLichCongTacCaNhanTheoTuan);
        fabLichBoTriCoQuanTheoNgay = (FloatingActionButton) context.findViewById(R.id.fabLichCoQuanTheoNgay);
        fabLichBoTriCoQuanTheoTuan = (FloatingActionButton) context.findViewById(R.id.fabLichCoQuanTheoTuan);
        fabLichBoTriXeTheoNgay = (FloatingActionButton) context.findViewById(R.id.fabLichBoTriXeTrongNgay);
        fabLichBoTriXeTheoTuan = (FloatingActionButton) context.findViewById(R.id.fabLichBoTriTrongTuan);

    }

    public void setOnClickListener(){
        fabLichCongTacCaNhanTheoNgay.setOnClickListener(clickListener);
        fabLichCongTacCaNhanTheoTuan.setOnClickListener(clickListener);
        fabLichBoTriCoQuanTheoNgay.setOnClickListener(clickListener);
        fabLichBoTriCoQuanTheoTuan.setOnClickListener(clickListener);
        fabLichBoTriXeTheoNgay.setOnClickListener(clickListener);
        fabLichBoTriXeTheoTuan.setOnClickListener(clickListener);
    }

    public View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.fabLichCongTacCaNhanTheoNgay:
                    intent = new Intent(context.getApplicationContext(), LichChiTietTrongNgay.class);
                    break;
                case R.id.fabLichCongTacCaNhanTheoTuan:
                    intent = new Intent(context.getApplicationContext(), LichCongTacVer2Activity.class);
                    break;
                case R.id.fabLichCoQuanTheoNgay:
                    intent = new Intent(context.getApplicationContext(), LichChiTietTrongNgay.class);
                    break;
                case R.id.fabLichCoQuanTheoTuan:
                    intent = new Intent(context.getApplicationContext(), LichCongTacVer2Activity.class);
                    break;
                case R.id.fabLichBoTriXeTrongNgay:
                    intent = new Intent(context.getApplicationContext(), LichChiTietTrongNgay.class);
                    break;
                case R.id.fabLichBoTriTrongTuan:
                    intent = new Intent(context.getApplicationContext(), LichCongTacVer2Activity.class);
                    break;
            }
            context.startActivity(intent);
        }
    };
}
