package co.edu.unab.misiontic.nivelacionservicios.network;

import java.util.List;

import co.edu.unab.misiontic.nivelacionservicios.entity.Computador;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ComputadorAPIService {
    @GET("computador")
    Call<List<Computador>> getComputadores();

    @GET("computador/{id}")
    Call<Computador> getComputador(@Path("id")long id);

    @POST("computador")
    Call<Computador>addComputador(@Body Computador computador);

    @DELETE("computador/{id}")
    Call<Computador> deleteComputador(@Path("id")long id);

    @PUT ("computador/{id}")
    Call<Computador> updateComputador(@Path("id")long id, @Body Computador computador);
}

