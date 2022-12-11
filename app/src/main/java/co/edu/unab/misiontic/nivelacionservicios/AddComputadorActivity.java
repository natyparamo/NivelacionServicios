package co.edu.unab.misiontic.nivelacionservicios;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.edu.unab.misiontic.nivelacionservicios.entity.Computador;
import co.edu.unab.misiontic.nivelacionservicios.network.ComputadorAPICliente;
import co.edu.unab.misiontic.nivelacionservicios.network.ComputadorAPIService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddComputadorActivity extends AppCompatActivity {
    private ComputadorAPIService service;
    private EditText txtCodigo, txtMarca, TxtSerial, txtSO, txtRm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_computador);
        service= ComputadorAPICliente.getCComputadorAPIService();
        setup();
        }
    private void setup(){
        txtCodigo=findViewById(R.id.txtCodigo);
        txtMarca=findViewById(R.id.txtMarca);
        TxtSerial=findViewById(R.id.txtSerial);
        txtSO=findViewById(R.id.txtSO);
        txtRm=findViewById(R.id.txtRm);
    }
    public void volver(View view){
        setResult(RESULT_CANCELED);
        finish();
    }
    public void guardar(View view){
        String codigo = txtCodigo.getText().toString();
        String marca = txtMarca.getText().toString();
        String serial = TxtSerial.getText().toString();
        String so = txtSO.getText().toString();
        String ram = txtRm.getText().toString();

        Computador computador = new Computador();
        computador.setCodigo(codigo);
        computador.setMarca(marca);
        computador.setSerial(Long.parseLong(serial));
        computador.setSO(so);
        computador.setRam_gb(Integer.parseInt(ram));

        service.addComputador(computador).enqueue(new Callback<Computador>() {
            @Override
            public void onResponse(Call<Computador> call, Response<Computador> response) {
                if (response.isSuccessful()) {
                    setResult(RESULT_OK);
                    finish();
                }
                else {
                    Toast.makeText(AddComputadorActivity.this,
                            "ERROR AL GUARDAR", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<Computador> call, Throwable t) {
                Toast.makeText(AddComputadorActivity.this,
                        "ERROR"+t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}