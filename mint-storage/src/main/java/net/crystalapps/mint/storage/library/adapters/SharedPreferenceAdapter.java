package net.crystalapps.mint.storage.library.adapters;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.crystalapps.mint.storage.library.converters.ToObjectConverter;
import net.crystalapps.mint.storage.library.converters.ToStringConverter;
import net.crystalapps.mint.storage.library.core.StorageAdapter;
import net.crystalapps.mint.storage.library.utils.ObjectUtil;


/**
 * Created by Syed Owais Ali on 5/18/2018.
 */

@SuppressWarnings({"ConstantConditions","unused","WeakerAccess"})
public class SharedPreferenceAdapter implements StorageAdapter {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private ToObjectConverter toObjectConverter;
    private ToStringConverter toStringConverter;

    public SharedPreferenceAdapter(@NonNull Context context) {
        this(context, "sp_mint");
    }

    public SharedPreferenceAdapter(@NonNull Context context, @NonNull String fileName) {
        this(context, fileName, Context.MODE_PRIVATE);
    }

    public SharedPreferenceAdapter(@NonNull Context context, @NonNull String fileName, int mode) {
        ObjectUtil.requireNonNull(context);
        prefs = context.getApplicationContext().getSharedPreferences(fileName, mode);
        editor = prefs.edit();
        editor.apply();
    }

    public void setToObjectConverter(@NonNull ToObjectConverter toObjectConverter) {
        this.toObjectConverter = toObjectConverter;
    }

    public void setToStringConverter(@NonNull ToStringConverter toStringConverter) {
        this.toStringConverter = toStringConverter;
    }

    @Override
    public void put(@NonNull String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    @Override
    public void put(@NonNull String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    @Override
    public void put(@NonNull String key, float value) {
        editor.putFloat(key, value);
        editor.apply();
    }

    @Override
    public void put(@NonNull String key, double value) {
        editor.putString(key, String.valueOf(value));
        editor.apply();
    }

    @Override
    public void put(@NonNull String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    @Override
    public void put(@NonNull String key, @NonNull String value) {
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    public void put(@NonNull String key, @NonNull Object value) {
        put(key, value, toStringConverter);
    }

    @Override
    public void put(@NonNull String key, @NonNull Object value, @NonNull ToStringConverter converter) {
        put(key, converter.convertToString(value));
    }

    @Override
    public int getInt(@NonNull String key) {
        return getInt(key, 0);
    }

    @Override
    public int getInt(@NonNull String key, int defaultValue) {
        return prefs.getInt(key, defaultValue);
    }

    @Override
    public long getLong(@NonNull String key) {
        return getLong(key, 0);
    }

    @Override
    public long getLong(@NonNull String key, long defaultValue) {
        return prefs.getLong(key, defaultValue);
    }

    @Override
    public float getFloat(@NonNull String key) {
        return getFloat(key, 0f);
    }

    @Override
    public float getFloat(@NonNull String key, float defaultValue) {
        return prefs.getFloat(key, defaultValue);
    }

    @Override
    public double getDouble(@NonNull String key) {
        return getDouble(key, 0);
    }

    @Override
    public double getDouble(@NonNull String key, double defaultValue) {
        try {
            return Double.parseDouble(prefs.getString(key, "0"));
        }
        catch (Exception ex) {
            return defaultValue;
        }
    }

    @Override
    public boolean getBoolean(@NonNull String key) {
        return getBoolean(key, false);
    }

    @Override
    public boolean getBoolean(@NonNull String key, boolean defaultValue) {
        return prefs.getBoolean(key, defaultValue);
    }

    @Nullable
    @Override
    public String getString(@NonNull String key) {
        return getString(key, null);
    }

    @Nullable
    @Override
    public String getString(@NonNull String key, @Nullable String defaultValue) {
        return prefs.getString(key, defaultValue);
    }

    @Nullable
    @Override
    public <T> T get(@NonNull String key, @NonNull Class<T> typeClass) {
        return get(key, typeClass, toObjectConverter);
    }

    @Nullable
    @Override
    public <T> T get(@NonNull String key, @NonNull Class<T> typeClass, @NonNull ToObjectConverter converter) {
        return converter.convertToObject(getString(key), typeClass);
    }

    @Override
    public void remove(@NonNull String key) {
        editor.remove(key);
        editor.apply();
    }

    @Override
    public void clear() {
        editor.clear();
        editor.apply();
    }

    @Override
    public boolean contains(@NonNull String key) {
        return prefs.contains(key);
    }

}