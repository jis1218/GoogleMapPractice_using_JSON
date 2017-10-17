package com.example.bikefaciposinfo;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by 정인섭 on 2017-10-17.
 */

public class Remote {

    public static String getData(String urlString) {
        StringBuilder result = new StringBuilder();
        try {
            URL mUrl = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) mUrl.openConnection();
            con.setRequestMethod("GET");
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("연결되었음");
                InputStreamReader isr = new InputStreamReader(con.getInputStream());
                BufferedReader br = new BufferedReader(isr);
                String temp = "";

                while ((temp = br.readLine()) != null) {
                    result.append(temp).append("\n");
                }
                br.close();
                isr.close();
            } else {
                Log.d("Connection", "안되었음");
            }
            con.disconnect();
        } catch (Exception e) {
            Log.e("ErrorError", e.toString());

        }

        return result.toString();
    }


}
