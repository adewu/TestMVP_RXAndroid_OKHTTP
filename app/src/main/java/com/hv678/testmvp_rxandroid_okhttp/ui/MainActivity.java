package com.hv678.testmvp_rxandroid_okhttp.ui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hv678.testmvp_rxandroid_okhttp.R;
import com.hv678.testmvp_rxandroid_okhttp.bean.MeDetailBean;
import com.hv678.testmvp_rxandroid_okhttp.interfaces.UserView;
import com.hv678.testmvp_rxandroid_okhttp.presenter.UserPresenter;
import com.hv678.testmvp_rxandroid_okhttp.utils.MD5Util;

public class MainActivity extends AppCompatActivity implements UserView,View.OnClickListener{

    private EditText accountET,passwordET;
    private Button confirmBtn;
    private UserPresenter mUserPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mUserPresenter = new UserPresenter(this);
        accountET = (EditText) findViewById(R.id.accountET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        confirmBtn = (Button) findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void updateView(MeDetailBean user) {
        Toast.makeText(MainActivity.this, user.getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.confirmBtn:
                mUserPresenter.getUser(accountET.getText().toString(), MD5Util.getMD5String(passwordET.getText().toString()));
            break;
        }
    }
}
