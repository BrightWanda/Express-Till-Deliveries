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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ndinaholding.expresstilldeliveries.Checkout;
import com.ndinaholding.expresstilldeliveries.ItemDetails;
import com.ndinaholding.expresstilldeliveries.LazyAdapter;
import com.ndinaholding.expresstilldeliveries.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GroceryListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GroceryListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroceryListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private View rootView;

    public static final String MyORDER = "MyOrder";
    public static final String Total = "totalKey";

    ListView list;
    LazyAdapter adapter;

    public GroceryListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GroceryListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GroceryListFragment newInstance(String param1, String param2) {
        GroceryListFragment fragment = new GroceryListFragment();
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

        rootView = inflater.inflate(R.layout.fragment_grocery_list, container, false);

        String[] items = {"Bread", "Milk", "Eggs", "Sugar", "Soap"};

        list= rootView.findViewById(R.id.list);

        SharedPreferences sharedpreferences;

        sharedpreferences = getActivity().getSharedPreferences(MyORDER, Context.MODE_PRIVATE);

        float localTotal = 0.00f;
        localTotal = sharedpreferences.getFloat(Total, localTotal);

        TextView txtTot = rootView.findViewById(R.id.txtCheckout);

        txtTot.setText("Total: R " + String.format("%.2f", localTotal));

        // Getting adapter by passing xml data ArrayList
        adapter=new LazyAdapter(getActivity(),items);
        list.setAdapter(adapter);

        // Click event for single list row
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                ItemDetailsFragment nextFrag= new ItemDetailsFragment();
                //nextFrag.setArguments(args);
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, nextFrag,"findThisFragment")
                        .addToBackStack(null)
                        .commit();
            }
        });

        Button btnCancel = rootView.findViewById(R.id.btnCancelOrder);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeFragment nextFrag= new HomeFragment();
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
