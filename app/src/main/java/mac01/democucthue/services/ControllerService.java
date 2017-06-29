package mac01.democucthue.services;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v13.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Random;

import mac01.democucthue.R;
import mac01.democucthue.constant.ConstantURL;
import mac01.democucthue.model.ModelDemoRest;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mac01 on 6/26/17.
 */

public class ControllerService {
    private String TAG = this.getClass().getName();
    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
    Retrofit retrofit = new Retrofit.Builder()
            .client(httpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ConstantURL.SERVER_URL)
            .build();

    IServiceRest service = retrofit.create(IServiceRest.class);

    public void create(final Context context, ModelDemoRest modelDemoRest) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ConstantURL.SERVER_URL)
                .build();

        IServiceRest service = retrofit.create(IServiceRest.class);

        Call<ModelDemoRest> call = service.create(modelDemoRest);

        call.enqueue(new Callback<ModelDemoRest>() {
            @Override
            public void onResponse(Call<ModelDemoRest> call, Response<ModelDemoRest> response) {
                String content = "";
                content += response.body().getId() + "\r\n";
                content += response.body().getName() + "\r\n";
                content += response.body().getCity() + "\r\n";
                EditText ed = (EditText) ((Activity) context).getWindow().getDecorView().findViewById(R.id.edDemoService);
                ed.setText(content);
            }

            @Override
            public void onFailure(Call<ModelDemoRest> call, Throwable t) {
            }
        });
    }

    public void getAll(final Context context) {

        Call<List<ModelDemoRest>> call = service.getAll();

        call.enqueue(new Callback<List<ModelDemoRest>>() {
            @Override
            public void onResponse(Call<List<ModelDemoRest>> call, Response<List<ModelDemoRest>> response) {
                Log.d(TAG, "onResponse: success");
                List<ModelDemoRest> list = response.body();
                String content = "";
                for (ModelDemoRest model : list) {
                    content += model.getId() + "\r\n";
                    content += model.getName() + "\r\n";
                    content += model.getCity() + "\r\n";
                }

                EditText ed = (EditText) ((Activity) context).getWindow().getDecorView().findViewById(R.id.edDemoService);
                ed.setText(content);
            }

            @Override
            public void onFailure(Call<List<ModelDemoRest>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

    public void getById(final Context context, int id) {
        Call<ModelDemoRest> call = service.getById(id);

        call.enqueue(new Callback<ModelDemoRest>() {
            @Override
            public void onResponse(Call<ModelDemoRest> call, Response<ModelDemoRest> response) {
                String content = "";
                content += response.body().getId() + "\r\n";
                content += response.body().getName() + "\r\n";
                content += response.body().getCity() + "\r\n";
                EditText ed = (EditText) ((Activity) context).getWindow().getDecorView().findViewById(R.id.edDemoService);
                ed.setText(content);
            }

            @Override
            public void onFailure(Call<ModelDemoRest> call, Throwable t) {
            }
        });
    }

    public void downloadFile(final Context context, String url) {
//        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
//        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
//
//        httpClient.addInterceptor(logging);



        //test authentication
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
        okHttpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();

                Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                        Credentials.basic("dtthong.btdkt", "123"));

                Request newRequest = builder.build();
                return chain.proceed(newRequest);
            }
        }).build();

        okHttpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient.build())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ConstantURL.SERVER_DOWNLOAD_URL)
                .build();


        IServiceRest service = retrofit.create(IServiceRest.class);

        Call<ResponseBody> call = service.downloadFile(url);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                writeResponseBodyToDisk(context,response.body());
                Toast.makeText(context, "download thanh cong", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //test moi----------------



    }

    private boolean writeResponseBodyToDisk(Context context, ResponseBody body) {
        try {
            Random random = new Random();
            // todo change the file location/name according to your needs
            File futureStudioIconFile = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "test"+random.nextInt(100)+".pdf");
            Log.d(TAG, "writeResponseBodyToDisk: "+ futureStudioIconFile.getPath());
            InputStream inputStream = null;

            try {
                inputStream = body.byteStream();
                FileUtils.copyInputStreamToFile(inputStream,futureStudioIconFile);

                return true;
            } catch (Exception e) {
                Log.d(TAG, "Exception: " +e.getMessage());
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "writeResponseBodyToDisk: " +e.getMessage());
            return false;
        }
    }
}
