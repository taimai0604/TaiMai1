package mac01.democucthue.services;

import java.util.List;

import mac01.democucthue.constant.Constant;
import mac01.democucthue.constant.ConstantURL;
import mac01.democucthue.model.ModelDemoRest;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;


/**
 * Created by mac01 on 6/26/17.
 */

public interface IServiceRest {
    @GET(ConstantURL.URL_GET_ALL)
    Call<List<ModelDemoRest>> getAll();

    @POST(ConstantURL.URL_CREATE)
    Call<ModelDemoRest> create(@Body ModelDemoRest modelDemoRest);

    @GET(ConstantURL.URL_GET_BY_ID)
    Call<ModelDemoRest> getById(@Path("id") int id);

    @GET
    Call<ResponseBody> downloadFile(@Url String url);
}
