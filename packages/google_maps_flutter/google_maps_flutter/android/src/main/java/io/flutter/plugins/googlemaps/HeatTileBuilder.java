// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.heatmaps.Gradient;
import com.google.maps.android.heatmaps.HeatmapTileProvider;
import com.google.maps.android.heatmaps.WeightedLatLng;

import java.util.List;

class HeatTileBuilder implements HeatTileOptionsSink {
  private final HeatmapTileProvider.Builder optionsBuilder;

  HeatTileBuilder() {
    this.optionsBuilder = new HeatmapTileProvider.Builder();
  }

  HeatmapTileProvider build() {
    return optionsBuilder.build();
  }

  @Override
  public void setGradient(Gradient gradient) {
    optionsBuilder.gradient(gradient);
  }

  @Override
  public void setOpacity(double opacity) {
    optionsBuilder.opacity(opacity);
  }

  @Override
  public void setRadius(int radius) {
    optionsBuilder.radius(radius);
  }

  @Override
  public void setMaxIntensity(double intensity) {
    optionsBuilder.maxIntensity(intensity);
  }

  @Override
  public void setData(List<LatLng> data) {
    optionsBuilder.data(data);
  }

  @Override
  public void setWeightedCollection(List<WeightedLatLng> data) {
    optionsBuilder.weightedData(data);
  }
}
