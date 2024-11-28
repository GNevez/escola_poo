# SISTEMA ESCOLA
# 1. Introdução
Este projeto foi desenvolvido para facilitar a gestão acadêmica de uma escola. O sistema foi pensado para atender às necessidades tanto administrativas quanto pedagógicas da escola, tornando mais simples e eficiente o gerenciamento de alunos, professores, cursos, disciplinas e departamentos.

# 2. Objetivo
O objetivo deste software é oferecer uma plataforma prática e eficiente para gerenciar as informações acadêmicas da escola. Com ele, é possível cadastrar, editar e consultar dados de alunos, professores, cursos, disciplinas e departamentos de forma simples e organizada. A ideia é tornar o dia a dia da gestão escolar mais fácil e produtivo.

# 3. Requisitos do Sistema
- 3.1 Requisitos Funcionais:
- Cadastro de Professores: O sistema deve permitir o cadastro de professores, incluindo informações como nome, formação, endereço e telefone.

- Cadastro de Alunos: O sistema deve permitir o cadastro de alunos, incluindo matrícula, nome, endereço, telefone, filiação e data de nascimento.

- Cadastro de Cursos: O sistema deve permitir o cadastro de cursos, incluindo código, nome e sigla.

- Cadastro de Disciplinas: O sistema deve permitir o cadastro de disciplinas, incluindo código, denominação, sigla e ementa.

- Cadastro de Departamentos: O sistema deve permitir o cadastro de departamentos, incluindo código e denominação.

- Relacionamentos:
  Um departamento pode oferecer diversas disciplinas.
  Uma disciplina pertence a um único departamento.
  Um aluno pode estar matriculado em um único curso.
  Uma mesma disciplina pode constar no currículo de diversos cursos.
  Um professor pertence a um departamento e pode lecionar em diversas disciplinas.

- 3.2 Requisitos Não Funcionais:
- Usabilidade: O sistema deve ser intuitivo e fácil de usar, permitindo que usuários com conhecimentos básicos de informática possam operar sem dificuldades.

- Desempenho: O sistema deve ser capaz de processar as operações de cadastro e consulta de forma rápida e eficiente.

- Segurança: O sistema deve garantir a segurança dos dados armazenados, implementando medidas de proteção contra acesso não autorizado.

# 4. Modelagem do Banco de Dados
  O banco de dados é projetado para armazenar as informações necessárias conforme os requisitos levantados. A seguir, estão as entidades e seus atributos:

- 4.1 Entidades e Atributos
  Professores

  Código (identificador único)
  Nome
  Formação
  Endereço
  Telefone
  Cursos

  Código (identificador único)
  Nome
  Sigla
  Disciplinas

  Código (identificador único)
  Denominação
  Sigla
  Ementa
  Código do Departamento (chave estrangeira)
  Departamentos

  Código (identificador único)
  Denominação
  Alunos

  Matrícula (identificador único)
  Nome
  Endereço
  Telefone
  Filiação
  Data de Nascimento
  Código do Curso (chave estrangeira)

- 4.2 Modelo Lógico do Bando de Dados:
  
![Diagrama de Caso de Uso](https://github.com/GNevez/escola_poo/blob/main/modelo_logico.jpg)



# 5. Diagramas
- 5.1 Diagrama de Caso de Uso:
  
![Diagrama de Caso de Uso](https://github.com/GNevez/escola_poo/blob/main/diagrama_caso_de_uso.jpg.jpg)

- 5.2 Diagrama de Classe:
  
![Diagrama de Caso de Uso](https://github.com/GNevez/escola_poo/blob/main/diagrama_de_classe.png)


# 6. Tecnologias Utilizadas
- Linguagem de Programação: Java
- Banco de Dados: MySQL
- Interface Gráfica: Swing (para a construção da interface do usuário)

# 7. Conclusão
Este software de gerenciamento acadêmico foi criado para atender às necessidades específicas da escola, oferecendo uma solução prática e eficiente para administrar as informações acadêmicas. Com sua implementação, buscamos tornar mais simples o gerenciamento de alunos, professores, cursos, disciplinas e departamentos, contribuindo para um ambiente escolar mais organizado, funcional e produtivo.
