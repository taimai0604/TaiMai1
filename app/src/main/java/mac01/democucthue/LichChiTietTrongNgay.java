package mac01.democucthue;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import mac01.democucthue.adapter.RecyclerAdapter;
import mac01.democucthue.controller.FloatingButtonController;

public class LichChiTietTrongNgay extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lich_chi_tiet_trong_ngay);

        recyclerView =
                (RecyclerView) findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(this);
        recyclerView.setAdapter(adapter);


        FloatingButtonController buttonController = new FloatingButtonController(this);
        buttonController.setOnClickListener();
    }

}
