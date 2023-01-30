package APIFETCH1;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class APIFETCH1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			getApi();
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}

	}
	public static void getApi() throws URISyntaxException, ClientProtocolException, IOException, APINOTFOUNDEXCEPTION {
		URIBuilder url = new URIBuilder("https://api.chucknorris.io/jokes/random");
		HttpGet detdata = new HttpGet(url.build());
		CloseableHttpClient httpclient = HttpClients.createDefault();
		CloseableHttpResponse response = httpclient.execute(detdata);
		if(response.getStatusLine().getStatusCode()==200) {
			HttpEntity enti = response.getEntity();
			String s = EntityUtils.toString(enti);
			System.out.println(s);
//			JSONObject j = new JSONObject(s);
//			System.out.println(j);
		}else {
			throw new APINOTFOUNDEXCEPTION("NOT FOUND");
		}
	}
}
