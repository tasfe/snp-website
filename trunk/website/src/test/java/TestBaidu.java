
import java.io.IOException;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ProxyConfig;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
//ProxyConfig proxyConfig=new ProxyConfig();
// proxyConfig.setProxyHost("192.168.0.4"); proxyConfig.setProxyPort(8080);
//webClient.setProxyConfig(proxyConfig);
//webClient.setJavaScriptEnabled(false);
//long lasting = System.currentTimeMillis();
import com.snp.common.GetipAddress;

public class TestBaidu {

	public static void main(String[] args) throws Exception {
		WebClient webClient = new WebClient(BrowserVersion.INTERNET_EXPLORER_8);
		HtmlPage page = (HtmlPage) webClient
				.getPage(GetipAddress.getipurl() + "/website/siteadmin/sitelogin!sso.action?account=admin&passwd=123");
		System.out.println(page.asText());
		System.out.println("完毕");
	}
}
