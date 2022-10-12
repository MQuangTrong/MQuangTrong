package com.example.parsejson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    private RequestQueue mQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mTextViewResult = findViewById(R.id.tv_result);
        Button btnParse = findViewById(R.id.btn_parse);
        
        mQueue = Volley.newRequestQueue(this);
        
        btnParse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
            }


        });
    }
    private void jsonParse() {
        String url = "https://api.jsonserve.com/ZCNgKD";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("student");

                            for(int i = 0; i< jsonArray.length(); i++){
                                JSONObject student = jsonArray.getJSONObject(i);

                                String studentid = student.getString("studnet_id");
                                String name = student.getString("name");
                                String email = student.getString("email");
                                String _class = student.getString("class");

                                mTextViewResult.append(studentid + ", " + name + ", " + email + ", " + _class + "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mQueue.add(request);
    }
}