package com.example.fabricio.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void entrar(View v){
        //Necessita-se de uma thread caso contário gera Exception
       new Thread(){
          public void run (){
               TextView inputLogin = (TextView) findViewById(R.id.idLogin);
               TextView inputSenha = (TextView) findViewById(R.id.idSenha);

               Usuario usuario = new Usuario(inputLogin.getText().toString(),
                       inputSenha.getText().toString());
              //Chamando função estática da classe HttpConnection
               String resposta = HttpConnection.getSetDataWeb("http://192.168.150.101/checkin/v1/login", usuario);
               Log.i("Teste2",resposta.toString());
           }
       }.start();
        Intent intent = new Intent(this, lista.class);
        startActivity(intent);

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
}
