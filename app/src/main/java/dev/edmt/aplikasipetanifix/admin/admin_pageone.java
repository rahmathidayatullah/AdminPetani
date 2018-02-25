package dev.edmt.aplikasipetanifix.admin;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import dev.edmt.aplikasipetanifix.R;

public class admin_pageone extends Fragment {


    private Button btnslot;
    private Button btnkoordinat;
    private Button btnhapusakun;
    private Button btnbuatakun;
    private Button btntambahsaldo;
    private Button btnverifikasi;
    private Button btnlaporan;


    View view;

    public admin_pageone() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.admin_pageone, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.view=view;
        btnslot();
        btnkoordinat();
        btnhapusakun();
        btnbuatakun();
        btntambahsaldo();
        btnverifikasi();
        btnlaporan();

    }

    private void btnbuatakun() {
        btnbuatakun = (Button)view.findViewById(R.id.btnbuatakun);
        btnbuatakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),admin_buatakunpetani.class);
                startActivity(intent);
            }
        });
    }

    private void btntambahsaldo() {
        btntambahsaldo = (Button)view.findViewById(R.id.btntambahsaldo);
        btntambahsaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),admin_verifikasi.class);
                startActivity(intent);
            }
        });
    }

    private void btnverifikasi() {
        btnverifikasi = (Button)view.findViewById(R.id.btnverifikasi);
        btnverifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),admin_verifikasi.class);
                startActivity(intent);
            }
        });

    }

    private void btnlaporan() {
        btnlaporan = (Button)view.findViewById(R.id.btnlaporan);
        btnlaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),admin_laporan.class);
                startActivity(intent);
            }
        });

    }

    private void btnhapusakun() {
        btnhapusakun = (Button)view.findViewById(R.id.btnhapusakun);
        btnhapusakun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),admin_hapusakun.class);
                startActivity(intent);
            }
        });

    }

    public void btnslot() {

        btnslot = (Button)view.findViewById(R.id.btnslot);
        btnslot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),admin_slot.class);
                startActivity(intent);
            }
        });

    }

    private void btnkoordinat() {


        btnkoordinat = (Button)view.findViewById(R.id.btntambahkoordinat);
        btnkoordinat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),admin_tambahkordinatlahan.class);
                startActivity(intent);
            }
        });
    }




}
