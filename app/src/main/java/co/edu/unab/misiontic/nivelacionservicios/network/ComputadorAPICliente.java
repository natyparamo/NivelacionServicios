package co.edu.unab.misiontic.nivelacionservicios.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ComputadorAPICliente {
    private static final String URL = "http://miproyecto.xyz/api/";
    private static ComputadorAPIService instance;

    public static ComputadorAPIService getCComputadorAPIService(){
        if (instance==null){
            Retrofit httpd= new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            instance = httpd.create(ComputadorAPIService.class);
        }
        return instance;

    }

}
