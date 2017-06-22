package mac01.democucthue.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import mac01.democucthue.ChiTietVanBanDenActivity;
import mac01.democucthue.R;

public class TieuChiThongKeFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener, DatePickerDialog.OnDateSetListener {
    int day, month, year;
    int dayFinal, monthFinal, yearFinal;
    private TextView tvTuNgay, tvDenNgay;
    private boolean isTuNgay;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_tieu_chi_thong_ke, container, false);
        TextView tvKieuVanBan = (TextView) view.findViewById(R.id.tvKieuVanBan);
        TextView tvPhongBan = (TextView) view.findViewById(R.id.tvPhongBan);
        TextView tvChuyenVien = (TextView) view.findViewById(R.id.tvChuyenVien);
        TextView tvSoVanban = (TextView) view.findViewById(R.id.tvSoVanban);

        tvKieuVanBan.setOnClickListener(this);
        tvPhongBan.setOnClickListener(this);
        tvChuyenVien.setOnClickListener(this);
        tvSoVanban.setOnClickListener(this);

        // date
        tvTuNgay = (TextView) view.findViewById(R.id.tvTuNgay);
        tvDenNgay = (TextView) view.findViewById(R.id.tvDenNgay);

        Calendar calendar = Calendar.getInstance();
        day = calendar.get(Calendar.DAY_OF_MONTH);
        month = calendar.get(Calendar.MONTH);
        year = calendar.get(Calendar.YEAR);
        tvTuNgay.setText( day+"/"+ (month + 1) +"/"+year);
        tvTuNgay.setOnClickListener(this);

        tvDenNgay.setText( day+"/"+ (month + 1) +"/"+year);
        tvDenNgay.setOnClickListener(this);
        return view;
    }

//    public void setSpinnerAdapter(View view, List<String> datas, int idSpinner) {
//
//        Spinner spinner = (Spinner) view.findViewById(idSpinner);
//        // Spinner click listener
//        spinner.setOnItemSelectedListener(this);
//
//
//        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(view.getContext(), R.layout.spinner_item, datas);
//
//        // Drop down layout style - list view with radio button
//        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // attaching data adapter to spinner
//        spinner.setAdapter(dataAdapter);
//    }

    public void showDialogChoose(final View v, List<String> datas, String titleName){
        new MaterialDialog.Builder(v.getContext())
                .title(titleName)
                .items(datas)
                .backgroundColor(Color.WHITE)
                .itemsColor(Color.BLACK)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
                        TextView tv = (TextView) v;
                        tv.setText(text);
                    }
                })
                .show();
    }

    public void showDialogDatePicker(View v) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(),this,year,month,day);
        datePickerDialog.show();
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

    @Override
    public void onClick(final View v) {
        List<String> list = new ArrayList<>();
        switch (v.getId()) {
            case R.id.tvKieuVanBan:
                list.add(getResources().getString(R.string.van_ban_den));
                list.add(getResources().getString(R.string.van_ban_di));
                showDialogChoose(v,list,"KIỂU VĂN BẢN");
                break;
            case R.id.tvPhongBan:
                list.add("Van phong");
                list.add("Tat cac phong ban");
                showDialogChoose(v,list,"PHÒNG BAN");
                break;
            case R.id.tvChuyenVien:
                showDialogChoose(v,list,"CHUYÊN VIÊN");
                break;
            case R.id.tvSoVanban:
                showDialogChoose(v,list,"SỔ VĂN BẢN");
                break;
            case R.id.tvTuNgay:
                isTuNgay = true;
                showDialogDatePicker(v);
                break;
            case R.id.tvDenNgay:
                isTuNgay = false;
                showDialogDatePicker(v);
                break;
        }
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        if(isTuNgay){
            tvTuNgay.setText( dayOfMonth+"/"+ (month + 1) +"/"+year);
        }else{
            tvDenNgay.setText( dayOfMonth+"/"+ (month + 1) +"/"+year);
        }
    }
}
