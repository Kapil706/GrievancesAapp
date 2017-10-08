package com.sourabh.www.grievance;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

public class signup extends AppCompatActivity {

    EditText dt,edt1,edt2,edt3,edt4,edt5;
    Spinner spn;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dt=(EditText)findViewById(R.id.editText3);
        edt1=(EditText)findViewById(R.id.editText4);
        edt2=(EditText)findViewById(R.id.editText5);
        edt3=(EditText)findViewById(R.id.editText6);
        edt4=(EditText)findViewById(R.id.editText7);
        edt5=(EditText)findViewById(R.id.editText8);
        spn=(Spinner)findViewById(R.id.spinner);
        getSupportActionBar().setTitle("Signup");
        String items[]={"Delhi","haryana","haydrabad","mumbai"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        spn.setAdapter(adapter);
        btn=(Button)findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dt.getText().toString().equals("")){
                    dt.setError("field is mendatory");
                }else if(edt1.getText().toString().equals("")){
                    edt1.setError("field is mendatory");
                }else if(edt2.getText().toString().equals("")){
                    edt2.setError("field is mendatory");
                }else if(edt3.getText().toString().equals("")){
                    edt3.setError("field is mendatory");
                }else if(edt4.getText().toString().equals("")){
                    edt4.setError("field is mendatory");
                }else if(edt5.getText().toString().equals("")){
                    edt5.setError("field is mendatory");
                }else{

                    new signup.logn().execute(dt.getText().toString(),edt1.getText().toString(),edt2.getText().toString(),edt3.getText().toString(),edt4.getText().toString(),edt5.getText().toString(),spn.getSelectedItem().toString());
                }
            }
        });



    }
    private class logn extends AsyncTask<String,String,String>{
        ProgressDialog pdLoading = new ProgressDialog(signup.this);
        public static final int CONNECTION_TIMEOUT=10000;
        public static final int READ_TIMEOUT=15000;
        URL url;

        HttpURLConnection conn;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //this method will be running on UI thread
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();

        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            pdLoading.dismiss();
            Toast.makeText(signup.this, result, Toast.LENGTH_LONG).show();

            if (!result.equalsIgnoreCase("false") && !result.equalsIgnoreCase("exception") && !result.equalsIgnoreCase("unsuccessful")) {
                /* Here launching another activity when login successful. If you persist login state
                use sharedPreferences of Android. and logout button to clear sharedPreferences.
                 */
                Toast.makeText(signup.this, "success", Toast.LENGTH_LONG).show();


            } else if (result.equalsIgnoreCase("false")) {

                // If username and password does not match display a error message
                Toast.makeText(signup.this, "Invalid email or password", Toast.LENGTH_LONG).show();

            } else if (result.equalsIgnoreCase("exception") || result.equalsIgnoreCase("unsuccessful")) {

                Toast.makeText(signup.this, "OOPs! Something went wrong. Connection Problem.", Toast.LENGTH_LONG).show();

            }
        }

        @Override
        protected String doInBackground(String... params) {
            try {

                // Enter URL address where your php file resides
                url = new URL("http://192.168.43.139/signup.php");

            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return "exception";
            }
            try {
                // Setup HttpURLConnection class to send and receive data from php and mysql
                conn = (HttpURLConnection)url.openConnection();
                conn.setReadTimeout(READ_TIMEOUT);
                conn.setConnectTimeout(CONNECTION_TIMEOUT);
                conn.setRequestMethod("POST");

                // setDoInput and setDoOutput method depict handling of both send and receive
                conn.setDoInput(true);
                conn.setDoOutput(true);

                // Append parameters to URL
                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("fullname", params[0])
                        .appendQueryParameter("email", params[2])
                        .appendQueryParameter("password", params[3])
                        .appendQueryParameter("addr", params[4])
                        .appendQueryParameter("pin", params[5])
                        .appendQueryParameter("state", params[6])
                        .appendQueryParameter("mobile", params[1]);
                String query = builder.build().getEncodedQuery();

                // Open connection for sending data
                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(query);
                writer.flush();
                writer.close();
                os.close();
                conn.connect();

            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
                return "exception";
            }

            try {

                int response_code = conn.getResponseCode();

                // Check if successful connection made
                if (response_code == HttpURLConnection.HTTP_OK) {

                    // Read data sent from server
                    InputStream input = conn.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    StringBuilder result = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }

                    // Pass data to onPostExecute method
                    return(result.toString());

                }else{
                    return("unsuccessful");
                }

            } catch (IOException e) {
                e.printStackTrace();
                return "exception";
            } finally {
                conn.disconnect();
            }

        }
    }
}
