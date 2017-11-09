package com.ndinaholding.expresstilldeliveries.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ndinaholding.expresstilldeliveries.CustomAdapter;
import com.ndinaholding.expresstilldeliveries.ItemObject;
import com.ndinaholding.expresstilldeliveries.POJOs.Special;
import com.ndinaholding.expresstilldeliveries.R;
import com.ndinaholding.expresstilldeliveries.SpecialsAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpecialsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpecialsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecialsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private View rootView;

    public static final String MyORDER = "MyOrder" ;
    public static final String Item = "itemKey";
    public static final String Price = "priceKey";
    public static final String Total = "totalKey";

    private String orderItem;
    private String orderPrice;

    SharedPreferences sharedpreferences;

    ListView list;
    SpecialsAdapter adapter;
    private List<Special> items;

    public SpecialsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SpecialsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SpecialsFragment newInstance(String param1, String param2) {
        SpecialsFragment fragment = new SpecialsFragment();
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
        View rootView;
        rootView = inflater.inflate(R.layout.fragment_specials, container, false);

        GridView gridview = rootView.findViewById(R.id.gridview);

        TextView txtTot = rootView.findViewById(R.id.txtCheckout);

        List<ItemObject> allItems = getAllItemObject();
        CustomAdapter customAdapter = new CustomAdapter(getActivity(), allItems, txtTot);
        gridview.setAdapter(customAdapter);

        Button btnContinue = rootView.findViewById(R.id.btnContinue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SpecialsFragment nextFrag= new SpecialsFragment();
                //nextFrag.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, nextFrag,"findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        Button btnCheckout = rootView.findViewById(R.id.btnCheckout);
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckoutFragment nextFrag= new CheckoutFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, nextFrag,"findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }

    private List<ItemObject> getAllItemObject(){
        ItemObject itemObject = null;
        List<ItemObject> items = new ArrayList<>();
        items.add(new ItemObject("Albany", "albany", "R 17.50"));
        items.add(new ItemObject("Hullet", "hullet", "R 7.45"));
        items.add(new ItemObject("Koo", "koo", "R 9.90"));
        return items;
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
