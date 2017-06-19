package com.journaldev.loginphpmysql;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Registration extends AppCompatActivity {
    Button register;
    EditText fname,mname,lname,email,phoneno,password,state,city,skypeid,twitterid,facebookid;
    String Fname,Mname,Lname,Email,Phnomeno,Password,State,City,Skypeid,Twitterid,Facebookid;

    String URL= "http://192.168.56.2:8888/test_android/index.php";

    JSONParser jsonParser=new JSONParser();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
        register=(Button)findViewById(R.id.btnSingIn);
        fname=(EditText)findViewById(R.id.fName);
        mname=(EditText)findViewById(R.id.mName);
        lname=(EditText)findViewById(R.id.lName);
        email=(EditText)findViewById(R.id.E_mail);
        phoneno=(EditText)findViewById(R.id.Phone_no);
        password=(EditText)findViewById(R.id.etPass);
        state=(EditText)findViewById(R.id.state);
        city=(EditText)findViewById(R.id.city);
        skypeid=(EditText)findViewById(R.id.skype_id);
        twitterid=(EditText)findViewById(R.id.twitter_id);
        facebookid=(EditText)findViewById(R.id.facebook_id);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Fname=fname.getText().toString();
                Mname=mname.getText().toString();
                Lname=lname.getText().toString();
                Email=email.getText().toString();
                Phnomeno=phoneno.getText().toString();
                Password=password.getText().toString();
                State=state.getText().toString();
                City=city.getText().toString();
                Skypeid=skypeid.getText().toString();
                Twitterid=twitterid.getText().toString();
                Facebookid=facebookid.getText().toString();

                // Toast.makeText(getApplicationContext(),Fname+Mname+Lname+Email+Phnomeno+Password+State+City+Skypeid+Twitterid+Facebookid,Toast.LENGTH_LONG).show();

                AttemptLogin attemptLogin= new AttemptLogin();
                attemptLogin.execute(Fname,Mname,Lname,Email,Phnomeno,Password,State,City,Skypeid,Twitterid,Facebookid);
            }
        });
    }
    private class AttemptLogin extends AsyncTask<String, String, JSONObject> {

        @Override

        protected void onPreExecute() {

            super.onPreExecute();

        }

        @Override

        protected JSONObject doInBackground(String... args) {
            String fname= args[0];
            String mname= args[1];
            String lname= args[2];
            String email = args[3];
            String phone= args[4];
            String password = args[5];
            String state= args[6];
            String city= args[7];
            String skipeid= args[8];
            String twitterid= args[9];
            String facebookid= args[10];


            ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
            params.add(new BasicNameValuePair("fname", fname));
            params.add(new BasicNameValuePair("mname", mname));
            params.add(new BasicNameValuePair("lname", lname));
            params.add(new BasicNameValuePair("phone", phone));
            params.add(new BasicNameValuePair("password", password));
            params.add(new BasicNameValuePair("state", state));
            params.add(new BasicNameValuePair("city", city));
            params.add(new BasicNameValuePair("skipeid", skipeid));
            params.add(new BasicNameValuePair("twitterid", twitterid));
            params.add(new BasicNameValuePair("facebookid", facebookid));
            if(email.length()>0)
                params.add(new BasicNameValuePair("email",email));

            JSONObject json = jsonParser.makeHttpRequest(URL, "POST", params);


             return json;



        }

        protected void onPostExecute(JSONObject result) {

            // dismiss the dialog once product deleted
            //Toast.makeText(getApplicationContext(),result,Toast.LENGTH_LONG).show();

            try {
                if (result != null) {
                    Toast.makeText(getApplicationContext(),result.getString("message"), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Unable to retrieve any data from server", Toast.LENGTH_LONG).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }


        }

    }
}
