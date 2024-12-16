package morenopina.benjamin;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import morenopina.benjamin.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Obtener la toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Cambiamos el titulo de la toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Lista de personajes");
        }

        // Configura el NavController
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController);



    }

    // Método para manejar el clic sobre un personaje
    public void personajeClicado(Personaje personaje, View view) {
        // Crear un Bundle para pasar los datos al Fragmento de detalle del personaje
        Bundle bundle = new Bundle();
        bundle.putString("nombre", personaje.getNombre()); // Pasa el nombre del personaje
        bundle.putString("habilidades", String.valueOf(personaje.getHabilidades())); // Habilidades del personaje
        bundle.putString("imagen", personaje.getImagen()); // Pasa la imagen del personaje
        bundle.putString("descripcion", personaje.getDescripcion()); // Pasa la descripción del personaje

        // Navegar al Fragmento de detalle del personaje con el Bundle
        Navigation.findNavController(view).navigate(R.id.fragmentoDetallePersonaje, bundle);
    }
    @Override
    public boolean onSupportNavigateUp() {
        // Utiliza el método navigateUp del NavController
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

}