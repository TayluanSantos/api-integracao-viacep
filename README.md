# 📮 Integração com a  API ViaCep
O propósito do estudo foi criar uma API capaz de integrar com o ViaCep, de forma com o que o usuário pudesse ter informações sobre o endereço que estivesse buscando.

## Tecnologias Utilizadas
- Java 18
- Spring Boot (Spring Web,Open Feign)
- Maven
- Lombok ( Habilite o plugin na sua IDE )

## Instalação  

    # Clone o repositório
    git clone git@github.com:TayluanSantos/api-integracao-viacep.git

    # Acesse o diretório do projeto por meio do terminal/cmd
    cd api-integracao-viacep
    
## Inicialização

    # Rode o seguinte comando em seu terminal
    ./mvnw spring-boot:run

## Uso da API
Lembrando que após executar a aplicação , ela está disponível localmente no endereço `http://localhost:8080`

### Endpoints:
### 1. Realizando a busca por CEP

 `GET` /api/cep/{cep}/{formato} 

Ao realizarmos uma requisição do tipo `GET` para buscarmos o endereço por meio do cep, é necessário passarmos dois valores obrigatórios no endereço da requisição:

- O cep o qual queremos obter as informações 
- O formato da resposta. Lembrando que os formatos suportados são: JSON E XML.

Exemplo: `http://localhost:8080/api/cep/22010000/json`

```
{
    "complemento": "até 1020 - lado par",
    "logradouro": "Avenida Atlântica",
    "bairro": "Copacabana",
    "localidade": "Rio de Janeiro",
    "uf": "RJ"
}
```
### Observações:

O valor passado no cep deve obecer os seguintes critérios:
- Dever conter apenas 8 dígitos.
- Não pode ser do tipo alfanumérico.
- Não deve conter espaços.

Caso algum dos critérios são seja cumprido,será retornado uma mensagem de erro com o status code `400-Bad Request`

```
{
    "mensagem": "CEP inválido. Deve conter 8 dígitos e não pode conter caracteres alfanuméricos ou espaços."
}
```

### 2. Realizando a busca por endereço

 `GET` /api/endereco/{uf}/{cidade}/{logradouro}/{formato} 

Ao realizarmos uma requisição do tipo `GET` para buscarmos o endereço, é necessário passarmos quatro valores obrigatórios no endereço da requisição:

- A unidade federativa do endereço (Ex: RJ,SP,MG)
- O nome da cidade.
- O logradouro
- O formato da resposta. Lembrando que os formatos suportados são: JSON E XML.
  
Exemplo: `http://localhost:8080/api/endereco/RJ/Rio%20de%20Janeiro/Avenida%20Nossa%20Senhora/json`

```
[
    {
        "complemento": "",
        "logradouro": "Avenida Nossa Senhora da Penha",
        "bairro": "Penha",
        "localidade": "Rio de Janeiro",
        "uf": "RJ"
    },
    {
        "complemento": "lado ímpar",
        "logradouro": "Avenida Nossa Senhora de Fátima",
        "bairro": "Centro",
        "localidade": "Rio de Janeiro",
        "uf": "RJ"
    },
    {
        "complemento": "lado par",
        "logradouro": "Avenida Nossa Senhora de Fátima",
        "bairro": "Centro",
        "localidade": "Rio de Janeiro",
        "uf": "RJ"
    }
]
```
### Observações:

O valor passado no cep deve obecer os seguintes critérios:

- O nome da cidade e do logradouro deverão conter no mínimo 3 caracteres.

Caso algum dos critérios são seja cumprido,será retornado uma mensagem de erro com o status code `400-Bad Request`

```
{
    "mensagem": "A cidade e o logradouro devem conter no mínimo 3 caracteres."
}
```
O ViaCep informa que a ordenação é feita pela proximidade do nome do logradouro e possui limite máximo de 50 (cinquenta) CEPs. Dessa forma,quanto mais específico os parâmetros,maior é a precisão dos resultados.

## 🔗 Links:
Link para a API do ViaCep: https://viacep.com.br/


    
    






