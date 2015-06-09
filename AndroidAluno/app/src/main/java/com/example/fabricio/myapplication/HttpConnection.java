package com.example.fabricio.myapplication;

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpConnection {
	public static String getSetDataWeb(String url, Usuario u) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
		String answer = "";
		
		try{
            //Array para setar chaves e vales para POST
            ArrayList<NameValuePair> valores = new ArrayList<NameValuePair>();
            valores.add(new BasicNameValuePair("email", u.getLogin()));
            valores.add(new BasicNameValuePair("password", u.getSenha()));

            httpPost.setEntity(new UrlEncodedFormEntity(valores));
            //Envio dos campos e espera da resposta
            HttpResponse resposta = httpClient.execute(httpPost);
            answer = EntityUtils.toString(resposta.getEntity());
		}
		catch(NullPointerException e){ e.printStackTrace(); }
		catch(ClientProtocolException e){ e.printStackTrace(); }
		catch(IOException e){ e.printStackTrace(); }catch (Exception ex){
            ex.printStackTrace();}

		return(answer);
	}

    public static String getDados(String url){
        AcessoRest ar = new AcessoRest();
        String answer = ar.chamadaGet(url);
        Log.i("Teste2", answer);

        return answer;
    }
}
