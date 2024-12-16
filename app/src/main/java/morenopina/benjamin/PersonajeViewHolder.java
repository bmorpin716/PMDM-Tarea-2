package morenopina.benjamin;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import morenopina.benjamin.databinding.TarjetaPersonajeBinding;

public class PersonajeViewHolder extends RecyclerView.ViewHolder {

    private final TarjetaPersonajeBinding binding;

    public PersonajeViewHolder(TarjetaPersonajeBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind (Personaje personaje){
        Picasso.get()
                .load(personaje.getImagen())
                .into(binding.image);
        binding.name.setText(personaje.getNombre());
        binding.executePendingBindings(); // Asegura que se apliquen los cambios de inmediato
    }
}