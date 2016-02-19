package projects.devdreamers.nearbymeapp.Network;

import projects.devdreamers.nearbymeapp.Model.AccessToken;
import projects.devdreamers.nearbymeapp.Model.Data;
import projects.devdreamers.nearbymeapp.Model.Response;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by admin on 2/15/2016.
 */
public interface InstagramCalls {


    @GET("?client_id={id_app}&redirect_uri={uri_app}&response_type=code")
    Call<Response> getPermission(@Path("id_app")String id,@Path("uri_app")String uri);

    @GET("?client_id={id_app}&redirect_uri={uri_app}&response_type=token")
    Call<AccessToken> getToken(@Path("id_app")String id,@Path("uri_app")String uri);

    @GET("https://api.instagram.com/v1/media/search?lat={lat}&lng={long}&access_token={token}")
    Call<Data> getNearPost(@Path("lat") double lat, @Field("long")double lon,@Path("token") String token);

}
