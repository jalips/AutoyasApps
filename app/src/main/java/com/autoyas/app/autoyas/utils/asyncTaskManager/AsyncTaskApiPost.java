package com.autoyas.app.autoyas.utils.asyncTaskManager;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.autoyas.app.autoyas.BuildConfig;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by link on 22/06/17.
 */

public class AsyncTaskApiPost extends AsyncTask<Integer, Void, String> {

    protected String apiMethod;
    protected String apiUrl;
    protected String action;
    protected Context context;
    protected JSONObject postDataParams;

    /**
     * Method call when AsyncTask is execute
     * @param params Integer...
     * @return String with error or data
     */
    @Override
    protected String doInBackground(Integer... params) {
        String returnString = "";

        if(BuildConfig.DEBUG) {
            Log.i("AsyncTaskApiGet",
                    "Connection to : "+apiUrl+
                            " json : "+action);
        }

        try {
            // Create URL
            URL url = new URL(apiUrl);

            // Enable Connection
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000 /* milliseconds */);
            conn.setConnectTimeout(15000 /* milliseconds */);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            // Create and get OutputStream
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(os, "UTF-8"));
            writer.write((this.postDataParams.toString()));
            writer.flush();
            writer.close();
            os.close();

            // Get the response
            int responseCode = conn.getResponseCode();
            if (responseCode == HttpsURLConnection.HTTP_OK) {

                if(BuildConfig.DEBUG) {
                    Log.i("AsyncTaskApiGet", "Return http OK ");
                }

                BufferedReader in = new BufferedReader( new InputStreamReader( conn.getInputStream()));
                StringBuffer sb = new StringBuffer("");
                String line = "";

                while((line = in.readLine()) != null) {
                    sb.append(line);
                    break;
                }
                // Return sb buffer if HTTP Code is 1
                returnString = sb.toString();
                in.close();

            } else {
                if(BuildConfig.DEBUG) {
                    Log.i("AsyncTaskApiGet", "Return http NOK " + responseCode + " not : "+ HttpsURLConnection.HTTP_OK);
                }

                // Return error if not
                returnString = "false : "+responseCode;
            }
        }
        catch(Exception e) {
            Log.e("AsyncTaskApiGet", "ERROR :: "+e.getMessage(), e);
        }
        return returnString;
    }

    /**
     * Method call at the end of doInBackground
     * @param result String of doInBackground
     */
    @Override
    protected void onPostExecute(String result) {
        // Override on sub-class
    }
}
