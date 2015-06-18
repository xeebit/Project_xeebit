package com.example.oladapo.groupapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.oladapo.groupapp.R;


public class TypeFacedTextView extends TextView {

    public TypeFacedTextView(Context context, AttributeSet attrs) {

        super(context, attrs);

        if (attrs != null) {
            // Get Custom Attribute Name and value
            TypedArray styledAttrs = context.obtainStyledAttributes(attrs, R.styleable.TypeFacedTextView);
            int typefaceCode = styledAttrs.getInt(R.styleable.TypeFacedTextView_fontStyle, -1);
            styledAttrs.recycle();

            // Typeface.createFromAsset doesn't work in the layout editor.
            // Skipping...
            if (isInEditMode()) {
                return;
            }

            Typeface typeface = TypeFaceCache.get(context.getAssets(), typefaceCode);
            setTypeface(typeface);
        }
    }

    public TypeFacedTextView(Context context) {
        super(context);
    }
}
