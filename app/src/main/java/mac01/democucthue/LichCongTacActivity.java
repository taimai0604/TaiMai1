package mac01.democucthue;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;

import mac01.democucthue.mac01.adapter.CustomListMenuLichCongTac;

public class LichCongTacActivity extends AppCompatActivity {

    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_cong_tac);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.activity_home_bar);

        // add list menu
        String[] dataListMenu = {"Lịch cơ quan theo ngày ","Lịch cơ quan theo tuần","Lịch bố trí xe theo ngày","Lịch bố trí xe theo tuần","Lịch cá nhân theo tuần"};
        listView = (ListView) findViewById(R.id.lvLichCongTac);
        listView.setAdapter(new CustomListMenuLichCongTac(this ,dataListMenu,null));

        //set style text view
        TextView tvLichCongTacTrongTuan = (TextView) findViewById(R.id.tvLichCoQuanTrongTuan);
        tvLichCongTacTrongTuan.setTypeface(null, Typeface.BOLD);
    }
}
