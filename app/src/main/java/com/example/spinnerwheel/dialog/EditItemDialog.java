package com.example.spinnerwheel.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.spinnerwheel.R;

public class EditItemDialog extends DialogFragment {
    private EditText mEditTitle;
    private RadioGroup mColorGroup;
    private static final int[] COLOR_IDS = {
            R.id.color_1, R.id.color_2, R.id.color_3, R.id.color_4, R.id.color_5, R.id.color_6, R.id.color_7
    };

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.add_item_dialog, null);

        mEditTitle = view.findViewById(R.id.text_dialog);
        mColorGroup = view.findViewById(R.id.color_group);

        builder.setView(view)
                .setPositiveButton(R.string.save, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String title = mEditTitle.getText().toString();

                        int idColor = mColorGroup.getCheckedRadioButtonId();
                        int positionColor = getPositionColor(idColor);

                        ((SaveListener) getTargetFragment()).save(title, positionColor);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        return builder.create();
    }

    public interface SaveListener {
        void save(String title, int color);
    }

    private int getPositionColor(int idColor) {
        for (int i = 0; i < 7; i++) {
            if (COLOR_IDS[i] == idColor) {
                return i;
            }
        }
        return 0;
    }
}
