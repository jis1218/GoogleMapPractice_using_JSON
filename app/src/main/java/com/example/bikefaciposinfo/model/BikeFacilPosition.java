package com.example.bikefaciposinfo.model;

/**
 * Created by 정인섭 on 2017-10-17.
 */

public class BikeFacilPosition {
    private GeoInfoBikeConvenientFacilitiesWGS GeoInfoBikeConvenientFacilitiesWGS;

    public GeoInfoBikeConvenientFacilitiesWGS getGeoInfoBikeConvenientFacilitiesWGS ()
    {
        return GeoInfoBikeConvenientFacilitiesWGS;
    }

    public void setGeoInfoBikeConvenientFacilitiesWGS (GeoInfoBikeConvenientFacilitiesWGS GeoInfoBikeConvenientFacilitiesWGS)
    {
        this.GeoInfoBikeConvenientFacilitiesWGS = GeoInfoBikeConvenientFacilitiesWGS;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [GeoInfoBikeConvenientFacilitiesWGS = "+GeoInfoBikeConvenientFacilitiesWGS+"]";
    }
}
