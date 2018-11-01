package net.crystalapps.mint.storage.library.core;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.crystalapps.mint.storage.library.converters.ToStringConverter;
import net.crystalapps.mint.storage.library.converters.ToObjectConverter;

import static net.crystalapps.mint.storage.library.utils.ObjectUtil.requireNonNull;


/**
 * Created by Syed Owais Ali on 5/18/2018.
 */

@SuppressWarnings("unused")
public class Storage {

    private static StorageAdapter adapter;

    private Storage() {
        throw new SecurityException();
    }

    public static void setAdapter(@NonNull StorageAdapter adapter) {
        Storage.adapter = requireNonNull(adapter);
    }

    public static void put(@NonNull String key, int value) {
        adapter.put(requireNonNull(key), value);
    }

    public static void put(@NonNull String key, long value) {
        adapter.put(requireNonNull(key), value);
    }

    public static void put(@NonNull String key, float value) {
        adapter.put(requireNonNull(key), value);
    }

    public static void put(@NonNull String key, double value) {
        adapter.put(requireNonNull(key), value);
    }

    public static void put(@NonNull String key, boolean value) {
        adapter.put(requireNonNull(key), value);
    }

    public static void put(@NonNull String key, String value) {
        adapter.put(requireNonNull(key), value);
    }

    public static void put(@NonNull String key, @NonNull Object value) {
        adapter.put(requireNonNull(key), value);
    }

    public static void put(@NonNull String key, @NonNull Object value, @NonNull ToStringConverter parser) {
        adapter.put(requireNonNull(key), value, parser);
    }

    public static int getInt(@NonNull String key) {
        return adapter.getInt(requireNonNull(key));
    }

    public static int getInt(@NonNull String key, int defaultValue) {
        return adapter.getInt(requireNonNull(key), defaultValue);
    }

    public static long getLong(@NonNull String key) {
        return adapter.getLong(requireNonNull(key));
    }

    public static long getLong(@NonNull String key, long defaultValue) {
        return adapter.getLong(requireNonNull(key), defaultValue);
    }

    public static float getFloat(@NonNull String key) {
        return adapter.getFloat(requireNonNull(key));
    }

    public static float getFloat(@NonNull String key, float defaultValue) {
        return adapter.getFloat(requireNonNull(key), defaultValue);
    }

    public static double getDouble(@NonNull String key) {
        return adapter.getDouble(requireNonNull(key));
    }

    public static double getDouble(@NonNull String key, double defaultValue) {
        return adapter.getDouble(requireNonNull(key), defaultValue);
    }

    public static boolean getBoolean(@NonNull String key) {
        return adapter.getBoolean(requireNonNull(key));
    }

    public static boolean getBoolean(@NonNull String key, boolean defaultValue) {
        return adapter.getBoolean(requireNonNull(key), defaultValue);
    }

    @Nullable
    public static String getString(@NonNull String key) {
        return adapter.getString(requireNonNull(key));
    }

    @Nullable
    public static String getString(@NonNull String key, @Nullable String defaultValue) {
        return adapter.getString(requireNonNull(key), defaultValue);
    }

    @Nullable
    public static <T> T get(@NonNull String key, @NonNull Class<T> typeClass) {
        return adapter.get(requireNonNull(key), requireNonNull(typeClass));
    }

    @Nullable
    public static <T> T get(@NonNull String key, @NonNull Class<T> typeClass, @NonNull ToObjectConverter parser) {
        return adapter.get(requireNonNull(key), requireNonNull(typeClass), requireNonNull(parser));
    }

    public static void remove(@NonNull String key) {
        adapter.remove(key);
    }

    public static void clear() {
        adapter.clear();
    }

    public static boolean contains(@NonNull String key) {
        return adapter.contains(key);
    }
}