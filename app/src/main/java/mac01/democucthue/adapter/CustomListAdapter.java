package mac01.democucthue.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import mac01.democucthue.R;
import mac01.democucthue.model.DataModel;

/**
 * Created by mac01 on 6/5/17.
 */

public class CustomListAdapter extends ArrayAdapter<DataModel>  {
    private Context context;
    private ArrayList<DataModel> dataSet;

    private String soKiHieu = "Số kí hiệu gốc : ";

    public CustomListAdapter(Context context, ArrayList<DataModel> data){
        super(context, R.layout.adapter_vb_den, data);
        this.context = context;
        this.dataSet = data;
    }
    // View lookup cache
    private static class ViewHolder {
        TextView txtSoHieu;
        TextView txtNoiDung;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        DataModel dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.adapter_vb_den, parent, false);
            viewHolder.txtSoHieu = (TextView) convertView.findViewById(R.id.txtSoHieu);
            viewHolder.txtNoiDung = (TextView) convertView.findViewById(R.id.txtNoiDung);

            result=convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        viewHolder.txtSoHieu.setText(soKiHieu + dataModel.getSoKiHieu());
        viewHolder.txtNoiDung.setText(dataModel.getNoiDung());
        return convertView;
    }
}
