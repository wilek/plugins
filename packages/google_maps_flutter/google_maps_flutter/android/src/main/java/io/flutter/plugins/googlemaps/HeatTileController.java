// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.google.maps.android.heatmaps.WeightedLatLng;

import java.util.List;

/** Controller of a single Heat Tile on the map. */
class HeatTileController implements HeatTileOptionsSink {
  private final HeatmapTileProvider tile;

  HeatTileController(HeatmapTileProvider tile) {
    this.tile = tile;
  }

  @Override
  public void setGradient(Gradient gradient) {
    tile.setGradient(gradient);
  }

  @Override
  public void setOpacity(double opacity) {
    tile.setOpacity(opacity);
  }

  @Override
  public void setRadius(int radius) {
    tile.setRadius(radius);
  }

  @Override
  public void setMaxIntensity(double intensity) {
    tile.setMaxIntensity(intensity);
  }

  @Override
  public void setData(List<LatLng> data) {
    tile.setData(data);
  }

  @Override
  public void setWeightedCollection(List<WeightedLatLng> data) {
    tile.setWeightedData(data);
  }
}