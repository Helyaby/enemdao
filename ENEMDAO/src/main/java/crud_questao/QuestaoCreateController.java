// Arquivo: QuestaoCreateController.java
package crud_questao;

import dao.DAO;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Questao;

public class QuestaoCreateController {

    @FXML
    private TextField txtAno;
    @FXML
    private ComboBox<String> comboCorCaderno;
    @FXML
    private TextField txtNumeroQuestao;
    @FXML
    private TextArea txtQuestao;

    @FXML
    public void initialize() {
        comboCorCaderno.getItems().addAll("Azul", "Amarelo", "Branco", "Rosa");
    }

    @FXML
    private void salvarQuestao() {
        try {
            if (validarCampos()) {
                Questao nova = new Questao(
                        Integer.parseInt(txtAno.getText()),
                        comboCorCaderno.getValue(),
                        Integer.parseInt(txtNumeroQuestao.getText()),
                        txtQuestao.getText());

                new DAO<>(Questao.class).incluirTransacional(nova);

                new Alert(Alert.AlertType.INFORMATION, "Questão salva com sucesso!").showAndWait();
                limparCampos();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Erro: " + e.getMessage()).showAndWait();
        }
    }

    // No QuestaoCreateController, atualize o método validarCampos:
    private boolean validarCampos() {
        if (txtAno.getText() == null || txtAno.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Preencha o ano!").showAndWait();
            return false;
        }

        if (comboCorCaderno.getValue() == null) {
            new Alert(Alert.AlertType.WARNING, "Selecione a cor do caderno!").showAndWait();
            return false;
        }

        if (txtNumeroQuestao.getText() == null || txtNumeroQuestao.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Preencha o número da questão!").showAndWait();
            return false;
        }

        if (txtQuestao.getText() == null || txtQuestao.getText().trim().isEmpty()) {
            new Alert(Alert.AlertType.WARNING, "Preencha o texto da questão!").showAndWait();
            return false;
        }

        try {
            Integer.parseInt(txtAno.getText());
            Integer.parseInt(txtNumeroQuestao.getText());
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.WARNING, "Ano e número da questão devem ser números!").showAndWait();
            return false;
        }

        return true;
    }

    @FXML
    private void limparCampos() {
        txtAno.clear();
        comboCorCaderno.setValue(null);
        txtNumeroQuestao.clear();
        txtQuestao.clear();
    }
}