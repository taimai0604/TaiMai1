package mac01.democucthue;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

import mac01.democucthue.adapter.CustomListAdapter;
import mac01.democucthue.model.DataModel;

public class VanBanDenActivity extends AppCompatActivity {
    private MaterialSearchView searchView;
    private ArrayList<DataModel> dataModels;
    private ListView listView;

    private CustomListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_van_ban_den);

        drawUI();

        listView = (ListView) findViewById(R.id.lv_van_ban_den);
        dataModels = new ArrayList<>();
        dataModels.add(new DataModel("2A","Bổ sung bằng tốt nghiệp"));
        dataModels.add(new DataModel("2B","Bổ sung bằng tốt nghiệp askdhaksjhd asdkjh asdkjhasd "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2C","Bổ sung bằng tốt nghiệp asjkd kjahsdk jhaksjdh akjshdqowieu oqiwuoiuaso diuasod iuqowi ueqoi uaosiduouwqoi "));
        dataModels.add(new DataModel("2D","Bổ sung bằng tốt nghiệp asdukasjhd kajhsdiqwud qiwuhd qiuwh iquwh  "));

        adapter= new CustomListAdapter(getApplicationContext(),dataModels);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                DataModel dataModel= dataModels.get(position);

                Snackbar.make(view, dataModel.getSoKiHieu()+"\n"+dataModel.getNoiDung(), Snackbar.LENGTH_LONG)
                        .setAction("No action", null).show();

                Intent intent = new Intent(getApplicationContext(),ChiTietVanBanDenActivity.class);
                startActivity(intent);
            }
        });
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

    public void drawUI(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("VĂN BẢN ĐẾN");
        toolbar.setNavigationIcon(R.drawable.ic_home);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
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
                Toast.makeText(getApplicationContext(),query,Toast.LENGTH_SHORT).show();
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
}
