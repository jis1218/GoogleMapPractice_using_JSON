##### Activity를 만들 때 MapActivity로 생성하게 되면 GoogleMap 클래스를 사용할 수 있는 Activity가 만들어진다.
##### res에 values에 보면 google_map_api.xml 파일이 있는데 구글에서 API 키를 받아 넣으면 된다.
```
<string name="google_maps_key" templateMergeStrategy="preserve" translatable="false">AIzaSyDquGL_UKK713OsDQvy6bTDW8FPL2mabcY</string>
</resources>
```

##### 먼저 mapFragment를 불러오고 나서
```java
mapFragment = (SupportMapFragment) getSupportFragmentManager()
               .findFragmentById(R.id.map);
```

##### 그 다음  mapFragment.getMapAsync(MapsActivity.this)를 통해 onMapReadyCallback interface를 implement 하고 있는 object이 trigger되게 한다.
##### getMapAsync(onMapReadyCallback callback)에 대한 구글 API 설명
##### Sets a callback object which will be triggered when the GoogleMap instance is ready to be used.
Note that:
This method must be called from the main thread.
The callback will be executed in the main thread.
In the case where Google Play services is not installed on the user's device, the callback will not be triggered until the user installs it.
In the rare case where the GoogleMap is destroyed immediately after creation, the callback is not triggered.
The GoogleMap object provided by the callback is non-null.

##### callback이 되고 나서 onMapReady() 호출 됨
##### JSON으로 받은 지하철 정보를 row[]에 담아 for문으로 구글 지도 위에 정보를 표시해 줄 수 있음
