-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28/11/2024 às 18:12
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `escola_bilingue`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `alunos`
--

CREATE TABLE `alunos` (
  `matricula` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `filiacao` varchar(200) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `curso_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `alunos`
--

INSERT INTO `alunos` (`matricula`, `nome`, `endereco`, `telefone`, `filiacao`, `data_nascimento`, `curso_id`) VALUES
(1, 'Lucas Silva', 'Av. Principal, 100', '11999999999', 'José Silva e Maria Silva', '2010-03-15', 1),
(2, 'Beatriz Oliveira', 'Rua Secundária, 200', '11888888888', 'Carlos Oliveira e Ana Oliveira', '2009-07-22', 2),
(3, 'Pedro Santos', 'Travessa Norte, 50', '11777777777', 'Miguel Santos e Clara Santos', '2011-01-10', 1),
(4, 'Isabela Martins', 'Rua Sul, 300', '11666666666', 'Roberto Martins e Fernanda Martins', '2008-05-05', 2),
(5, 'Mateus Costa', 'Av. Leste, 400', '11555555555', 'João Costa e Paula Costa', '2012-09-30', 3),
(9, 'Guilherme Neves', 'Rua 3 Chacara 46', '617432784', 'Sla SLa Sla', '2004-02-10', 3),
(10, 'fsdfsd', 'dasdas', '32445435', '32423fsdfsd', '2000-10-02', 2),
(11, 'Jorge', 'Rua 56, Ddsadsa', '435987589734', 'Pedro', '2004-10-07', 2),
(12, 'Julio', 'DAMKSo', '34985734', 'Dale', '2007-03-10', 4);

-- --------------------------------------------------------

--
-- Estrutura para tabela `cursos`
--

CREATE TABLE `cursos` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `sigla` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `cursos`
--

INSERT INTO `cursos` (`codigo`, `nome`, `sigla`) VALUES
(1, 'Ensino Fundamental I', 'EF-I'),
(2, 'Ensino Fundamental II', 'EF-II'),
(3, 'Curso de Inglês Básico', 'CIB'),
(4, 'Curso de Espanhol Básico', 'CEB'),
(5, 'Calculo II', 'Calc');

-- --------------------------------------------------------

--
-- Estrutura para tabela `curso_disciplina`
--

CREATE TABLE `curso_disciplina` (
  `curso_id` int(11) NOT NULL,
  `disciplina_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `curso_disciplina`
--

INSERT INTO `curso_disciplina` (`curso_id`, `disciplina_id`) VALUES
(1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 5),
(3, 4),
(3, 6);

-- --------------------------------------------------------

--
-- Estrutura para tabela `departamentos`
--

CREATE TABLE `departamentos` (
  `codigo` int(11) NOT NULL,
  `denominacao` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `departamentos`
--

INSERT INTO `departamentos` (`codigo`, `denominacao`) VALUES
(1, 'Matemática'),
(2, 'Linguagens'),
(3, 'Ciências'),
(4, 'Educação Física'),
(5, 'Artes');

-- --------------------------------------------------------

--
-- Estrutura para tabela `disciplinas`
--

CREATE TABLE `disciplinas` (
  `codigo` int(11) NOT NULL,
  `denominacao` varchar(100) NOT NULL,
  `sigla` varchar(10) NOT NULL,
  `ementa` text NOT NULL,
  `departamento_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `disciplinas`
--

INSERT INTO `disciplinas` (`codigo`, `denominacao`, `sigla`, `ementa`, `departamento_id`) VALUES
(1, 'Matemática Básica', 'MATBAS', 'Operações básicas, frações, equações simples', 1),
(2, 'Português', 'PORT', 'Gramática, leitura e interpretação de texto', 2),
(3, 'Ciências Naturais', 'CINAT', 'Introdução à biologia, física e química', 3),
(4, 'Inglês Básico', 'INGBAS', 'Vocabulário básico, verbos simples, conversação', 2),
(5, 'Educação Física', 'EDFIS', 'Esportes, atividades físicas e saúde', 4),
(6, 'Artes Visuais', 'ARTVIS', 'História da arte, pintura e escultura', 5);

-- --------------------------------------------------------

--
-- Estrutura para tabela `professores`
--

CREATE TABLE `professores` (
  `codigo` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `formacao` varchar(100) DEFAULT NULL,
  `endereco` varchar(200) DEFAULT NULL,
  `telefone` varchar(20) DEFAULT NULL,
  `departamento_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `professores`
--

INSERT INTO `professores` (`codigo`, `nome`, `formacao`, `endereco`, `telefone`, `departamento_id`) VALUES
(1, 'Carlos Souza', 'Licenciatura em Matemática', 'Rua A, 123', '11987654321', 1),
(2, 'Mariana Lima', 'Letras - Português/Inglês', 'Rua B, 456', '11976543210', 2),
(3, 'João Pereira', 'Licenciatura em Ciências', 'Rua C, 789', '11965432109', 3),
(4, 'Ana Clara', 'Educação Física', 'Rua D, 321', '11954321098', 4),
(5, 'Fernanda Costa', 'Licenciatura em Artes', 'Rua E, 654', '11943210987', 5),
(9, 'Guilherme Neves', 'Ciencias ', 'Rua 3 Chac 46', '61 493827489', 3),
(10, 'Jorge ', 'Matematica', 'Rua Rua Rua', '423894892', 1);

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor_disciplina`
--

CREATE TABLE `professor_disciplina` (
  `professor_id` int(11) NOT NULL,
  `disciplina_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `professor_disciplina`
--

INSERT INTO `professor_disciplina` (`professor_id`, `disciplina_id`) VALUES
(1, 1),
(2, 2),
(2, 4),
(3, 3),
(4, 5),
(5, 6),
(9, 3),
(10, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `alunos`
--
ALTER TABLE `alunos`
  ADD PRIMARY KEY (`matricula`),
  ADD KEY `curso_id` (`curso_id`);

--
-- Índices de tabela `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `sigla` (`sigla`);

--
-- Índices de tabela `curso_disciplina`
--
ALTER TABLE `curso_disciplina`
  ADD PRIMARY KEY (`curso_id`,`disciplina_id`),
  ADD KEY `disciplina_id` (`disciplina_id`);

--
-- Índices de tabela `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`codigo`);

--
-- Índices de tabela `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD PRIMARY KEY (`codigo`),
  ADD UNIQUE KEY `sigla` (`sigla`),
  ADD KEY `departamento_id` (`departamento_id`);

--
-- Índices de tabela `professores`
--
ALTER TABLE `professores`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `departamento_id` (`departamento_id`);

--
-- Índices de tabela `professor_disciplina`
--
ALTER TABLE `professor_disciplina`
  ADD PRIMARY KEY (`professor_id`,`disciplina_id`),
  ADD KEY `disciplina_id` (`disciplina_id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `alunos`
--
ALTER TABLE `alunos`
  MODIFY `matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `cursos`
--
ALTER TABLE `cursos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `departamentos`
--
ALTER TABLE `departamentos`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `disciplinas`
--
ALTER TABLE `disciplinas`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `professores`
--
ALTER TABLE `professores`
  MODIFY `codigo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `alunos`
--
ALTER TABLE `alunos`
  ADD CONSTRAINT `alunos_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`codigo`);

--
-- Restrições para tabelas `curso_disciplina`
--
ALTER TABLE `curso_disciplina`
  ADD CONSTRAINT `curso_disciplina_ibfk_1` FOREIGN KEY (`curso_id`) REFERENCES `cursos` (`codigo`),
  ADD CONSTRAINT `curso_disciplina_ibfk_2` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplinas` (`codigo`);

--
-- Restrições para tabelas `disciplinas`
--
ALTER TABLE `disciplinas`
  ADD CONSTRAINT `disciplinas_ibfk_1` FOREIGN KEY (`departamento_id`) REFERENCES `departamentos` (`codigo`);

--
-- Restrições para tabelas `professores`
--
ALTER TABLE `professores`
  ADD CONSTRAINT `professores_ibfk_1` FOREIGN KEY (`departamento_id`) REFERENCES `departamentos` (`codigo`);

--
-- Restrições para tabelas `professor_disciplina`
--
ALTER TABLE `professor_disciplina`
  ADD CONSTRAINT `professor_disciplina_ibfk_1` FOREIGN KEY (`professor_id`) REFERENCES `professores` (`codigo`),
  ADD CONSTRAINT `professor_disciplina_ibfk_2` FOREIGN KEY (`disciplina_id`) REFERENCES `disciplinas` (`codigo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
