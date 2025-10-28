# enemdao

# 📚 Manual do Sistema de Questões ENEM

## 🚀 **Como Usar o Sistema**

### **1. Iniciando o Sistema**
- Execute a classe `App.java` para iniciar a aplicação
- A tela principal será carregada automaticamente com o tema dourado/escuro
- A janela inicia maximizada

### **2. Navegação no Menu Lateral**

#### **Botões Disponíveis:**
- **📚 Questões ENEM** - Acessa o cadastro de novas questões
- **📋 Listar Questões** - Visualiza todas as questões cadastradas
- **🚪 Sair** - Encerra a aplicação

### **3. Cadastrar Nova Questão**

#### **Passo a Passo:**
1. **Clique em "Questões ENEM"** no menu lateral
2. **Preencha os campos:**
   - **Ano**: Digite o ano da prova (ex: 2023, 2022)
   - **Cor do Caderno**: Selecione uma opção (Azul, Amarelo, Branco, Rosa)
   - **Número da Questão**: Digite o número da questão (ex: 1, 15, 45)
   - **Questão**: Digite o texto completo da questão

3. **Ações:**
   - **Salvar**: Cadastra a questão no banco de dados
   - **Limpar**: Limpa todos os campos para novo cadastro

#### **Validações:**
- Todos os campos são obrigatórios
- Ano e Número da Questão devem ser números
- Sistema alerta se algum campo estiver incorreto

### **4. Listar e Gerenciar Questões**

#### **Passo a Passo:**
1. **Clique em "Listar Questões"** no menu lateral
2. **Visualize a tabela** com todas as questões cadastradas
3. **Colunas disponíveis:**
   - **ID**: Identificador único automático
   - **Ano**: Ano da prova
   - **Cor do Caderno**: Cor do caderno da questão
   - **Nº Questão**: Número da questão na prova
   - **Questão**: Texto da questão (visualização parcial)

#### **Ações na Listagem:**
- **Nova Questão**: Abre a tela de cadastro
- **Editar**: *Funcionalidade futura* - selecione uma questão para editar
- **Excluir**: Remove a questão selecionada (com confirmação)

### **5. Funcionalidades do Cabeçalho**

- **📅 Relógio**: Mostra data e hora atual em tempo real
- **🌤️ Estação do Ano**: Informação contextual baseada no mês atual
- **👤 Perfil**: Exibe nome do usuário e foto
- **🔍 Pesquisa**: Botão de pesquisa (funcionalidade futura)

### **6. Dicas de Uso**

#### **Cadastro Eficiente:**
1. Tenha as questões organizadas por ano e cor de caderno
2. Copie e cole o texto das questões para evitar erros de digitação
3. Verifique se o número da questão corresponde ao caderno correto

#### **Navegação:**
- Use o menu lateral para alternar entre telas
- A animação de fade-in indica a transição entre telas
- Sempre confirme a exclusão de questões

### **7. Estrutura do Banco de Dados**

#### **Tabela: `questoes`**
| Campo | Tipo | Descrição |
|-------|------|-----------|
| id | BIGINT AUTO_INCREMENT | Identificador único |
| ano | INT | Ano da prova ENEM |
| cor_caderno | VARCHAR(50) | Cor do caderno (Azul/Amarelo/Branco/Rosa) |
| numero_questao | INT | Número da questão |
| questao | TEXT | Texto completo da questão |

### **8. Solução de Problemas**

#### **Problemas Comuns:**

1. **Texto não visível**
   - Solução: O sistema já está configurado com texto branco sobre fundo escuro

2. **Erro ao salvar questão**
   - Verifique se todos os campos estão preenchidos
   - Confirme que ano e número são valores numéricos

3. **Tabela não carrega**
   - Verifique a conexão com o banco de dados
   - Confirme se a tabela `questoes` foi criada

4. **Botões não funcionam**
   - Reinicie a aplicação
   - Verifique se há mensagens de erro no console

#### **Mensagens do Sistema:**
- ✅ **Sucesso**: "Questão salva com sucesso!"
- ⚠️ **Aviso**: Campos obrigatórios não preenchidos
- ❌ **Erro**: Problemas de validação ou conexão
- ❓ **Confirmação**: "Tem certeza que deseja excluir esta questão?"

### **9. Atalhos e Boas Práticas**

- **Organização**: Cadastre as questões agrupadas por ano e cor de caderno
- **Backup**: Mantenha backup do banco de dados regularmente
- **Verificação**: Sempre confira os dados antes de salvar

### **10. Próximas Funcionalidades (Em Desenvolvimento)**

- [ ] Edição de questões existentes
- [ ] Busca e filtros avançados
- [ ] Importação em lote
- [ ] Exportação para PDF
- [ ] Categorização por áreas do conhecimento

---

## 🆘 **Suporte**

Em caso de problemas:
1. Verifique as mensagens no console da aplicação
2. Confirme se o banco de dados MySQL está rodando
3. Verifique a conexão com o banco no arquivo `persistence.xml`

O sistema está pronto para uso! Comece cadastrando suas primeiras questões do ENEM. 🎯
