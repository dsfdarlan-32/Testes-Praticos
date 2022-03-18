package testePratico3.pages;

import java.util.Map;

import testePratico3.maps.AdvantageShoppingMaps;
import testePratico3.repository.AdvantageShoppingQuerys;

public class AdvantageShoppingPage extends BasePage {
	AdvantageShoppingMaps advantageShoppingMaps;
	Float valorSemAdicionar;
	String novaCor;

	public AdvantageShoppingPage() {
		advantageShoppingMaps = new AdvantageShoppingMaps();
	}

	public void clicarSpcialOffer() {
		forceWait(6000);
		click(advantageShoppingMaps.spcialOffer);
	}

	public void clicarSeeOffer() {
		forceWait(2000);
		click(advantageShoppingMaps.seeOffer);
	}

	/**
	 * valida descrição do produto de acordo o banco de dado
	 * 
	 * @return retorna false caso elemento da validação não exita
	 * @author dsilvafe
	 */
	public Boolean validarEspecificaçõesWebXBancoDados() {
		Boolean flag = true;
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		Map<String, String> productSpecifications;
		productSpecifications = AdvantageShoppingQuerys.productSpecificationsSelect();
		scrollDown(500);
		forceWait(5000);
		for (String chaveMap : productSpecifications.keySet()) {
			String coluna = chaveMap.replace("_", " ");
			String valor = productSpecifications.get(chaveMap);
			if (!isPresent(advantageShoppingMaps.productSpecifications(coluna, valor)))
				return false;
		}
		return flag;
	}

	public void escolherCorDB() {
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		forceWait(3500);
		Map<String, String> corDB;
		corDB = AdvantageShoppingQuerys.corSelect();
		click(advantageShoppingMaps.escolherCor(corDB.get("COLOR")));
	}

	public void adicionarProdutoCarrinho() {
		forceWait(3500);
		click(advantageShoppingMaps.addToCart);
	}

	public Boolean validarCorEscolhida() {
		forceWait(1500);
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		Map<String, String> corDB;
		corDB = AdvantageShoppingQuerys.corSelect();
		return isPresent(advantageShoppingMaps.corProdutoCarrinho(corDB.get("COLOR")));
	}

	public void pesquisarProdutorDB() {
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		Map<String, String> nameProductDB;
		nameProductDB = AdvantageShoppingQuerys.nameProductSelect();
		forceWait(5000);
		click(advantageShoppingMaps.pesquisarClicar);
		forceWait(1500);
		sendKeys(advantageShoppingMaps.pesquisarPreencher, nameProductDB.get("NAME_PRODUCT"));
	}

	public void cliclarProdutoPesquisado() {
		AdvantageShoppingQuerys AdvantageShoppingQuerys = new AdvantageShoppingQuerys();
		Map<String, String> nameProductDB;
		nameProductDB = AdvantageShoppingQuerys.nameProductSelect();
		forceWait(3000);
		click(advantageShoppingMaps.produto(nameProductDB.get("NAME_PRODUCT")));
	}

	public void escolherDiferenteDaCorDB() {
		AdvantageShoppingQuerys advantageShoppingQuerys = new AdvantageShoppingQuerys();
		forceWait(3500);
		Map<String, String> corDB;
		corDB = advantageShoppingQuerys.corSelect();
		novaCor = getAttribute(advantageShoppingMaps.notCorProdutoCarrinho(corDB.get("COLOR")), "title");
		click(advantageShoppingMaps.notCorProdutoCarrinho(corDB.get("COLOR")));
	}

	public void adicionarMais() {
		forceWait(3500);
		String valoProdutor = getValue(advantageShoppingMaps.valorProduto);
		valorSemAdicionar = Float.parseFloat(valoProdutor.trim().replace("$", ""));
		click(advantageShoppingMaps.adicionarMais);
	}

	public void clicarCheckOutPopUp() {
		forceWait(3500);
		click(advantageShoppingMaps.checkOutPopUp);
	}

	public Boolean validarSomaProdutos() {
		forceWait(3500);
		String valorTotalProdutor = getValue(advantageShoppingMaps.valorTotalProduto);
		Float valorTotal = Float.parseFloat(valorTotalProdutor.replace("$", "").replace(",", "").trim());
		return valorTotal.equals(valorSemAdicionar * 2);
	}

	public Boolean updateCor() {
		AdvantageShoppingQuerys advantageShoppingQuerys = new AdvantageShoppingQuerys();
		return advantageShoppingQuerys.updateCorSelecionada("COLOR", novaCor);
	}

	public void cliclarCarrinho() {
		click(advantageShoppingMaps.carrinho);
	}

	public void removeItemCarrinho() {
		forceWait(2000);
		isPresent(advantageShoppingMaps.removeItem);
		click(advantageShoppingMaps.removeItem);
	}

	public Boolean validacarrinhoVazio() {
		forceWait(1500);
		return isPresent(advantageShoppingMaps.carrinhoVazio);
	}
}
