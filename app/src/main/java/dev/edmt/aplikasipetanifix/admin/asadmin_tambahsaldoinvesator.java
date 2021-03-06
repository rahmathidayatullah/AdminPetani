package dev.edmt.aplikasipetanifix.admin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import dev.edmt.aplikasipetanifix.R;
import dev.edmt.aplikasipetanifix.admin.adapter.as_investor_rv;
import dev.edmt.aplikasipetanifix.admin.model.saldo;

/**
 * Created by Herdi_WORK on 18.06.17.
 */

public class asadmin_tambahsaldoinvesator extends AppCompatActivity implements as_investor_rv.FirebaseDataListener {

    /**
     * Mendefinisikan variable yang akan dipakai
     */
    private DatabaseReference database;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<saldo> daftarSaldoInvestor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * Mengeset layout
         */
        setContentView(R.layout.as_activity_investor_read);

        /**
         * Inisialisasi RecyclerView & komponennya
         */

        rvView = (RecyclerView) findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);


        /**
         * Inisialisasi dan mengambil Firebase Database Reference
         */
        database = FirebaseDatabase.getInstance().getReference();

        /**
         * Mengambil data barang dari Firebase Realtime DB
         */
        database.child("INVESTOR-req").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                /**
                 * Saat ada data baru, masukkan datanya ke ArrayList
                 */
                daftarSaldoInvestor = new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                    /**
                     * Mapping data pada DataSnapshot ke dalam object saldo
                     * Dan juga menyimpan primary key pada object saldo
                     * untuk keperluan Edit dan Delete data
                     */
                    saldo saldo = noteDataSnapshot.getValue(saldo.class);
                    saldo.setKey(noteDataSnapshot.getKey());

                    /**
                     * Menambahkan object saldo yang sudah dimapping
                     * ke dalam ArrayList
                     */
                    daftarSaldoInvestor.add(saldo);
                }

                /**
                 * Inisialisasi adapter dan data barang dalam bentuk ArrayList
                 * dan mengeset Adapter ke dalam RecyclerView
                 */
                adapter = new as_investor_rv(daftarSaldoInvestor, asadmin_tambahsaldoinvesator.this);
                rvView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                /**
                 * Kode ini akan dipanggil ketika ada error dan
                 * pengambilan data gagal dan memprint error nya
                 * ke LogCat
                 */
                System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity, asadmin_tambahsaldoinvesator.class);
    }

    @Override
    public void onDeleteData(saldo saldo, final int position) {
        /**
         * Kode ini akan dipanggil ketika method onDeleteData
         * dipanggil dari adapter lewat interface.
         * Yang kemudian akan mendelete data di Firebase Realtime DB
         * berdasarkan key saldo.
         * Jika sukses akan memunculkan SnackBar
         */
        if(database!=null){
            database.child("INVESTOR-req").child(saldo.getKey()).removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(asadmin_tambahsaldoinvesator.this,"success delete", Toast.LENGTH_LONG).show();
                }
            });

        }
    }

    public void tambahsaldoinvestor(View view) {
        Intent ganti = new Intent(asadmin_tambahsaldoinvesator.this,bs_admin_tambahsaldoinvesator.class);
        startActivity(ganti);
    }
}
