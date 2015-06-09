package com.example.fabricio.myapplication;

import android.util.Log;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;

import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.StrictMode;


import java.io.IOException;


/**
 * Created by marcelosiedler on 09/03/15.
 */
public class AcessoRest {
    private int  TIMEOUT_MILLISEC = 3000;


   // private String[] params;

    public String chamadaGet(String url)
    {


        HttpClient httpclient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet(url);
        String resposta = "";
        try {

            //adicionando cabeçalho para autorização do uso do serviço (API KEY)
            //Alterar de acordo com usuario (Pode ser visualizada no banco)
            httpGet.setHeader("Authorization","a0ccdfe33c77ab60c4bb34f63e75ebb0");
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

            StrictMode.setThreadPolicy(policy);

            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(httpGet,
                    responseHandler);

            resposta = responseBody;

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Throwable t) {
            Log.i("erro", t.toString());
        }

        return resposta;


    }
}
