package br.com.nick.cpf;

import java.io.IOException;
import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.ScriptException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlDivision;
import com.gargoylesoftware.htmlunit.html.HtmlOption;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlRadioButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlSelect;

import br.com.nick.Nick;

public class CapturaCpf {
	public Nick capturaCpf(String nick){
		Nick nick_obj = new Nick();

			try (final WebClient webClient = new WebClient(BrowserVersion.CHROME)) {
				webClient.getOptions().setRedirectEnabled(false);
				webClient.getOptions().setCssEnabled(false);
				webClient.getOptions().setJavaScriptEnabled(true);
				webClient.getOptions().setThrowExceptionOnScriptError(false);
				webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
				webClient.getCookieManager().setCookiesEnabled(true);
		        HtmlPage page;
				try {
					page = webClient.getPage("https://www.4devs.com.br/gerador_de_cpf");
					
					HtmlRadioButtonInput radio = (HtmlRadioButtonInput) page.getElementById("pontuacao_sim");
					radio.setChecked(true);
					HtmlSelect select = (HtmlSelect)  page.getElementById("cpf_estado");
					HtmlOption option = select.getOptionByValue("");
					select.setSelectedAttribute(option, true);
					
					DomElement button = page.getElementById("bt_gerar_cpf");
					HtmlPage new_page = button.click();
					//this.wait(400);
					HtmlDivision div = (HtmlDivision)page.getElementById("texto_cpf");
					String cpf = div.getTextContent();
					nick_obj.setCpf(cpf);
					nick_obj.setNick(nick);
				}catch (FailingHttpStatusCodeException | IOException  | ScriptException e) {
					System.out.println("erro ao acessar a página");
				} 
			}
		return nick_obj;
	}
}
