package morenopina.benjamin;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import morenopina.benjamin.databinding.InfopersonajeFragmentoBinding;

public class FragmentoDetallePersonaje extends Fragment {

    private InfopersonajeFragmentoBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflar el layout para este fragmento
        binding = InfopersonajeFragmentoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtener datos del argumento que inicia este fragmento
        if (getArguments() != null) {
            String imagen = getArguments().getString("imagen");
            String nombre = getArguments().getString("nombre");
            String descripcion = getArguments().getString("descripcion");
            String habilidades = getArguments().getString("habilidades");

            // Asignar los datos a los componentes
            Picasso.get()
                    .load(imagen)
                    .into(binding.imagen);
            binding.nombre.setText(nombre);
            binding.descripcion.setText(descripcion);
            binding.habilidades.setText(habilidades);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.detalles_personajes);
        }
    }
}