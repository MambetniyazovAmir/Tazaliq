package com.example.tazaliq.location

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.example.tazaliq.R
import com.example.tazaliq.databinding.FragmentLocationBinding
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView


class LocationFragment : Fragment(R.layout.fragment_location) {
    private lateinit var map: MapView
    private lateinit var mapController: IMapController
    private lateinit var binding: FragmentLocationBinding
    private val TAG = "OsmActivity";


    private val PERMISSION_REQUEST_CODE = 1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLocationBinding.bind(view)
        map = binding.mapView
        val ctx = requireContext().applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        if (Build.VERSION.SDK_INT >= 23) {

        }
        map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
        // map.setBuiltInZoomControls(true)
        map.setMultiTouchControls(true)
        mapController = map.controller
        mapController.setZoom(15)
        val startPoint = GeoPoint(42.442424, 59.632228);
        mapController.setCenter(startPoint)
    }
//    public boolean isStoragePermissionGranted()
//    {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                == PackageManager.PERMISSION_GRANTED &amp;&amp; checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
//            == PackageManager.PERMISSION_GRANTED) {
//                Log.v(TAG, "Permission is granted");
//                return true;
//            } else {
//
//                Log.v(TAG, "Permission is revoked");
//                ActivityCompat.requestPermissions(
//                    this,
//                    new String []{ Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION },
//                    1
//                );
//                return false;
//            }
//        } else { //permission is automatically granted on sdk<23 upon installation
//            Log.v(TAG, "Permission is granted");
//            return true;
//        }
//    }
}

//    //load/initialize the osmdroid configuration, this can be done
//    Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
//    //setting this before the layout is inflated is a good idea
//    //it 'should' ensure that the map has a writable location for the map cache, even without permissions
//    //if no tiles are displayed, you can try overriding the cache path using Configuration.getInstance().setCachePath
//    //see also StorageUtils
//    //note, the load method also sets the HTTP User Agent to your application's package name, abusing osm's tile servers will get you banned based on this string
//
//    //inflate and create the map
//
//    setContentView(R.layout.activity_main);
//
//
//    if (Build.VERSION.SDK_INT >= 23) {
//        if (isStoragePermissionGranted()){
//
//        }
//    }
//
//
//    map = findViewById(R.id.mapView);
//    map.setTileSource(TileSourceFactory.MAPNIK);
//    map.setBuiltInZoomControls(true);
//    map.setMultiTouchControls(true);
//    mapController = map.getController();
//    mapController.setZoom(15);
//    GeoPoint startPoint = new GeoPoint(51496994, -134733);
//    mapController.setCenter(startPoint);
//}
//
//import android.content.Context
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import com.example.tazaliq.R
//import org.osmdroid.api.IMapController
//import org.osmdroid.views.MapView
//
//
//    public void onResume() {
//        super.onResume();
//        //this will refresh the osmdroid configuration on resuming.
//        //if you make changes to the configuration, use
//        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
//        if (map != null)
//            map.onResume(); //needed for compass, my location overlays, v6.0.0 and up
//    }
//
//    public void onPause() {
//        super.onPause();
//        //this will refresh the osmdroid configuration on resuming.
//        //if you make changes to the configuration, use
//        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
//        //Configuration.getInstance().save(this, prefs);
//        if (map != null)
//            map.onPause();  //needed for compass, my location overlays, v6.0.0 and up
//    }
//
//
//    public boolean isStoragePermissionGranted() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                == PackageManager.PERMISSION_GRANTED &amp;&amp; checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
//            == PackageManager.PERMISSION_GRANTED) {
//                Log.v(TAG, "Permission is granted");
//                return true;
//            } else {
//
//                Log.v(TAG, "Permission is revoked");
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//                return false;
//            }
//        } else { //permission is automatically granted on sdk<23 upon installation
//            Log.v(TAG, "Permission is granted");
//            return true;
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (grantResults.length > 0 &amp;&amp; grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            Log.v(TAG, "Permission: " + permissions[0] + "was " + grantResults[0]);
//            //resume tasks needing this permission
//        }
//    }
//}