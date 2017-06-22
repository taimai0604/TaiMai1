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
import android.view.View;
import android.widget.Button;

import mac01.democucthue.fragment.TieuChiThongKeFragment;

public class ThongKeActivity extends AppCompatActivity {
    public final String TAG = this.getClass().getName();
    FragmentManager manager;
    FragmentTransaction transaction;
    Fragment fragment = new TieuChiThongKeFragment();

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
        transaction.add(R.id.layoutTieuChiThongKe,fragment).commit();

        Button btnTieuChiThongKe = (Button) findViewById(R.id.btnTieuChiThongKe);
        btnTieuChiThongKe.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if (isShowFragment){
                    hideFragment();
                }else{
                    showFragment();
                }
                isShowFragment = !isShowFragment;
                Log.d(TAG, "onClick: tieu chi" + isShowFragment);
            }
        });
    }

    public void showFragment(){
        Log.d(TAG, "show " + isShowFragment);
        transaction = manager.beginTransaction();
        transaction.show(fragment).commit();
    }

    public void hideFragment(){
        Log.d(TAG, "hide " + isShowFragment);
        transaction = manager.beginTransaction();
        transaction.hide(fragment).commit();
    }
}
