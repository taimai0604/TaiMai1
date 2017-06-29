package mac01.democucthue;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v13.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mac01.democucthue.model.ModelDemoRest;
import mac01.democucthue.services.ControllerService;

public class DemoServiceActivity extends AppCompatActivity {
    Button btnGet;
    Button btnPost;
    Button btnGetById;
    Button btnDownload;
    EditText ed;
    EditText edUrlDownload;

    Context context = this;

    ControllerService communicator;
    private String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_service);

        btnGet = (Button) findViewById(R.id.btnGet);
        btnPost = (Button) findViewById(R.id.btnPost);
        btnGetById = (Button) findViewById(R.id.btnGetOne);
        btnDownload = (Button) findViewById(R.id.btnDownload);

        edUrlDownload = (EditText) findViewById(R.id.edUrlDownload);
        edUrlDownload.setText("/documents/156201/787401/1497599406311_FileExcel.xls/fcced0e7-3050-4b78-82e9-59c7aebf8845");
        ed = (EditText) findViewById(R.id.edDemoService);

        communicator = new ControllerService();

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                communicator.getAll(context);
            }
        });

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ModelDemoRest modelDemoRest = new ModelDemoRest("Tai Mai", "HCM");
                communicator.create(context, modelDemoRest);
            }
        });

        btnGetById.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = 1;
                communicator.getById(context, id);
            }
        });

        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ActivityCompat.requestPermissions((Activity) context,
//                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
//                        1);
                Log.d(TAG, "onClick:  checkSelfPermission " + ContextCompat.checkSelfPermission(context,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE));
                Log.d(TAG, "onClick: PackageManager.PERMISSION_GRANTED " + PackageManager.PERMISSION_GRANTED);
                Log.d(TAG, "onClick: PackageManager.PERMISSION_DENIED " + PackageManager.PERMISSION_DENIED);

                Log.d(TAG, "onClick: shouldShowRequestPermissionRationale " + ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE));

                if(ActivityCompat.shouldShowRequestPermissionRationale((Activity) context,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                    Toast.makeText(context, "not access", Toast.LENGTH_SHORT).show();
                }else{
                    String url = edUrlDownload.getText().toString();
                    communicator.downloadFile(context, url);
                }
            }
        });
        Log.d(TAG, "onClick:  checkSelfPermission " + ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE));
        if (ContextCompat.checkSelfPermission(context,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions((Activity) context,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    1);
        }

    }
}
