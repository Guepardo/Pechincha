package module1.pechincha.viewUseCases;

import biz.source_code.miniTemplator.MiniTemplator;
import module1.pechincha.model.Usuario;
import module1.pechincha.util.ActionDone;
import module1.pechincha.view.ViewController;

public class ManterUsuarioView extends ViewController {

	public ManterUsuarioView(String sevletContext, String useCase) {
		super(sevletContext, useCase);
	}

	@Override
	public String choose(ActionDone ad) {
		String action = ad.getAction();
		String retorno = "";
		switch (action) {
			case "cadastroerro" :
				retorno = cadastroerro(ad);
				break;
			case "cadastro" :
				retorno = cadastro(ad);
				break;
			case "login" :
				retorno = login(ad);
				break;
			case "meusDados" :
				retorno = meusDados(ad);
		}
		return retorno;
	}

	private String login(ActionDone ad) {
		if (!ad.isProcessed()) {
			MiniTemplator temp = super.startMiniTemplator(super.getTemplate(ad));
			ad.setData("index", "false");
			return temp.generateOutput();
		}else{
			return (String) ad.getData("loginStatus"); 
		}
	}
	
	public String meusDados(ActionDone ad){
		Usuario user = (Usuario) ad.getData("usuario");
		MiniTemplator temp = super.startMiniTemplator(super.getTemplate(ad));
		temp.setVariable("nome", user.getNomeCompleto());
		temp.setVariable("nickname", user.getNickname());
		temp.setVariable("data",user.getDataNascimento());
		temp.setVariable("mail", user.getEmailPrincipal());
		temp.setVariable("mailAlt", user.getEmailAlternativo());
		temp.setVariable("skype", user.getSkype());
		temp.setVariable("cel", user.getTelCelular());
		temp.setVariable("fixo", user.getTelFixo());
		temp.setVariable("id", user.getPk());
		return temp.generateOutput();
	}

	public String cadastroerro(ActionDone ad) {
		return (String) ad.getData("message");
	}

	public String cadastro(ActionDone ad) {
		MiniTemplator temp = super.startMiniTemplator(super.getTemplate(ad));
		return temp.generateOutput();
	}

}
