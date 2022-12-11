package co.edu.unab.misiontic.nivelacionservicios;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import co.edu.unab.misiontic.nivelacionservicios.entity.Computador;
import co.edu.unab.misiontic.nivelacionservicios.network.ComputadorAPICliente;
import co.edu.unab.misiontic.nivelacionservicios.network.ComputadorAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ComputadorAPIService service;
    private ListView lista;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        service= ComputadorAPICliente.getCComputadorAPIService();
        lista=findViewById(R.id.lista);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Computador computador = (Computador) lista.getItemAtPosition(position);
                Intent intent = new (MainActivity.this,
                EditComputadorActivity.class);
                intent.putExtra("idComputador", computador.getId());
                llamado.launch(intent);
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        cargarDatos();
    }

    private void cargarDatos (){
        service.getComputadores().enqueue(new Callback<List<Computador>>() {
            @Override
            public void onResponse(Call<List<Computador>> call, Response<List<Computador>> response) {
                if (response.isSuccessful()){
                    List<Computador> computadores = response.body();
                    mostrarDatos(computadores);
                }
            }
            @Override
            public void onFailure(Call<List<Computador>> call, Throwable t) {

            }
        });
    }
    private void mostrarDatos(List<Computador> computadores){
        ArrayAdapter<Computador> adapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                computadores
        );
        lista.setAdapter(adapter);
    }
    public void salir(View view){
        finish();
    }
    public void agrerar(View view){
        Intent intent = new Intent(MainActivity.this,
                AddComputadorActivity.class);
        llamado.launch((intent));
    }
    ActivityResultLauncher<Intent> llamado = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode()==RESULT_OK){
                        cargarDatos();
                    }
                }
            }
    );
}