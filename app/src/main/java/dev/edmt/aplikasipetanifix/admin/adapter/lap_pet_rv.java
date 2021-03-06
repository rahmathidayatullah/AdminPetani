package dev.edmt.aplikasipetanifix.admin.adapter;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import dev.edmt.aplikasipetanifix.R;
import dev.edmt.aplikasipetanifix.admin.lap_admin_pet;
import dev.edmt.aplikasipetanifix.admin.lap_admin_pet_singgle;
import dev.edmt.aplikasipetanifix.admin.model.lap_pet_ku;

public class lap_pet_rv extends RecyclerView.Adapter<lap_pet_rv.ViewHolder> {

    private ArrayList<lap_pet_ku> daftarBsSaldo;
    private Context context;
    FirebaseDataListener listener;

    public lap_pet_rv(ArrayList<lap_pet_ku> hap_kuses, Context ctx){
        /**
         * Inisiasi data dan variabel yang akan digunakan
         */
        daftarBsSaldo = hap_kuses;
        context = ctx;
        listener = (lap_admin_pet)ctx;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        /**
         * Inisiasi View
         * Di tutorial ini kita hanya menggunakan data String untuk tiap item
         * dan juga view nya hanyalah satu TextView
         */
        TextView tvTitle;
        CardView cvMain;

        ViewHolder(View v) {
            super(v);
            tvTitle = (TextView) v.findViewById(R.id.tv_saldo_petani);
            cvMain = (CardView) v.findViewById(R.id.cv_main);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         *  Inisiasi ViewHolder
         */
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_saldo_petani, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        /**
         *  Menampilkan data pada view
         */
        final String name = daftarBsSaldo.get(position).getemail();
        System.out.println("BARANG DATA one by one "+position+ daftarBsSaldo.size());
        holder.cvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Read detail data
                 */
                context.startActivity(lap_admin_pet_singgle.getActIntent((Activity) context).putExtra("data", daftarBsSaldo.get(position)));
            }
        });
        holder.cvMain.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                /**
                 *  Kodingan untuk tutorial Selanjutnya :p Delete dan update data
                 */
                final Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.ha_dialog_view);
                dialog.setTitle("Pilih Aksi");
                dialog.show();

                Button delButton = (Button) dialog.findViewById(R.id.bt_delete_data);

                //apabila tombol delete diklik
                delButton.setOnClickListener(
                        new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                dialog.dismiss();
                                listener.onDeleteData(daftarBsSaldo.get(position), position);
                            }
                        }
                );
                return true;
            }
        });
        holder.tvTitle.setText(name);
    }

    @Override
    public int getItemCount() {
        /**
         * Mengembalikan jumlah item pada barang
         */
        return daftarBsSaldo.size();
    }

    public interface FirebaseDataListener{
        void onDeleteData(lap_pet_ku lap_pet_ku, int position);
    }
}
