package com.autoyas.app.autoyas.utils.asyncTaskManager.asyncTasks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.autoyas.app.autoyas.BuildConfig;
import com.autoyas.app.autoyas.R;
import com.autoyas.app.autoyas.activities.MainActivity;
import com.autoyas.app.autoyas.utils.asyncTaskManager.AsyncTaskApiGet;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Use to call API with fields in login page
 * And write sharedPrefs if it's good
 * And display a message on login page if it's not
 */
public class AsyncGetAuthGet extends AsyncTaskApiGet {

    private View rootView;

    /**
     * Constructor
     * @param context Current context
     * @param rootView Current view
     * @param login User login
     * @param password User password
     */
    public AsyncGetAuthGet(Context context, View rootView, String login, String password) {
        this.context = context;
        this.rootView = rootView;

        this.apiUrl = context.getResources().getString(R.string.apiUrl);

        // Define API Action
        this.action = "/";

        // Create Json Params
        this.postDataParams = new JSONObject();
        try {
            this.postDataParams.put("login", login);
            this.postDataParams.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        try {

            //final ProgressBar progress = (ProgressBar) rootView.findViewById(R.id.progress);
            //progress.setVisibility(View.GONE);

            JSONObject jObject = new JSONObject(result);
            JSONObject myData = jObject.getJSONObject("data");

            if(BuildConfig.DEBUG) {
                Log.i("AsyncGetAuthGet", "OnPostExecute jObject : "+jObject.toString());
                Log.i("AsyncGetAuthGet", "OnPostExecute myData : "+myData.toString());
            }

            // Return true if is an update
            boolean authIsGood = myData.getBoolean("auth");
            String user_name = myData.getString("name");
            String user_surname = myData.getString("surname");
            int user_id = myData.getInt("id");
            String user_passwordDate = myData.getString("passwordDate");

            if (!authIsGood || user_name.equals("") || user_surname.equals("")) {
                if(BuildConfig.DEBUG) {
                    Log.i("AsyncTaskGetAuth", "Return to AuthActivity and display something");
                }

                int duration = Toast.LENGTH_LONG;
                Toast.makeText(context, "Erreur lors de la connexion.", duration).show();

            }else {
                if(BuildConfig.DEBUG) {
                    Log.i("AsyncTaskGetAuth", "auth is true -> create User and rightAuth");
                }

                if(BuildConfig.DEBUG) {
                    Log.i("AsyncTaskGetAuth", "Create sharedPrefs for user and launch MainActivity");
                }

                //User.getInstance(context).saveUser(new User(user_id, user_name, user_passwordDate, user_surname));

                Intent intent = new Intent(context, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
                Activity activity = (Activity) context;
                activity.finish();
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
