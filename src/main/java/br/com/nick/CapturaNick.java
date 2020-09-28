package br.com.nick;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;

import net.sourceforge.htmlunit.corejs.javascript.JavaScriptException;

public class CapturaNick {
	public ArrayList<String> getNick(){
		ArrayList<String> resultado = new ArrayList<String>();
		try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
			webClient.getOptions().setRedirectEnabled(false);
			webClient.getOptions().setCssEnabled(false);
			webClient.getOptions().setJavaScriptEnabled(true);
			webClient.getOptions().setThrowExceptionOnScriptError(false);
			webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
			
			webClient.getCookieManager().setCookiesEnabled(true);
	        HtmlPage page;
			try {
				page = webClient.getPage("https://www.4devs.com.br/gerador_de_nicks");
				HtmlSelect select = (HtmlSelect)  page.getElementById("method");
				HtmlOption option = select.getOptionByValue("random");
				select.setSelectedAttribute(option, true);
				
				HtmlInput quantidade = (HtmlInput) page.getElementById("quantity");
				quantidade.setValueAttribute("50");
				
				HtmlSelect letras = (HtmlSelect)  page.getElementById("limit");
				HtmlOption letrasOption = letras.getOptionByValue("8");
				letras.setSelectedAttribute(letrasOption, true);
				
				DomElement button = page.getElementById("bt_gerar_nick");
				HtmlPage new_page = button.click();
				
				final List<DomElement> spans = page.getElementsByTagName("span");
				for (DomElement element : spans) {
				    if (element.getAttribute("class").equals("generated-nick")) {
				        resultado.add(element.getTextContent());
				    }
				}
				
			} catch (JavaScriptException |ScriptException|IOException e) {
				System.out.println("erro ao acessar a página");
			}
	        return resultado;
	    }
	}
}
