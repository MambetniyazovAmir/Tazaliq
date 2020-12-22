package com.example.tazaliq.ui.location

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceManager
import com.example.tazaliq.R
import com.example.tazaliq.databinding.FragmentLocationBinding
import org.osmdroid.api.IMapController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

class LocationFragment : Fragment(R.layout.fragment_location) {
    private lateinit var map: MapView
    private lateinit var mapController: IMapController
    private lateinit var binding: FragmentLocationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLocationBinding.bind(view)
        map = binding.mapView
        val ctx = requireContext().applicationContext
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx))
        map.setTileSource(TileSourceFactory.MAPNIK)
        map.setBuiltInZoomControls(false)
        map.setMultiTouchControls(true)
        val marker = Marker(map)
        mapController = map.controller
        mapController.setZoom(15)
        val startPoint = GeoPoint(42.442424, 59.632228);
        marker.position = startPoint
        map.overlays.add(marker)
        mapController.setCenter(startPoint)
    }
}