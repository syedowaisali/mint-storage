package net.crystalapps.mint.storage.library.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.crystalapps.mint.storage.library.converters.ToObjectConverter;
import net.crystalapps.mint.storage.library.converters.ToStringConverter;

/**
 * Created by Syed Owais Ali on 5/18/2018.
 */

public interface StorageAdapter {

    void put(@NonNull String key, int value);
    void put(@NonNull String key, long value);
    void put(@NonNull String key, float value);
    void put(@NonNull String key, double value);
    void put(@NonNull String key, boolean value);
    void put(@NonNull String key, @NonNull String value);
    void put(@NonNull String key, @NonNull Object value);
    void put(@NonNull String key, @NonNull Object value, @NonNull ToStringConverter converter);

    int getInt(@NonNull String key);
    int getInt(@NonNull String key, int defaultValue);
    long getLong(@NonNull String key);
    long getLong(@NonNull String key, long defaultValue);
    float getFloat(@NonNull String key);
    float getFloat(@NonNull String key, float defaultValue);
    double getDouble(@NonNull String key);
    double getDouble(@NonNull String key, double defaultValue);
    boolean getBoolean(@NonNull String key);
    boolean getBoolean(@NonNull String key, boolean defaultValue);
    @Nullable String getString(@NonNull String key);
    @Nullable String getString(@NonNull String key, @Nullable String defaultValue);
    @Nullable <T> T get(@NonNull String key, @NonNull Class<T> typeClass);
    @Nullable <T> T get(@NonNull String key, @NonNull Class<T> typeClass, @NonNull ToObjectConverter converter);

    void remove(@NonNull String key);
    void clear();
    boolean contains(@NonNull String key);
}
