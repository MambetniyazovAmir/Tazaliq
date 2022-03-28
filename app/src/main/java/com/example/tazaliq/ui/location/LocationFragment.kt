package com.example.tazaliq.ui.location

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.databinding.FragmentLocationBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.overlay.Marker

class LocationFragment : BaseFragment(R.layout.fragment_location) {
    private lateinit var map: MapView
    private lateinit var mapController: IMapController
    private lateinit var binding: FragmentLocationBinding

    override fun onStart() {
        super.onStart()
        map.onStart()
        MapKitFactory.getInstance().onStart()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLocationBinding.bind(view)
        map = binding.mapView
        map.map.move(
            CameraPosition(Point(41.309850, 69.279035), 13.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 0f),
            null
        )
//        val ctx = requireContext().applicationContext
//        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
//        map.setTileSource(TileSourceFactory.MAPNIK)
//        map.zoomController.setVisibility(CustomZoomButtonsController.Visibility.NEVER)
//        map.setMultiTouchControls(true)
//        val marker = Marker(map)
//        mapController = map.controller
//        mapController.setZoom(15)
//        val startPoint = GeoPoint(42.442424, 59.632228);
//        marker.position = startPoint
//        map.overlays.add(marker)
//        mapController.setCenter(startPoint)

    }

    override fun onStop() {
        super.onStop()
        map.onStop()
        MapKitFactory.getInstance().onStop()
    }

}