package com.mycompany.practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.mycompany.practice.databinding.ActivityBankDetailsUsingIfscBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class BankDetailsUsingIfscActivity extends AppCompatActivity {

    ActivityBankDetailsUsingIfscBinding binding;
    ImageView imgPrevious, imgNext, imgHome;
    String ifscCode;
    // creating a variable for request queue.
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_bank_details_using_ifsc);
        init();
    }

    public void init() {
        imgPrevious = findViewById(R.id.imgPrevious);
        imgPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BankDetailsUsingIfscActivity.this, TorchActivity.class));
                finish();
            }
        });

        imgNext = findViewById(R.id.imgNext);
        imgNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(BankDetailsUsingIfscActivity.this, SpeechToTextActivity.class));
//                finish();
            }
        });

        imgHome = findViewById(R.id.imgHome);
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BankDetailsUsingIfscActivity.this, FirstActivity.class));
                finish();
            }
        });

        mRequestQueue = Volley.newRequestQueue(BankDetailsUsingIfscActivity.this);

        binding.btnGetDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ifscCode = binding.etIfscCode.getText().toString().trim();

                if (ifscCode.equals("")) {
                    Toast.makeText(BankDetailsUsingIfscActivity.this, "Please enter valid IFSC code", Toast.LENGTH_SHORT).show();
                } else {
                    getDataFromIFSCCode(ifscCode);
                }
            }
        });
    }

    private void getDataFromIFSCCode(String ifscCode) {

        mRequestQueue.getCache().clear();
        String url = "http://api.techm.co.in/api/v1/ifsc/" + ifscCode;
        RequestQueue queue = Volley.newRequestQueue(BankDetailsUsingIfscActivity.this);

        JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    if (response.getString("status").equals("failed")) {
                        binding.tvBankDetails.setText("Failed Response Invalid IFSC Code");
                    } else {
                        JSONObject dataObj = response.getJSONObject("data");
                        String state = dataObj.optString("STATE");
                        String bankName = dataObj.optString("BANK");
                        String branch = dataObj.optString("BRANCH");
                        String address = dataObj.optString("ADDRESS");
                        String contact = dataObj.optString("CONTACT");
                        String micrcode = dataObj.optString("MICRCODE");
                        String city = dataObj.optString("CITY");

                        binding.tvBankDetails.setText("Bank Name : " + bankName
                                + "\nBranch : " + branch
                                + "\nAddress : " + address
                                + "\nMICR Code : " + micrcode
                                + "\nCity : " + city
                                + "\nState : " + state
                                + "\nContact : " + contact);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    binding.tvBankDetails.setText("Catch Invalid IFSC Code");
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                binding.tvBankDetails.setText("Error Listener Invalid IFSC Code");
            }
        });
        queue.add(objectRequest);
    }
}