package com.example.kimjh.fragmentpj;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {
    TextView messageView;
    EditText inputView;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        messageView = (TextView)v.findViewById(R.id.text_message);
        inputView = (EditText)v.findViewById(R.id.edit_input);
        Button btn = (Button)v.findViewById(R.id.btn_send);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageView.setText(inputView.getText().toString());
            }
        });
        return v;
    }   //View를 생성하여 넘겨 준다.

    public String getMessage() {
        if(messageView != null)
        {
            return messageView.getText().toString();//messageView에 메시지가 있으면 toString로 만든다?
        }
        return null;
    }
}
