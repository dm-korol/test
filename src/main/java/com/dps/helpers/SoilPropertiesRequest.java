package com.dps.helpers;

import com.dps.vo.SoilPropsVO;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class SoilPropertiesRequest {

    public static SoilPropsVO getSoil(Double lon, Double lat) {
        String uri = String.format("https://rest.isric.org/soilgrids/v2.0/properties/query?lon=%s&lat=%s&property=clay&property=sand&property=silt&value=mean", lon, lat);
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        SoilPropsVO soilPropsVO = new SoilPropsVO();
        List<Integer> siltValues = new ArrayList<Integer>();
        List<Integer> clayValues = new ArrayList<Integer>();
        List<Integer> sandValues = new ArrayList<Integer>();
        try {
            assert result != null;
            JSONObject obj = new JSONObject(result);
            JSONArray array = obj.getJSONObject("properties").getJSONArray("layers");
            for (int i = 0; i < array.length(); i++) {
                String name = array.getJSONObject(i).getString("name");
                JSONArray soilArr = array.getJSONObject(i).getJSONArray("depths");
                for (int j = 0; j < soilArr.length(); j++) {
                    int mean = soilArr.getJSONObject(j).getJSONObject("values").getInt("mean");
                    switch (name){
                        case "sand":
                            sandValues.add(mean);
                            break;
                        case "clay":
                            clayValues.add(mean);
                            break;
                        case "silt":
                            siltValues.add(mean);
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        soilPropsVO.setClayValues(clayValues);
        soilPropsVO.setSandValues(sandValues);
        soilPropsVO.setSiltValues(siltValues);
        return soilPropsVO;
    }
}
