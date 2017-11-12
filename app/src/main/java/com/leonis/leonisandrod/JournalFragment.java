package com.leonis.leonisandrod;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.leonis.leonisandrod.callpackage.Call;
import com.leonis.leonisandrod.callpackage.CallAdapter;
import com.leonis.leonisandrod.callpackage.MissedCall;
import com.leonis.leonisandrod.callpackage.MissedOutgoingCall;
import com.leonis.leonisandrod.callpackage.OutgoingCall;
import com.leonis.leonisandrod.callpackage.ReceivedCall;
import com.leonis.leonisandrod.ContactPackage.Contact;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link JournalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link JournalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class JournalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<Call> calls = new ArrayList<>();
    ListView listView = null;
    CallAdapter callAdapter = null;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public JournalFragment() {
        Contact john = new Contact("John", "+38 (093) 631-06-19");
        Contact bob = new Contact("Bob", "+38 (096) 105-45-87");
        Contact keks = new Contact("Keks", "+38 (093) 102-46-55");
        Contact keks2 = new Contact("Keks2", "+38 (095) 768-55-55");

        Call call1 = new MissedCall(john, 3);
        Call call2 = new ReceivedCall(bob, 25);
        Call call3 = new OutgoingCall(keks, 6);
        Call call4 = new MissedOutgoingCall(keks2, 1);


        calls.add(call1);
        calls.add(call2);
        calls.add(call3);
        calls.add(call4);

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment JournalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static JournalFragment newInstance(String param1, String param2) {
        JournalFragment fragment = new JournalFragment();
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

        View rootView = inflater.inflate(R.layout.fragment_journal, container, false);
        listView = (ListView) rootView.findViewById(R.id.listViewJournal);
        if (calls.isEmpty()) {
            Log.v("calls", "calls is empty");
        }
        else {
            Log.v("calls", "calls is not empty");
        }
        callAdapter = new CallAdapter(getActivity(), calls);
        listView.setAdapter(callAdapter);
        // Inflate the layout for this fragment
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
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
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
