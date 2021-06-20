package com.example.appprueba;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MostrarDatos extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Revistas> revistas;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_datos);
        Bundle bundle = this.getIntent().getExtras();
        String ID = bundle.getString("COD");
        extractRevistas(ID);


    }
    private void extractRevistas(String ID){
        revistas = new ArrayList<>();

        String URL= "https://revistas.uteq.edu.ec/ws/issues.php?j_id="+ ID;

        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                   try {
                       for(int i=0; i< response.length(); i++){
                       JSONObject revistaObject = response.getJSONObject(i);
                     //  Revistas revista = new Revistas();
                       String idrevista = revistaObject.getString("issue_id");
                       String volumen = revistaObject.getString("volume");
                       String number = revistaObject.getString("number");
                       String year = revistaObject.getString("year");
                       String date = revistaObject.getString("date_published");
                       String title = revistaObject.getString("title");
                       String doi = revistaObject.getString("doi");
                       String Cover = revistaObject.getString("cover");
                      /* revista.setIsseu_id(revistaObject.getString("issue_id").toString());
                       revista.setVolumen(revistaObject.getString("volume").toString());
                       revista.setNumero(revistaObject.getString("number").toString());
                       revista.setAnio(revistaObject.getString("year").toString());
                       revista.setFecha(revistaObject.getString("date_published").toString());
                       revista.setTitulo(revistaObject.getString("title").toString());
                       revista.setDoi(revistaObject.getString("doi").toString());
                       revista.setCover(revistaObject.getString("cover")); */

                       revistas.add(new Revistas(idrevista,volumen,number,year,date,title,doi,Cover));
                       }
                       adapter = new Adapter(getApplicationContext(),revistas);
                       recyclerView = findViewById(R.id.RevistaList);
                       recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                       recyclerView.setAdapter(adapter);
                   }catch (JSONException e){
                       e.printStackTrace();
                   }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });
        queue.add(jsonArrayRequest);
    }
}
