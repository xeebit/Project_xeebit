package com.example.oladapo.groupapp.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import com.example.oladapo.groupapp.R;


public class TypeFacedButton extends Button {

    public TypeFacedButton(Context context, AttributeSet attrs) {

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
            try {
                Typeface typeface = TypeFaceCache.get(context.getAssets(), typefaceCode);
                setTypeface(typeface);
            } catch (Exception e) {

            }
        }
    }

    public TypeFacedButton(Context context) {
        super(context);
    }
}
