package mac01.democucthue;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.miguelcatalan.materialsearchview.MaterialSearchView;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;

import java.util.ArrayList;
import java.util.List;

import mac01.democucthue.holder.IconTreeItemHolder;
import mac01.democucthue.holder.SelectableHeaderHolder;
import mac01.democucthue.model.NguoiNhan;

public class ChiTietVanBanDenActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, AdapterView.OnItemSelectedListener {
    private MaterialSearchView searchView;

    private static final String NAME = "Very long name for folder";
    private AndroidTreeView tView;

    private Toast toast;

    private RadioGroup rg;
    private LinearLayout layoutNguoiPhongBan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_van_ban_den);
        // search
        drawUI();

        // tree
        TreeNode root = TreeNode.root();

        TreeNode s1 = new TreeNode(new IconTreeItemHolder.IconTreeItem("Tai, Mai Huu Tai")).setViewHolder(new SelectableHeaderHolder(getApplicationContext()));
        TreeNode s2 = new TreeNode(new IconTreeItemHolder.IconTreeItem("Nghia, Vu Hoang Nghia")).setViewHolder(new SelectableHeaderHolder(getApplicationContext()));

        fillFolder(s1);
        fillFolder(s2);

        root.addChildren(s1, s2);

        tView = new AndroidTreeView(getApplicationContext(), root);
        tView.setDefaultAnimation(true);
        tView.setUse2dScroll(true);
        tView.setDefaultContainerStyle(R.style.TreeNodeStyleCustom);
        LinearLayout placeHolder = (LinearLayout) findViewById(R.id.container);
        placeHolder.addView(tView.getView());

