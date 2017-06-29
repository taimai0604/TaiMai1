package mac01.democucthue;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mac01.democucthue.fragment.TieuChiThongKeFragment;
import mac01.democucthue.model.ThongKeDemo;

public class ThongKeActivity extends AppCompatActivity {
    public final String TAG = this.getClass().getName();
    FragmentManager manager;
    FragmentTransaction transaction;
    Fragment fragment = new TieuChiThongKeFragment();

    private List<ThongKeDemo> list;

    private boolean isShowFragment = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("THỐNG KÊ");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setNavigationIcon(R.drawable.ic_home);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.layoutTieuChiThongKe, fragment).commit();

        Button btnTieuChiThongKe = (Button) findViewById(R.id.btnTieuChiThongKe);
        TableLayout table = (TableLayout) findViewById(R.id.tbThongKe);


        btnTieuChiThongKe.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (isShowFragment) {
                    hideFragment();
                } else {
                    showFragment();
                }
                isShowFragment = !isShowFragment;
                Log.d(TAG, "onClick: tieu chi" + isShowFragment);
            }
        });

        //
        list = new ArrayList<>();
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            list.add(new ThongKeDemo(i, "Van phong Uy Ban "+i, random.nextInt(2000), random.nextInt(2000), random.nextInt(2000), random.nextInt(2000)));
        }

        for (ThongKeDemo thongKe : list ) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            TextView tv1 = new TextView(this);
            tv1.setMinEms(4);
            tv1.setTextSize(12);
            tv1.setGravity(Gravity.CENTER);
            tv1.setText(thongKe.getstt()+"");

            TextView tv2 = new TextView(this);
            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 100, getResources().getDisplayMetrics());
            tv2.setWidth(width);
            tv2.setTextSize(12);
            tv2.setPadding(20,20,20,20);
            tv2.setGravity(Gravity.LEFT);
            tv2.setText(thongKe.getTen());

            TextView tv3 = new TextView(this);
            tv3.setGravity(Gravity.CENTER);
            tv3.setTextSize(10);
            tv3.setText(thongKe.getCxlTrongHan()+"");

            TextView tv4 = new TextView(this);
            tv4.setGravity(Gravity.CENTER);
            tv4.setTextSize(10);
            tv4.setText(thongKe.getCxlQuaHan()+"");

            TextView tv5 = new TextView(this);
            tv5.setGravity(Gravity.CENTER);
            tv5.setTextSize(10);
            tv5.setText(thongKe.getDxlTrongHan()+"");

            TextView tv6 = new TextView(this);
            tv6.setGravity(Gravity.CENTER);
            tv6.setTextSize(10);
            tv6.setText(thongKe.getDxlQuaHan()+"");

            row.addView(tv1);
            row.addView(tv2);
            row.addView(tv3);
            row.addView(tv4);
            row.addView(tv5);
            row.addView(tv6);

            table.addView(row);
        }
    }

    public void showFragment() {
        Log.d(TAG, "show " + isShowFragment);
        transaction = manager.beginTransaction();
        transaction.show(fragment).commit();
    }

    public void hideFragment() {
        Log.d(TAG, "hide " + isShowFragment);
        transaction = manager.beginTransaction();
        transaction.hide(fragment).commit();
    }
}
