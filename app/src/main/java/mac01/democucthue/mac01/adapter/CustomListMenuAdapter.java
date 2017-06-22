package mac01.democucthue.mac01.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import mac01.democucthue.LichCongTacActivity;
import mac01.democucthue.MainActivity;
import mac01.democucthue.R;
import mac01.democucthue.constant.Constant;

/**
 * Created by mac01 on 5/5/17.
 */

public class CustomListMenuAdapter extends BaseAdapter {
    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public CustomListMenuAdapter(MainActivity mainActivity, String[] prgmNameList, int[] prgmImages) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.content_item_menu, null);
        holder.tv=(TextView) rowView.findViewById(R.id.menu_twTitle);
//        holder.img=(ImageView) rowView.findViewById(R.id.imageView1);
        holder.tv.setText(result[position]);
//        holder.img.setImageResource(imageId[position]);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (position == Constant.VAN_BAN_DEN){
                    Toast.makeText(context, "You Clicked van ban den", Toast.LENGTH_SHORT).show();

                }else if (position == Constant.VAN_BAN_DI){
                    Toast.makeText(context, "You Clicked van ban di", Toast.LENGTH_SHORT).show();

                }else if (position == Constant.LICH_CONG_TAC){
                    Toast.makeText(context, "You Clicked lich cong tac", Toast.LENGTH_SHORT).show();
                    Intent myIntent = new Intent(getContext(), LichCongTacActivity.class);
                    getContext().startActivity(myIntent);
                }else if (position == Constant.TRA_CUU){
                    Toast.makeText(context, "You Clicked tra cuu", Toast.LENGTH_SHORT).show();

                }else if (position == Constant.THONG_KE){
                    Toast.makeText(context, "You Clicked thong ke", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return rowView;
    }

    public Context getContext() {
        return context;
    }
}
