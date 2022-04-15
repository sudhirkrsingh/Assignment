package com.example.assignment.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.assignment.model.Model;
import com.example.assignment.adapter.ModelAdapter;
import com.example.assignment.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class FetchingDataFragment extends Fragment {

    RecyclerView recyclerView;
    List<Model> models;
    ModelAdapter adapter;
    private static final String URL = "https://my-json-server.typicode.com/easygautam/data/users";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_fetching_data, container, false);

        recyclerView = view.findViewById(R.id.recycler_view);
        models = new ArrayList<>();


        // This is function will allow us to fetch the json data from the given URL
        extractData();
        return view;
    }

    private void extractData() {
        // Progress dialog
        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(getContext());
        progressDialog.show();
        progressDialog.setContentView(R.layout.progress_dialog);
        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

        // From this point we are starting our main code to fetch data from URL
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject modelObject = response.getJSONObject(i);

                        Model model = new Model();
                        model.setName(modelObject.getString("name").toString());
                        model.setSubject(modelObject.getString("subjects").toString().replace("[", "").replace("]", "")
                                .replace("\"", ""));
                        model.setQualification(modelObject.getString("qualification").toString().replace("[", "").replace("]", "")
                                .replace("\"", ""));
                        model.setProfileImage(modelObject.getString("profileImage"));

                        models.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(getContext(), "Try-Again", Toast.LENGTH_SHORT).show();
                        // Progress dialog end
                        progressDialog.dismiss();
                    }
                }

                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter = new ModelAdapter(models, getContext());
                recyclerView.setAdapter(adapter);
                // Progress dialog end
                progressDialog.dismiss();


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), "Something Went Wrong", Toast.LENGTH_SHORT).show();

                // Progress dialog end
                progressDialog.dismiss();

            }
        });
        queue.add(jsonArrayRequest);
    }


}