package com.leonis.leonisandrod;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ContactsFragment mContactsFragment;
    JournalFragment mJournalFragment;
    MessagesFragment mMessagesFragment;
    FragmentTransaction mFragmentTransaction;
    FrameLayout content;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mFragmentTransaction =  getFragmentManager().beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_journal:
                    setTitle(R.string.title_journal);
                    mFragmentTransaction.replace(R.id.content, mJournalFragment);
                    mFragmentTransaction.commit();
                    return true;
                case R.id.navigation_contacts:
                    setTitle(R.string.title_contacts);
                    mFragmentTransaction.replace(R.id.content, mContactsFragment);
                    mFragmentTransaction.commit();
                    return true;
                case R.id.navigation_messages:
                    setTitle(R.string.title_messages);
                    mFragmentTransaction.replace(R.id.content, mMessagesFragment);
                    mFragmentTransaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onResume() {
        super.onResume();
        mFragmentTransaction =  getFragmentManager().beginTransaction();
        mFragmentTransaction.add(R.id.content, mJournalFragment);
        mFragmentTransaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationDrawer = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationDrawer.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        content = (FrameLayout) findViewById(R.id.content);

        mContactsFragment = new ContactsFragment();
        mJournalFragment = new JournalFragment();
        mMessagesFragment = new MessagesFragment();

        setTitle(R.string.title_journal);
    }



}
