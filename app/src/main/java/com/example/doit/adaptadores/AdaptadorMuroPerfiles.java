package com.example.doit.adaptadores;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doit.vistas.Perfil;
import com.example.doit.R;
import com.example.doit.modelos.PojoPersonal;

import java.util.ArrayList;

public class AdaptadorMuroPerfiles extends RecyclerView.Adapter<AdaptadorMuroPerfiles.MuroPerfilesViewHolder> {

    private Activity contexto;
    private ArrayList<PojoPersonal> pojoPersonalArrayList;

    public AdaptadorMuroPerfiles(Activity contexto, ArrayList<PojoPersonal> pojoPersonalArrayList) {
        this.contexto = contexto;
        this.pojoPersonalArrayList = pojoPersonalArrayList;
    }

    @NonNull
    @Override
    public MuroPerfilesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_muroperfiles, parent, false);

        MuroPerfilesViewHolder muroPerfilesViewHolder=new MuroPerfilesViewHolder(itemView);

        return muroPerfilesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MuroPerfilesViewHolder holder, int position) {

        final PojoPersonal pojoPersonal= pojoPersonalArrayList.get(position);

        holder.iv_foto.setImageResource(pojoPersonal.getFoto());
        
        holder.iv_foto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(contexto, "enviar nombre", Toast.LENGTH_LONG).show();

                Intent intent= new Intent(contexto, Perfil.class);
                intent.putExtra("nombre", pojoPersonal.getNombre());

                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){

                    Explode explode=new Explode();
                    explode.setDuration(1000);
                    contexto.getWindow().setExitTransition(explode);
                    contexto.startActivity(intent,
                            ActivityOptions.makeSceneTransitionAnimation(contexto, view, "animacion").toBundle());
                }else {
                    contexto.startActivity(intent);
                }
            }
        });

        holder.tv_nombre.setText(pojoPersonal.getNombre());
        holder.rb_calificacion.setRating(pojoPersonal.getCalificacion());

    }

    @Override
    public int getItemCount() {
        return pojoPersonalArrayList.size();
    }


    public class MuroPerfilesViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv_foto;
        private TextView tv_nombre;
        private RatingBar rb_calificacion;

        public MuroPerfilesViewHolder(@NonNull View itemView) {

            super(itemView);

            iv_foto= itemView.findViewById(R.id.iv_foto);
            tv_nombre= itemView.findViewById(R.id.tv_nombre);
            rb_calificacion= itemView.findViewById(R.id.rb_calificacion);

        }
    }
}