//        tView.expandAll();

        if (savedInstanceState != null) {
            String state = savedInstanceState.getString("tState");
            if (!TextUtils.isEmpty(state)) {
                tView.restoreState(state);
            }
        }

        Button btnChuyenToi = (Button) findViewById(R.id.btnChuyenToi);
        Button btnTraLai = (Button) findViewById(R.id.btnTraLai);

        btnChuyenToi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(ChiTietVanBanDenActivity.this)
                        .items(R.array.chuyen_toi)
                        .backgroundColor(Color.WHITE)
                        .itemsColor(Color.BLACK)
                        .itemsCallback(new MaterialDialog.ListCallback() {
                            @Override
                            public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                                switch (which) {
                                    case 0:
                                        showDialogVanPhong();
                                        break;
                                    case 1:
                                        showDialogBanTT();
                                        break;
                                    case 2:
                                        showDialogLanhDaoPhong();
                                        break;
                                }
                            }
                        })
                        .show();
            }
        });

        btnTraLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogTraLai();
            }
        });
    }

    private void showDialogTraLai(){
        Dialog dialog = new MaterialDialog.Builder(this)
                .title(getResources().getString(R.string.tra_lai).toUpperCase())
                .backgroundColor(Color.parseColor("#006c9b"))
                .customView(R.layout.dialog_tra_lai, true)
                .positiveText("Chuyen")
                .positiveColor(Color.WHITE)
                .negativeText("Huy")
                .negativeColor(Color.WHITE)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        RadioButton btn = (RadioButton) dialog.findViewById(rg.getCheckedRadioButtonId());
                        showToast(btn.getText().toString() + " --- ");
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

    private void showDialogVanPhong() {
        Dialog dialog = new MaterialDialog.Builder(this)
                .title(getResources().getString(R.string.chuyen_van_phong))
                .backgroundColor(Color.parseColor("#006c9b"))
                .customView(R.layout.dialog_chuyen_van_phong, true)
                .positiveText("Chuyen")
                .positiveColor(Color.WHITE)
                .negativeText("Huy")
                .negativeColor(Color.WHITE)
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        layoutNguoiPhongBan.removeAllViews();
                    }
                })
                .show();

        List<NguoiNhan> list = new ArrayList<>();
        NguoiNhan nn1 = new NguoiNhan(301, "Vu Hoang Nghia", "Truong Ban");
        NguoiNhan nn2 = new NguoiNhan(302, "Mai Huu Tai", "Pho Ban");

        list.add(nn1);
        list.add(nn2);

        layoutNguoiPhongBan = (LinearLayout) dialog.findViewById(R.id.layoutNguoiPhongBan);
        // Spinner Drop down elements
        List<String> names = new ArrayList<String>();
        for (NguoiNhan nguoi : list) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setId(nguoi.getId());
            checkBox.setText(nguoi.getName() + " - " + nguoi.getPosition());
            layoutNguoiPhongBan.addView(checkBox);

            names.add(nguoi.getName());
        }

        // spinner
        // Spinner element
        Spinner spinner = (Spinner) dialog.findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, names);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    private void showDialogBanTT() {
        Dialog dialog = new MaterialDialog.Builder(this)
                .title(getResources().getString(R.string.chuyen_ban_tt))
                .backgroundColor(Color.parseColor("#006c9b"))
                .customView(R.layout.dialog_chuyen_ban_tt, true)
                .positiveText("Chuyen")
                .positiveColor(Color.WHITE)
                .negativeText("Huy")
                .negativeColor(Color.WHITE)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        RadioButton btn = (RadioButton) dialog.findViewById(rg.getCheckedRadioButtonId());
                        showToast(btn.getText().toString() + " --- ");
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

    private void showDialogLanhDaoPhong() {
        Dialog dialog = new MaterialDialog.Builder(this)
                .title(getResources().getString(R.string.chuyen_lanh_dao_phong))
                .backgroundColor(Color.parseColor("#006c9b"))
                .customView(R.layout.dialog_chuyen_lanh_dao, true)
                .positiveText("Chuyen")
                .positiveColor(Color.WHITE)
                .negativeText("Huy")
                .negativeColor(Color.WHITE)
                .show();
        LinearLayout layoutNguoiNhan = (LinearLayout) dialog.findViewById(R.id.layoutNguoiNhan);
        CheckBox checkBox = new CheckBox(this);
        checkBox.setId(223);
        checkBox.setText("BAN DAN CHU - PHAP LUAT (DC-PL)");
        CheckBox checkBox1 = new CheckBox(this);
        checkBox1.setId(224);
        checkBox1.setText("BAN PHONG TRAO");

        layoutNguoiNhan.addView(checkBox);
        checkBox.setOnCheckedChangeListener(this);
        checkBox1.setOnCheckedChangeListener(this);

        layoutNguoiNhan.addView(checkBox1);

    }

    private void showDialogDanhSachNguoiTheoPhongBan(String nameTitle, List<NguoiNhan> list) {

        Dialog dialog = new MaterialDialog.Builder(this)
                .title(nameTitle)
                .backgroundColor(Color.parseColor("#006c9b"))
                .customView(R.layout.dialog_nguoi_nhan, true)
                .positiveText("Dong y")
                .positiveColor(Color.WHITE)
                .negativeText("Huy")
                .negativeColor(Color.WHITE)
                .onAny(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        layoutNguoiPhongBan.removeAllViews();
                    }
                })
                .show();
        layoutNguoiPhongBan = (LinearLayout) dialog.findViewById(R.id.layoutNguoiPhongBan);
        // Spinner Drop down elements
        List<String> names = new ArrayList<String>();
        for (NguoiNhan nguoi : list) {
            CheckBox checkBox = new CheckBox(this);
            checkBox.setId(nguoi.getId());
            checkBox.setText(nguoi.getName() + " - " + nguoi.getPosition());
            layoutNguoiPhongBan.addView(checkBox);

            names.add(nguoi.getName());
        }

        // spinner
        // Spinner element
        Spinner spinner = (Spinner) dialog.findViewById(R.id.spinner);

        // Spinner click listener
        spinner.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, names);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }

    private void fillFolder(TreeNode folder) {
        TreeNode currentNode = folder;
        for (int i = 0; i < 10; i++) {
            TreeNode file = new TreeNode(new IconTreeItemHolder.IconTreeItem(NAME)).setViewHolder(new SelectableHeaderHolder(getApplicationContext()));
            currentNode.addChild(file);
            currentNode = file;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MaterialSearchView.REQUEST_VOICE && resultCode == RESULT_OK) {
            ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (matches != null && matches.size() > 0) {
                String searchWrd = matches.get(0);
                if (!TextUtils.isEmpty(searchWrd)) {
                    searchView.setQuery(searchWrd, false);
                }
            }

            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void drawUI() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("VĂN BẢN ĐẾN");
        toolbar.setNavigationIcon(R.drawable.ic_home);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        searchView = (MaterialSearchView) findViewById(R.id.search_view);
        searchView.setVoiceSearch(false);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
//        searchView.setEllipsize(true);
        searchView.setHint("Tìm kiếm");
//        searchView.setSuggestions(getResources().getStringArray(R.array.query_suggestions));
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(), query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

    }

    private void showToast(String message) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            // lay danh sach nguoi trong phong ban
            List<NguoiNhan> list = new ArrayList<>();
            if (buttonView.getId() == 223) {
                NguoiNhan nn1 = new NguoiNhan(301, "Vu Hoang Nghia", "Truong Ban");
                NguoiNhan nn2 = new NguoiNhan(302, "Mai Huu Tai", "Pho Ban");

                list.add(nn1);
                list.add(nn2);
            }
            showDialogDanhSachNguoiTheoPhongBan(buttonView.getText().toString(), list);

        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }
}
