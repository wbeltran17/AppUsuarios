package com.example.appusuarios.services;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.appusuarios.HomeActivity;
import com.example.appusuarios.R;
import com.example.appusuarios.domain.Login;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginServices {

    public static void login(Context context, Login login) {
        StringBuilder URL = new StringBuilder();
        URL.append(context.getString(R.string.LOGIN_URL) );
        URL.append("username=");
        URL.append(login.getEmail());
        URL.append("&password=");
        URL.append(login.getPassword());

        final RequestQueue q = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                URL.toString(),
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        int accessCode = 0;
                        try {
                            accessCode = response.getInt("permitir");
                            String name = response.getString("nombre");
                            if(accessCode == 1){
                                Intent setHome = new Intent(context, HomeActivity.class);
                                setHome.putExtra("name", name);
                                context.startActivity(setHome);
                            }else{
                                Toast.makeText(context,  R.string.errorAccess, Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(context,  error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
        q.add(jsonObjectRequest);
    }
}
