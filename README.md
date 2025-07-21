# 🐾 Sistema de Gestão - ONG de Proteção Animal

Este projeto é um sistema em Java criado para auxiliar na **gestão de uma ONG de proteção animal**, permitindo o controle de **animais**, **adotantes** e **adoções**. Ele foi desenvolvido com foco em **orientação a objetos**, aplicando princípios como herança, polimorfismo, abstração e encapsulamento.

---

## 📋 Funcionalidades

- Cadastro e listagem de animais (cães e gatos)
- Cadastro de adotantes
- Processo de adoção com termo de responsabilidade
- Validação de dados de adotantes e animais
- Geração de relatórios detalhados de adoções
- Tratamento de erros com `try/catch`

---

## 🧱 Estrutura do Projeto

O projeto é dividido em **três áreas principais**:

- 🐶 Gestão de Animais
- 👤 Gestão de Adotantes
- 📄 Gestão de Adoções

Organizado em pacotes:
- `model`: contém as classes de entidades como `Animal`, `Adotante`, `Cao`, `Gato`
- `service`: lógica de negócio e controle de fluxo

---

## 🧩 Principais Classes e Abstrações

### 🔷 Pessoa (abstract)
Classe base para a classe `Adotante`.

### 👤 Adotante
Armazena:
- Nome
- Idade
- Telefone
- CPF
- Endereço
- Preferência de animal
- Status de adoção

### 🐾 Animal (abstract)
Atributos comuns:
- ID (gerado automaticamente)
- Nome
- Idade
- Estado de saúde
- Status de adoção

Subclasses:
- `Cao`
- `Gato`

---

## 🧪 Interfaces

- **Validavel**: implementada em `Animal` e `Adotante`, verifica se estão aptos para o processo de adoção.
- **Relatorio**: interface para geração de relatórios completos de adoções.

---

## 🔁 Processo de Adoção

O processo ocorre em duas etapas:

1. **Gerar Adoção**: cria o vínculo entre adotante e animal (sem termo assinado).
2. **Realizar Adoção**: assina o termo, altera o status do animal para "Adotado".

Uso de tratamento de erros para entradas inválidas:

```java
try {
    opcao = Integer.parseInt(scanner.nextLine());
} catch (NumberFormatException e) {
    System.out.println("Opção inválida. Digite um número.");
}
```
## 📊 Relatórios

Após uma adoção, o sistema gera um relatório com:

. Dados do adotante

. Dados do animal adotado

. Status do termo de responsabilidade

. Data da adoção

. Método utilizado: gerarRelatorio()


## 🎓 Conclusão

Este projeto demonstrou a aplicação prática de:

 - Programação orientada a objetos em Java

 - Boas práticas de organização de código

 - Validações e tratamento de exceções

 - Reuso de código com interfaces e herança

 - Futuramente, o sistema pode ser expandido com:

 - Persistência em banco de dados

 - Interface gráfica com JavaFX ou Swing


## 👨‍💻 Autor

Osiel Fernandes

Projeto acadêmico desenvolvido em 07/2025.
