package net.crystalapps.mint.storage.library.converters;

import android.support.annotation.NonNull;

/**
 * Created by Syed Owais Ali on 5/7/2018.
 */

public interface ToObjectConverter {

    <T> T convertToObject(@NonNull String data, @NonNull Class<T> clazz);
}
