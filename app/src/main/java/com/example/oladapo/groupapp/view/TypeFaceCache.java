package com.example.oladapo.groupapp.view;

import android.content.res.AssetManager;
import android.graphics.Typeface;

import java.util.Hashtable;

public class TypeFaceCache {

    private static final Hashtable<String, Typeface> CACHE = new Hashtable<String, Typeface>();

    private static final String ROMAN = "fonts/AvenirLTStd-Roman.ttf";
    private static final String HEAVY = "fonts/AvenirLTStd-Heavy.ttf";
    private static final String BLACK = "fonts/AvenirLTStd-Black.ttf";

    public static Typeface get(AssetManager manager, int typefaceCode) {
        synchronized (CACHE) {

            String typefaceName = getTypefaceName(typefaceCode);

            if (!CACHE.containsKey(typefaceName)) {
                Typeface t = Typeface.createFromAsset(manager, typefaceName);
                CACHE.put(typefaceName, t);
            }
            return CACHE.get(typefaceName);
        }
    }

    private static String getTypefaceName(int typefaceCode) {
        switch (typefaceCode) {
            case 0:
            default:
                return ROMAN;

            case 1:
                return HEAVY;

            case 2:
                return BLACK;

        }
    }
}
