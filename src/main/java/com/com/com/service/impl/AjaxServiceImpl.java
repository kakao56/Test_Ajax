package com.com.com.service.impl;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.com.com.service.AjaxService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
@Service("service")
public class AjaxServiceImpl implements AjaxService {

	@Override
	public List<String> search(Map<String, Object> map) throws Exception{
		map.get("searchValue");
		RestTemplate template = new RestTemplate();
		String apiURL = "https://dapi.kakao.com/v2/search/image?query="+URLEncoder.encode(map.get("searchValue").toString(), "UTF-8")+"&sort=accuracy&page=1&size=20";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "KakaoAK 9a41064923c73b28ffda8a0e9b01fca4");
		ResponseEntity<String> response = null;
		try {
			HttpEntity<String> rq = new HttpEntity<String>(headers);
			response = template.exchange(apiURL, HttpMethod.GET, rq, String.class);
		}catch (Exception e) {
			// TODO: handle exception
		}
		Object obj = null;
		JsonParser parser = new JsonParser();
		JsonObject jobj = (JsonObject)parser.parse(response.getBody());
//		System.out.println(jobj);
		JsonArray jar = jobj.getAsJsonArray("documents");
//		System.out.println(jar);
		int i = 0;
		List <String> imgList = new ArrayList<String>();
		for(JsonElement j : jar) {
			i++;
			obj = parser.parse(j.toString());
			jobj = (JsonObject) obj;
//			System.out.println(jobj);
			if(jobj.get("image_url") != null) {
//				System.out.println(jobj.get("image_url").getAsString()); 
				imgList.add(jobj.get("image_url").getAsString());
			}
		}
		return imgList;
	}

}
