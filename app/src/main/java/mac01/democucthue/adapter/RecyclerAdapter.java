package mac01.democucthue.adapter;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import mac01.democucthue.R;
import mac01.democucthue.model.LichBoTriXe;

/**
 * Created by mac01 on 5/31/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    public TextView txtThoiGian;
    public TextView txtNguoiChuTri;
    public TextView txtNoiDung;
    public TextView txtPhanCong;
    public TextView txtThanhPhan;
    public TextView txtLoaiXe;
    public TextView txtDiaDiem;
    public TextView txtTinhTrang;

//    private String[] titles = {"Chapter One",
//            "Chapter Two",
//            "Chapter Three",
//            "Chapter Four",
//            "Chapter Five",
//            "Chapter Six",
//            "Chapter Seven",
//            "Chapter Eight"};
//
//    private String[] details = {"Item one details",
//            "Item two details", "Item three details",
//            "Item four details", "Item file details",
//            "Item six details", "Item seven details",
//            "Item eight details"};
//
//    private int[] images = { R.drawable.ic_menu_gallery,
//            R.drawable.ic_menu_gallery,
//            R.drawable.ic_menu_gallery,
//            R.drawable.ic_menu_gallery,
//            R.drawable.ic_menu_gallery,
//            R.drawable.ic_menu_gallery,
//            R.drawable.ic_menu_gallery,
//            R.drawable.ic_menu_gallery };

    public List<LichBoTriXe> lichBoTriXes = new ArrayList<>();

    private Context mContext;

    public RecyclerAdapter(Context context) {
        lichBoTriXes.add(new LichBoTriXe("12h","UBND Quan 3","Di cong tac Long Thanh","Dong chi Nghia","Pho Chu Tich, Uy Vien","4 cho","110 Nguyen Hoang, Quan 2, Thanh Pho Ho Chi Minh","Dang xu ly"));
        lichBoTriXes.add(new LichBoTriXe("1h","UBND Quan 4","Di cong tac Long Thanh","Dong chi Nghia","Pho Chu Tich, Uy Vien","4 cho","110 Nguyen Hoang, Quan 2, Thanh Pho Ho Chi Minh","Dang xu ly"));
        lichBoTriXes.add(new LichBoTriXe("2h","UBND Quan 5","Di cong tac Long Thanh","Dong chi Nghia","Pho Chu Tich, Uy Vien","4 cho","110 Nguyen Hoang, Quan 2, Thanh Pho Ho Chi Minh","Dang xu ly"));
        this.mContext = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;

        public ViewHolder(View itemView) {
            super(itemView);
            txtThoiGian = (TextView) itemView.findViewById(R.id.txtThoiGian);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.content_lct_ngay, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        LichBoTriXe lichBoTriXe = lichBoTriXes.get(i);
        txtThoiGian.setText(lichBoTriXe.getThoiGian());
//        viewHolder.itemTitle.setText(titles[i]);
//        viewHolder.itemDetail.setText(details[i]);
//        viewHolder.itemImage.setImageResource(images[i]);

    }

    @Override
    public int getItemCount() {
        Log.d("asd", "getItemCount: "+lichBoTriXes.size());
        return lichBoTriXes.size();
    }
}
