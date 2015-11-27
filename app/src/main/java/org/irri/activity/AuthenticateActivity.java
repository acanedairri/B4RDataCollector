package org.irri.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;



import org.irri.activity.R;
import org.irri.constant.Authentication;

public class AuthenticateActivity extends AppCompatActivity {

    private int REQUEST_CODE=0X1;
    private TextView _ResponseShowTestView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authenticate);
        _ResponseShowTestView= (TextView) findViewById(R.id.response_text_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_authenticate, menu);
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



    public void actionAuthenticate(View v){

        Intent intent = new Intent ( this,EasySocialAuthActivity.class);
/*       String loginUrl ="https://accounts.google.com/ServiceLogin?"+
                "client_id=pocketapp@breeding4rice.irri.org&"+
                "redirect_ur=https://api.breeding4rice.irri.org/v1/authenticate/authorize&"+
                "scope=";*/
        String loginUrl = Authentication.LOGIN_URL;
        intent.putExtra(EasySocialAuthActivity.URL,loginUrl);
        intent.putExtra(EasySocialAuthActivity.REDIRECT_URL,Authentication.REDIRECT_URI);

        String accessTokenUrl =Authentication.ACCESS_TOKEN_URL;
        intent.putExtra(EasySocialAuthActivity.ACCESS_TOKEN,accessTokenUrl);
        startActivityForResult(intent,REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode== RESULT_OK){

            if(requestCode== requestCode) {

                String accessToken = data.getStringExtra("data");
                System.out.println(accessToken);
                _ResponseShowTestView.setText(accessToken);
               // Intent intent = new Intent(this, RegisterUserActivity.class);
               // startActivity(intent);
            }

        }else if(resultCode == RESULT_CANCELED){

            if(resultCode == requestCode){
                Toast.makeText(this, data.getIntExtra(EasySocialAuthActivity.ERROR_CODE, 0) + "", Toast.LENGTH_LONG).show();
            }
        }
    }
}
