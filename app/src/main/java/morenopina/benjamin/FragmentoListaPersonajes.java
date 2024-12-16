package morenopina.benjamin;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import morenopina.benjamin.databinding.ListapersonajesFragmentoBinding;

import java.util.ArrayList;

public class FragmentoListaPersonajes extends Fragment {

    private ListapersonajesFragmentoBinding binding; // Binding para el layout
    private ArrayList<Personaje> personajes; // Lista de personajes
    private PersonajeAdapter adapter; // Adaptador del RecyclerView

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflar el layout utilizando el binding
        binding = ListapersonajesFragmentoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicializa la lista de personajes
        cargaPersonajes(); // Carga los personajes

        // Configurar el RecyclerView
        adapter = new PersonajeAdapter(personajes, getActivity());
        binding.personajesRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.personajesRecyclerview.setAdapter(adapter);


    }

    // Método para cargar los personajes
    private void cargaPersonajes() {
        personajes = new ArrayList<Personaje>();
        // Llena la lista con la información de los personajes
        personajes.add(new Personaje(
                "https://static.wikia.nocookie.net/shipping/images/7/75/Mario.png/revision/latest?cb=20211003000425&path-prefix=es",
                "Mario",
                "El fontanero más famoso",
                "Salto, acrobacias, golpes y patadas"
        ));

        personajes.add(new Personaje(
                "https://static.wikia.nocookie.net/shipping/images/c/c6/Luigi_Mario_Party_Switch.png/revision/latest?cb=20211012192207&path-prefix=es",
                "Luigi",
                "Es el hermano de Mario",
                "Puede ser tonto, ingenuo y torpe a veces, pero se lo considera un héroe dulce, amable, optimista y alegre"
        ));

        personajes.add(new Personaje(
                "https://static.wikia.nocookie.net/shipping/images/6/67/Princesa_Peach.png/revision/latest?cb=20211007004748&path-prefix=es",
                "Peach",
                "Princesa del Reino Champiñón",
                "Ser secuestrada"
        ));

        personajes.add(new Personaje(
                "https://static.wikia.nocookie.net/mario/images/2/2c/Toad_super_mario.png/revision/latest/scale-to-width-down/1000?cb=20161129175624&path-prefix=es",
                "Toad",
                "Simpre lleva un chaleco azul",
                "Toad era el que cuidaba de Peach inicialmente"
        ));


    }


    @Override
    public void onStart() {
        super.onStart();
        // Cambia el título del ActionBar
        if (getActivity() != null) {
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(R.string.lista_de_personajes);
        }
    }
}
