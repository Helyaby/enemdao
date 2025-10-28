package crud_questao;

import dao.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import model.Questao;

import java.io.IOException;
import java.util.List;

public class QuestaoListController {

    // =====================================
    // Elementos da tela vinculados pelo FXML
    @FXML private TableView<Questao> tableQuestoes;
    @FXML private TableColumn<Questao, Long> colId;
    @FXML private TableColumn<Questao, Integer> colAno;
    @FXML private TableColumn<Questao, String> colCorCaderno;
    @FXML private TableColumn<Questao, Integer> colNumeroQuestao;
    @FXML private TableColumn<Questao, String> colQuestao;

    // Lista observável para atualizar a TableView automaticamente
    private final ObservableList<Questao> dados = FXCollections.observableArrayList();

    // =====================================
    // Inicialização da tela
    @FXML
    public void initialize() {
        // Configura colunas da tabela
        colId.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getId()));
        colAno.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getAno()));
        colCorCaderno.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getCorCaderno()));
        colNumeroQuestao.setCellValueFactory(c -> new javafx.beans.property.SimpleObjectProperty<>(c.getValue().getNumeroQuestao()));
        colQuestao.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getQuestao()));

        // Carrega os dados do banco
        carregarQuestoes();
    }

    // =====================================
    // Carrega as questões do banco usando DAO
    private void carregarQuestoes() {
        List<Questao> lista = new DAO<>(Questao.class).obterTodos(100, 0);
        dados.setAll(lista);          // Atualiza a lista observável
        tableQuestoes.setItems(dados); // Atualiza a tabela
    }

    // =====================================
    // Botão Cadastrar
    @FXML
    private void abrirCadastro() {
        try {
            Node tela = FXMLLoader.load(getClass().getResource("/telas/view/TelaCadastroQuestao.fxml"));
            StackPane painel = (StackPane) tableQuestoes.getScene().lookup("#painelConteudo");
            painel.getChildren().setAll(tela); // Substitui conteúdo do painel
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // =====================================
    // Botão Editar
    @FXML
    private void editarQuestao() {
        Questao selecionada = tableQuestoes.getSelectionModel().getSelectedItem();
        if (selecionada == null) {
            new Alert(Alert.AlertType.WARNING, "Selecione uma questão para editar.").showAndWait();
            return;
        }
        new Alert(Alert.AlertType.INFORMATION, "Função editar ainda não implementada.").showAndWait();
    }

    // =====================================
    // Botão Excluir
    @FXML
    private void excluirQuestao() {
        Questao selecionada = tableQuestoes.getSelectionModel().getSelectedItem();
        if (selecionada == null) {
            new Alert(Alert.AlertType.WARNING, "Selecione uma questão para excluir.").showAndWait();
            return;
        }
        
        // Confirmação antes de excluir
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Confirmação");
        confirmacao.setHeaderText("Excluir Questão");
        confirmacao.setContentText("Tem certeza que deseja excluir esta questão?");
        
        if (confirmacao.showAndWait().get() == ButtonType.OK) {
            new DAO<>(Questao.class).removerPorIdTransacional(selecionada.getId()); // Remove do banco
            carregarQuestoes(); // Recarrega a tabela
            new Alert(Alert.AlertType.INFORMATION, "Questão excluída com sucesso!").showAndWait();
        }
    }
}