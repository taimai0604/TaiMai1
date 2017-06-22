package mac01.democucthue;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import io.realm.Realm;
import mac01.democucthue.mac01.adapter.CustomListMenuAdapter;
import mac01.democucthue.model.User;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ListView listMenu;
    Context context;

    Realm realm;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // add list menu
//        String[] dataListMenu = {"Văn bản đến","Văn bản đi","Lịch công tác","Tra cứu","Thống kê"};
//        listMenu = (ListView) findViewById(R.id.listMenu);
//        listMenu.setAdapter(new CustomListMenuAdapter(this,dataListMenu,null));

        //realm
        realm = Realm.getDefaultInstance();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.navVanBanDen) {
            Intent myIntent = new Intent(getApplicationContext(), VanBanDenActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.navVanBanDi) {
            //tam de dialog de test giao dien
            showDialogChuyenPhatHanh();
        } else if (id == R.id.navLichCongTac) {
            Intent myIntent = new Intent(getApplicationContext(), LichCongTacVer2Activity.class);
            startActivity(myIntent);
        } else if (id == R.id.navThongKe) {
            Intent myIntent = new Intent(getApplicationContext(), ThongKeActivity.class);
            startActivity(myIntent);
        } else if (id == R.id.navDangXuat) {
            realm.executeTransaction(new Realm.Transaction(){

                @Override
                public void execute(Realm realm) {
                    User user = realm.where(User.class).findFirst();
                    user.deleteFromRealm();
                }
            });
            Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(intent);
        } else if (id == R.id.navTraCuu) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showDialogChuyenPhatHanh() {
        Dialog dialog = new MaterialDialog.Builder(this)
                .title(getResources().getString(R.string.chuyen_phat_hanh))
                .titleColor(Color.WHITE)
                .backgroundColor(Color.parseColor("#006c9b"))
                .customView(R.layout.dialog_chuyen_phat_hanh, true)
                .positiveText("Chuyen")
                .positiveColor(Color.WHITE)
                .negativeText("Huy")
                .negativeColor(Color.WHITE)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        RadioButton btn = (RadioButton) dialog.findViewById(rg.getCheckedRadioButtonId());
                    }
                })
                .show();
        rg = (RadioGroup) dialog.findViewById(R.id.rgNguoiNhan);
        RadioButton rbtn = new RadioButton(this);
        rbtn.setId(123);
        rbtn.setChecked(true);
        rbtn.setText("Nguyen Van A");

        RadioButton rbtn1 = new RadioButton(this);
        rbtn1.setId(124);
        rbtn1.setText("Nguyen Van B");

        rg.addView(rbtn);
        rg.addView(rbtn1);


    }
}
