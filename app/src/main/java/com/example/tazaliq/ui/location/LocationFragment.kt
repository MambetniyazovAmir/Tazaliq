package com.example.tazaliq.ui.location

import android.os.Bundle
import android.view.View
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseFragment
import com.example.tazaliq.databinding.FragmentLocationBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import org.osmdroid.api.IMapController

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
        map.map.mapObjects.addPlacemark(Point(41.260772, 69.319158))
        map.map.mapObjects.addPlacemark(Point(41.279593, 69.326689))
        map.map.mapObjects.addPlacemark(Point(41.378876, 69.300856))
        map.map.mapObjects.addPlacemark(Point(41.254784, 69.203488))
    }

    override fun onStop() {
        super.onStop()
        map.onStop()
        MapKitFactory.getInstance().onStop()
    }

}