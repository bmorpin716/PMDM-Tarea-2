package morenopina.benjamin;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import morenopina.benjamin.databinding.TarjetaPersonajeBinding;
import android.view.View;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeViewHolder> {

    private final ArrayList<Personaje> personajes;
    private final Context context;

    public PersonajeAdapter(ArrayList<Personaje> personajes, Context context){
        this.personajes = personajes;
        this.context = context;
    }

    // Método que crea el ViewHolder
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TarjetaPersonajeBinding binding = TarjetaPersonajeBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent,false
        );
        return new PersonajeViewHolder(binding);
    }

    //    Método para enlazar datos con el ViewHolder
    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personajeSeleccionado = this.personajes.get(position);
        holder.bind(personajeSeleccionado);

//        Manejar el evento de clic
        holder.itemView.setOnClickListener(view -> itemClicked(personajeSeleccionado, view));
    }

    @Override
    public int getItemCount() {
        return personajes.size();
    }

    private void itemClicked(Personaje personajeSeleccionado, View view) {
        // Llama a la función personajeClicado de MainActivity, pasando la vista
        ((MainActivity) context).personajeClicado(personajeSeleccionado, view);
    }
}