package com.ndinaholding.expresstilldeliveries.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.ndinaholding.expresstilldeliveries.ApiInterface;
import com.ndinaholding.expresstilldeliveries.LazyAdapter;
import com.ndinaholding.expresstilldeliveries.MyAdapter;
import com.ndinaholding.expresstilldeliveries.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OptionsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OptionsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OptionsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ListView list;
    LazyAdapter adapter;
    private View rootView;

    private ApiInterface apiInterface;
    private ProgressBar spinner;
    private String apiKey;

    private RadioButton radioPromotions;
    private RadioButton radioSpecials;
    private RadioButton radioSales;
    private RadioButton radioMyList;

    private int shopCode;

    public OptionsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OptionsFragment newInstance(String param1, String param2) {
        OptionsFragment fragment = new OptionsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_options, container, false);

        RadioGroup radioGroup = rootView.findViewById(R.id.myRadioGroup);
        radioPromotions = rootView.findViewById(R.id.promotions);
        radioSpecials = rootView.findViewById(R.id.specials);
        radioSales = rootView.findViewById(R.id.sales);
        radioMyList = rootView.findViewById(R.id.myList);

        Bundle args = getArguments();
        shopCode = args.getInt("shop");

//        Toast.makeText(getContext(), "Sharp  " + index, Toast.LENGTH_LONG).show();

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Bundle args = new Bundle();
                args.putInt("shop", shopCode);

                if(checkedId == R.id.promotions) {
                    radioPromotions.setChecked(false);
                    PromotionsFragment nextFrag= new PromotionsFragment();
                    nextFrag.setArguments(args);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, nextFrag,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                } else if(checkedId == R.id.specials) {
                    radioSpecials.setChecked(false);
                    SpecialsFragment nextFrag= new SpecialsFragment();
                    nextFrag.setArguments(args);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, nextFrag,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                } else if(checkedId == R.id.sales) {
                    radioSales.setChecked(false);
                    SalesFragment nextFrag= new SalesFragment();
                    nextFrag.setArguments(args);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, nextFrag,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                } else {
                    radioMyList.setChecked(false);
                    CheckoutFragment nextFrag= new CheckoutFragment();
                    nextFrag.setArguments(args);
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frame, nextFrag,"findThisFragment")
                            .addToBackStack(null)
                            .commit();
                }
            }
        });

        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
