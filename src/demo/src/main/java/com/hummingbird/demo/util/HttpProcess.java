package com.hummingbird.demo.util;
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HostParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.springframework.stereotype.Component;

@Component("httpProcess")
public class HttpProcess
{
  private final String CONTENT_CHARSET_UTF8 = "UTF-8";

  public byte[] doGet(String url, Map<String, String> params, boolean type)
  {
    HttpClient httpClient = new HttpClient();
    List headers = new ArrayList();
    headers.add(new Header("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)"));
    httpClient.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
    StringBuffer queryString = new StringBuffer("");
    if (type)
      url = url + "/";
    else
      url = url + "?";
    String param;
    if (params != null) {
      try {
        for (String key : params.keySet()) {
          param = "";
          if (type)
            param = URLEncoder.encode((String)params.get(key), "UTF-8") + "/";
          else {
            param = key + "=" + URLEncoder.encode((String)params.get(key), "UTF-8") + "&";
          }
          queryString.append(param);
        }
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }

      queryString.delete(queryString.length() - 1, queryString.length());
    }
    System.out.println(url + queryString.toString());
    GetMethod getMethod = new GetMethod(url + queryString.toString());
    try
    {
      int statusCode = httpClient.executeMethod(getMethod);
      if (statusCode != 200) {
        System.err.println("Method failed:" + getMethod.getStatusLine());
      }

      return getMethod.getResponseBody();
    }
    catch (HttpException e)
    {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      getMethod.releaseConnection();
    }
    return null;
  }

  public byte[] doPost(String url, Map<String, String> params)
  {
    HttpClient httpClient = new HttpClient();
    PostMethod postMethod = new PostMethod(url);
    postMethod.getParams().setParameter("http.protocol.content-charset", "GBK");
    NameValuePair[] nameValuePairs = new NameValuePair[params.size()];
    int index;
    if (params != null) {
      index = 0;
      for (String key : params.keySet()) {
        NameValuePair nameValuePair = new NameValuePair(key, (String)params.get(key));

        nameValuePairs[index] = nameValuePair;
        index++;
      }
    }
    try
    {
      postMethod.setRequestBody(nameValuePairs);

      int statusCode = httpClient.executeMethod(postMethod);
      if (statusCode != 200) {
        System.err.println("Method failed:" + postMethod.getStatusLine());
      }

      return postMethod.getResponseBody();
    } catch (HttpException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      postMethod.releaseConnection();
    }
    return null;
  }

  public static void main(String[] args)
    throws IOException
  {
  }
}