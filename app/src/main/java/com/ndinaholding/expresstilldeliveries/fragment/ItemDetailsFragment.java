package com.ndinaholding.expresstilldeliveries.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.ndinaholding.expresstilldeliveries.ExpandableListAdapter;
import com.ndinaholding.expresstilldeliveries.GroceryList;
import com.ndinaholding.expresstilldeliveries.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ItemDetailsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ItemDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ItemDetailsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    private View rootView;

    public static final String MyORDER = "MyOrder" ;
    public static final String Total = "totalKey";

    public ItemDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ItemDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ItemDetailsFragment newInstance(String param1, String param2) {
        ItemDetailsFragment fragment = new ItemDetailsFragment();
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
        rootView = inflater.inflate(R.layout.fragment_item_details, container, false);

        expListView = rootView.findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        TextView txtTot = rootView.findViewById(R.id.txtCheckout);

        SharedPreferences sharedpreferences;

        sharedpreferences = getActivity().getSharedPreferences(MyORDER, Context.MODE_PRIVATE);

        float localTotal = 0.00f;
        localTotal = sharedpreferences.getFloat(Total, localTotal);

        txtTot.setText("Total: R " + String.format("%.2f", localTotal));

        listAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

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

        Button btnAddToCart = rootView.findViewById(R.id.btnAddToCart);
        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                GroceryListFragment nextFrag= new GroceryListFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, nextFrag,"findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return rootView;
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Choose Brand");
        listDataHeader.add("Choose size");

        // Adding child data
        List<String> brands = new ArrayList<String>();
        brands.add("Hullets");
        brands.add("Illovo");
        brands.add("No Name");

        List<String> size = new ArrayList<String>();
        size.add("500 g");
        size.add("1 kg");
        size.add("2.5 kg");
        size.add("5 kg");

        listDataChild.put(listDataHeader.get(0), brands); // Header, Child data
        listDataChild.put(listDataHeader.get(1), size);
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
