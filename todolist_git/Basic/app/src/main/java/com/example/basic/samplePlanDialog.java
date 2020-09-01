package com.example.basic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;

public class samplePlanDialog extends DialogFragment {

    public interface dialogInterface {
        void getPlan(Plan plan);
    }

    private Button btnAddAction, btnDismiss;
    private EditText EditText;
    private CardView parent;

    private dialogInterface dialogInterface;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_item,null);
        initView(view);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Enter Activity");
        builder.setView(view);

        btnAddAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = EditText.getText().toString();
                Plan plans = new Plan(str);

                try {
                    dialogInterface = (dialogInterface) getActivity();
                    dialogInterface.getPlan(plans);
                    dismiss();

                }catch (ClassCastException e){
                    e.printStackTrace();
                    dismiss();
                }

            }
        });

        btnDismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });


        return builder.create();
    }

    private void initView(View view) {
        btnAddAction = view.findViewById(R.id.btnAddText);
        btnDismiss = view.findViewById(R.id.btnDismiss);
        EditText  = view.findViewById(R.id.EditTxt);
        parent = view.findViewById(R.id.parent);
    }
}
