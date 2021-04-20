// Copyright 2013 The Flutter Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.maps.android.heatmaps.HeatmapTileProvider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class HeatTilesController {

  private final Map<String, TileOverlayController> heatTileIdToController;
  private GoogleMap googleMap;

  HeatTilesController() {
    this.heatTileIdToController = new HashMap<>();
  }

  void setGoogleMap(GoogleMap googleMap) {
    this.googleMap = googleMap;
  }

  void addHeatTiles(List<Object> heatTilesToAdd) {
    if (heatTilesToAdd != null) {
      for (Object heatTileToAdd : heatTilesToAdd) {
         addHeatTitle(heatTileToAdd);
      }
    }
  }

  private void addHeatTitle(Object heatTile) {
    if (heatTile == null) {
      return;
    }
    HeatTileBuilder heatTileBuilder = new HeatTileBuilder();
    String heatTileId = Convert.interpretHeatTileOptions(heatTile, heatTileBuilder);
    HeatmapTileProvider tile = heatTileBuilder.build();
    addHeatTile(heatTileId, tile);
  }

  private void addHeatTile(String heatTileId, HeatmapTileProvider tile) {
    final TileOverlay polygon = googleMap.addTileOverlay(new TileOverlayOptions().tileProvider(tile));
    TileOverlayController tileOverlayController = new TileOverlayController(polygon);
    heatTileIdToController.put(heatTileId, tileOverlayController);
  }

  void removeHeatTiles(List<Object> heatTileIdsToRemove) {
    if (heatTileIdsToRemove == null) {
      return;
    }
    for (Object heatTileIdToRemove : heatTileIdsToRemove) {
      if (heatTileIdToRemove == null) {
        continue;
      }

      String heatTileId = (String) heatTileIdToRemove;
      final TileOverlayController controller = heatTileIdToController.remove(heatTileId);
      if (controller != null) {
        controller.remove();
      }
    }
  }

  void clearTileCache(String heatTileId) {
    if (heatTileId == null) {
      return;
    }
    TileOverlayController tileOverlayController = heatTileIdToController.get(heatTileId);
    if (tileOverlayController != null) {
      tileOverlayController.clearTileCache();
    }
  }
}