package mercy.killing.votekeeper.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by KOHA_DESKTOP on 2016. 6. 29..
 */
public class NetworkHelper {
    private Context context;

    public NetworkHelper(Context context) {
        this.context = context;
    }
    public static Retrofit retrofit;
    public static NetworkInterface getNetworkInstance(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://223.54.47.237:3309/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(NetworkInterface.class);
    }

    public static boolean returnNetworkState(Context context){
        final ConnectivityManager connectivityManager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }
}
