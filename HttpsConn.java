import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;


public class HttpsConn {
	
	public static void main(String[] args)
	{
	
		try{
		URL url=new URL("https://google.com");
		HttpURLConnection huc=(HttpURLConnection)url.openConnection();
		//huc.setDoOutput(true);
		huc.getInputStream();
		//String cipherSuite=huc.getCipherSuite();
		String d=huc.getContentType();
		Map<String, List<String>> mp=huc.getHeaderFields();
		Set<String> set=mp.keySet();
		StringBuffer sb=new StringBuffer();
		for(String s:set)
		{
			sb.append(s+" : "+mp.get(s));	
		}
		long expiration=huc.getExpiration();
		System.out.println(""+expiration);
		System.out.println(sb.toString());
		
	
		}
	
		catch(Exception e){
			System.out.println("connection not possible"+e.getMessage());
		}
	
	
	}

	
}
