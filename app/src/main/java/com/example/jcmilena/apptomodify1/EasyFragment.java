package com.example.jcmilena.apptomodify1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;



public class EasyFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "numero";
    private static final String ARG_PARAM2 = "color";

    // TODO: Rename and change types of parameters
    private String mParam1 = "1";
    private int mParam2 = R.color.colorBlanco;
    EasyFragmentInterface mListener;

    public EasyFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static EasyFragment newInstance(String param1, int param2) {
        EasyFragment fragment = new EasyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putInt(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_easy, container, false);

        TextView textView = (TextView) view.findViewById(R.id.text_fragment);

        textView.setText("Soy el fragment "+ mParam1);
        textView.setBackgroundResource(mParam2);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.pulsado(mParam1);
                }
        });


        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if ( context instanceof EasyFragmentInterface ) {
            mListener = (EasyFragmentInterface) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement EasyFragmentInterface");
        }
    }

    public interface EasyFragmentInterface {

        void pulsado(String numero);

    }

}
