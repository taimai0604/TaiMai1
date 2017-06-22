package mac01.democucthue;

import android.app.Application;

import com.github.johnkil.print.PrintConfig;

import io.realm.Realm;

/**
 * Created by mac01 on 6/3/17.
 */

public class ConfigActivity  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        PrintConfig.initDefault(getAssets(), "fonts/material-icon-font.ttf");
    }
}
