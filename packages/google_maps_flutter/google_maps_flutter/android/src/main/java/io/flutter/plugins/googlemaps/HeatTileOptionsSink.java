// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.WeightedLatLng;

import java.util.List;

/** Receiver of Heat configuration options. */
interface HeatTileOptionsSink {

  void setGradient(Gradient gradient);

  void setOpacity(double opacity);

  void setRadius(int radius);

  void setMaxIntensity(double intensity);

  void setData(List<LatLng> data);

  void setWeightedCollection(List<WeightedLatLng> data);
}