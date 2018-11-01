package net.crystalapps.mint.storage;

import android.app.Application;

import net.crystalapps.mint.storage.library.adapters.SharedPreferenceAdapter;
import net.crystalapps.mint.storage.library.core.Storage;

/**
 * Created by Syed Owais Ali on 11/2/2018.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferenceAdapter adapter = new SharedPreferenceAdapter(this);
        Storage.setAdapter(adapter);
    }
}