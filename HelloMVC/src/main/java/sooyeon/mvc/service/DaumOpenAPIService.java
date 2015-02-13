package sooyeon.mvc.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import kr.or.kobis.kobisopenapi.consumer.rest.KobisOpenAPIRestService;
import kr.or.kobis.kobisopenapi.consumer.rest.exception.OpenAPIFault;

public class DaumOpenAPIService {
	private String apikey;
	private String host;

	public DaumOpenAPIService(String key) {
		this.apikey = apikey;
		this.host = "http://apis.daum.net/contents/movie";
	}

	static class RequestUtil {
		static Map<Boolean, String> requestGet(String urlStr) throws Exception {
			URL url = new URL(urlStr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			BufferedReader rd = null;
			boolean isSuc = true;
			try {
				rd = new BufferedReader(new InputStreamReader(
						conn.getInputStream(), "UTF-8"));
			} catch (Exception e) {
				isSuc = false;
				if (conn != null
						&& conn.getResponseCode() == HttpURLConnection.HTTP_INTERNAL_ERROR) {
					rd = new BufferedReader(new InputStreamReader(
							conn.getErrorStream(), "UTF-8"));
				} else {
					throw e;
				}
			}
			String line = null;
			StringBuffer sb = new StringBuffer();
			while ((line = rd.readLine()) != null) {
				sb.append(line).append("\n");
			}
			rd.close();
			Map<Boolean, String> returnMap = new HashMap<Boolean, String>();
			returnMap.put(isSuc, sb.toString());
			return returnMap;
		}

		protected static String requestGet(String apikey, String host,
				boolean isJson, Map paramMap) throws OpenAPIFault, Exception {
			paramMap.put("apikey", apikey);
			StringBuffer sb = new StringBuffer(256);
			sb.append(host).append(isJson ? ".json" : ".xml")
					.append(DaumOpenAPIService.mapToQueryString(paramMap));
			Map<Boolean, String> returnMap = RequestUtil.requestGet(sb
					.toString());
			if (returnMap.get(Boolean.TRUE) == null)
				throw new OpenAPIFault(returnMap.get(Boolean.FALSE));
			return returnMap.get(Boolean.TRUE);
		}
	}

	// 요청방식 : (host) + ? q=2012 & apikey=
	public static String mapToQueryString(Map<String, Object> map)
			throws Exception {
		StringBuilder string = new StringBuilder();
		for (Entry<String, Object> entry : map.entrySet()) {
			if (entry.getValue() instanceof String
					&& entry.getValue().toString().length() > 0) {
				string.append("&apikey=");
				string.append(URLEncoder.encode((String) entry.getValue(),
						"UTF-8"));
			} else if (entry.getValue() instanceof String[]) {
				String[] arr = (String[]) entry.getValue();
				if (arr != null) {
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] != null && arr[i].length() > 0) {
							string.append("&");
							string.append(entry.getKey());
							string.append("=");
							string.append(URLEncoder.encode(arr[i], "UTF-8"));
						}
					}
				}
			}
		}
		return string.toString().replaceFirst("[&]", "?");
	}

	public String getMovieList(boolean isJson, Map paramMap)
			throws OpenAPIFault, Exception {
		return RequestUtil.requestGet(apikey, host, isJson, paramMap);
	}

	public String getMovieList(String q, String pageno, String result,
			String output) throws OpenAPIFault, Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("q", q);
		paramMap.put("pageno", pageno);
		paramMap.put("result", result);
		paramMap.put("output", output);
		boolean isJson;
		if (output.equals("json")) {
			isJson = true;
		} else {
			isJson = false;
		}
		return getMovieList(isJson, paramMap);
	}
	
	public String getMovieInfo(boolean isJson,Map paramMap) throws OpenAPIFault, Exception{
		return RequestUtil.requestGet(apikey, host, isJson, paramMap);
	}
	
	public String getMovieInfo(boolean isJson, String q) throws OpenAPIFault, Exception{
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("q", q);
		return getMovieInfo(isJson,paramMap);
	}
	 
}