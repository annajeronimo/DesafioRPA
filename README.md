********* PROJETO- DESAFIO RPA *********
-----------------------------------------------------
## Descrição
- Este projeto é uma automação de cotação de preços que busca os três menores preços do produto Xbox Serie S em dois sites de venda: Mercado Livre e Casas Bahia. O projeto utiliza Java, Spring Boot e Selenium para realizar a automação.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Funcionalidades Implementadas
- Busca de Preços no Mercado Livre: A funcionalidade de busca de preços no Mercado Livre está implementada e funcionando corretamente.
- Estrutura Básica de Spring Boot: A estrutura básica do projeto com Spring Boot está configurada e operacional.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Problemas Conhecidos
- Busca de Preços nas Casas Bahia: A funcionalidade de busca de preços nas Casas Bahia está apresentando problemas de localização de elementos, possivelmente devido a mudanças na estrutura da página.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
## Desafios e Soluções Tentadas
# Desafios:
- Localização de elementos dinâmicos e carregados dentro de iframes.
- Diferentes comportamentos em ambientes de teste e produção.

# Soluções Tentadas:
- Uso de seletores mais específicos e condicional de espera para elementos.
- Alternância entre iframes e contexto principal do driver.
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
## Próximos Passos
- Correção dos Seletores: Revisar e ajustar os seletores utilizados para localizar elementos na página das Casas Bahia.
- Melhoria da Robustez: Implementar técnicas adicionais para aumentar a robustez da automação, como verificações adicionais de presença e visibilidade de elementos.
- Testes e Debugging: Realizar mais testes e debugging para identificar e resolver as falhas restantes.


-----------------------------------------------------
********* COMO EXECUTAR *********
-----------------------------------------------------
## Pré-requisitos:
- jdk 17
- Maven
- Google Chrome
- Chromedriver compatível com a versão do Chrome (configurado no PriceCheckerService)

-----------------------------------------------------
********* PASSOS PARA EXECUTAR *********
-----------------------------------------------------
- git clone (https://github.com/annajeronimo/DesafioRPA.git)
- cd C:\eclipse\ProjetoRPA
- mvn clean install
- mvn spring-boot:run
- Link Localhost: http://localhost:8080/check-prices?product=Xbox%20Series%20S


## Apesar das dificuldades encontradas, acredito que o projeto demonstra um entendimento sólido de automação de testes com Selenium e integração com Spring Boot. Com mais tempo e recursos, posso resolver os problemas remanescentes e implementar todas as funcionalidades desejadas plenamente
