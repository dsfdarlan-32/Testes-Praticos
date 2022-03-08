# language: pt

Funcionalidade: Teste Praticos 

	@Teste1
	Cenário: Cenário 1 – Validar especificações do produto 
		Dado Que accesso a url "https://advantageonlineshopping.com"
		E Clico na opção "Special Offer" do menu
		Quando Clicar no botão "See offer"
		Então Valido que as especificações do produto de acordo com as informações retornadas do banco de automação
		
		
	@Teste2
	Cenário: Cenário 2 – Validar alteração de cor do produto no carrinho
		Dado Que accesso a url "https://advantageonlineshopping.com"
		E Clico na opção "Special Offer" do menu
		Quando Clicar no botão "See offer"
		E Alterar a cor do produto de acordo com a cor informada no banco de automação 
		E Clicar no botão Add to cart
		Então Validar que produto foi adicionado ao carrinho com a cor selecionada
		
	@Teste3
	Cenário: Cenário 3 – Validar página de checkout
		Dado Que accesso a url "https://advantageonlineshopping.com"
		E Pesquiso o produto clicando no ícone de lupa "produtoDB"
		E Seleciono produto pesquisado
		E Alterar a cor do produto para uma diferente da existente no banco de automação
		E Altero a quantidade de produtos que deseja comprar
		Quando Clicar no botão Add to cart
		E Acesso a página de checkout
		Então Valido que a soma dos preços corresponde ao total apresentado na página de checkout
		E Realizo um update no banco de automação alterar a cor existente no banco para a cor selecionada no teste
		
		
	@Teste4
	Cenário: Cenário 4 – Remover produto do carrinho de compras
		Dado Que accesso a url "https://advantageonlineshopping.com"
		E Clico na opção "Special Offer" do menu
		E Clicar no botão "See offer"
		E Clicar no botão Add to cart
		E Clicar no carrinho de compras 
		Quando Removo produto do carrinho de compras 
		Então Valido que o carrinho de compras está vazio