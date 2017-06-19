package com.journaldev.loginphpmysql;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class aboutDeveloper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);
    }

    public void buttonLinkedin(View view)
    {
        Uri uri = Uri.parse("https://in.linkedin.com/in/rishabh-modi-a75846118"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void buttonGithub(View view)
    {
        Uri uri = Uri.parse("https://github.com/rishabh-modi"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void buttonGoogle(View view)
    {
        Uri uri = Uri.parse("https://plus.google.com/+RishabhModir5"); // missing 'http://' will cause crashed
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
