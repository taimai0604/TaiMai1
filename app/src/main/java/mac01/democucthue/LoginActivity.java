package mac01.democucthue;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.ActionMenuItemView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;
import mac01.democucthue.model.User;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getName();

    private EditText edUsername;
    private EditText edPassworld;
    private Button btnLogin;


    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.activity_login_bar);

        btnLogin = (Button) findViewById(R.id.a_l_btnLogin);
        edUsername = (EditText) findViewById(R.id.a_l_edUsername);
        edPassworld = (EditText) findViewById(R.id.a_l_edPass);

        btnLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String username = edUsername.getText().toString().trim();
                final String passworld = edPassworld.getText().toString().trim();

                if(checkLogin(username, passworld)){
                    //add user
                    realm.executeTransaction(new Realm.Transaction(){

                        @Override
                        public void execute(Realm realm) {
                            User user = realm.createObject(User.class);
                            user.setUsername(username);
                            user.setPassworld(passworld);
                            user.setFullName(username + "-" +passworld);
                        }
                    });

                    Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(myIntent);
                }else{
                    edUsername.setText("");
                    edPassworld.setText("");
                    Toast.makeText(getApplicationContext(),"login fail",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //realm
//        Realm.init(this);  // da duoc cong trong ConfigActivity
        realm = Realm.getDefaultInstance();

//        basicCRUD();

        if(isLogin()){
            Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(myIntent);
        }
    }

    private void basicCRUD() {
        Log.d(TAG, "basicCRUD: ");

        //delete all
        realm.executeTransaction(new Realm.Transaction(){

            @Override
            public void execute(Realm realm) {
                realm.delete(User.class);
            }
        });
        Log.d(TAG, "count " + realm.where(User.class).count());

        //add
        realm.executeTransaction(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {
                //add user
                User user = realm.createObject(User.class);
                user.setFullName("Mai Huu Tai");
                user.setUsername("taimai");
                user.setPassworld("123");
            }
        });

////        ------
//        realm.beginTransaction();
//        User user = realm.createObject(User.class);
//        user.setFullName("Mai Huu Tai");
//        user.setUsername("taimai");
//        user.setPassworld("123");
//        realm.commitTransaction();
//
////        ---
//        User user1 = new User();
//        user1.setFullName("Mai Huu Tai");
//        user1.setUsername("taimai");
//        user1.setPassworld("123");
//        realm.beginTransaction();
//        User realmUser = realm.copyToRealm(user);
//        Log.d(TAG, "copy to realm "+ realmUser.getFullName());
//        Log.d(TAG, "count " + realm.where(User.class).count());
//        realm.commitTransaction();
//
//        realm.executeTransactionAsync(new Realm.Transaction() {
//            @Override
//            public void execute(Realm bgRealm) {
//                User user = bgRealm.createObject(User.class);
//                user.setFullName("Mai Huu Tai123");
//                user.setUsername("taimai123");
//            }
//        }, new Realm.Transaction.OnSuccess() {
//            @Override
//            public void onSuccess() {
//                // Transaction was a success.
//                Log.d(TAG, "onSuccess: " + realm.where(User.class).count());
//            }
//        }, new Realm.Transaction.OnError() {
//            @Override
//            public void onError(Throwable error) {
//                // Transaction failed and was automatically canceled.
//                Log.d(TAG, "onError: ");
//            }
//        });

        //find all
        RealmResults<User> users = realm.where(User.class).findAll();
        for (User user2 : users) {
            Log.d(TAG, "full name:" + user2.getFullName() + "; username: " + user2.getUsername());
        }
        Log.d(TAG, "count " + realm.where(User.class).count());

        //update
//        realm.executeTransaction(new Realm.Transaction(){
//
//            @Override
//            public void execute(Realm realm) {
//                user.setFullName("Mai Huu Tai 1");
//                user.setUsername("taimai64");
//            }
//        });
//
//        final User user1 = realm.where(User.class).findFirst();
//        Log.d(TAG, "full name:" + user1.getFullName() + "; username: " + user1.getUsername());
//        Log.d(TAG, "count " + realm.where(User.class).count());


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }

    private boolean checkLogin(String username, String passworld){
        User user = null;
        if(username.equals("taimai") && passworld.equals("123")){
            user = new User();
            user.setFullName("Mai Huu Tai");
            user.setUsername(username);
            user.setPassworld(passworld);
        }
        if(user != null){
            return true;
        }else{
            return false;
        }
    }

    private boolean isLogin(){
        realm.beginTransaction();
        User user = realm.where(User.class)
                .findFirst();
        realm.commitTransaction();
        if(user != null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(isLogin()){
           finish();
        }
    }
}
