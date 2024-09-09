package br.ufc.sistemapatrimonio.controller;

import br.ufc.sistemapatrimonio.exceptions.PatrimonioException;
import br.ufc.sistemapatrimonio.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AdminPatrimoniosViewController {

    private final Model model = new Model();

    @FXML
    private TextField txtRemover;  // Campo de remoção

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnIrParaBens;

    @FXML
    private Button btnIrParaRequisicoes;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnSair;

    @FXML
    private TextField txtDepressiacaoAdd;

    @FXML
    private TextField txtDepressiacaoEditar;

    @FXML
    private TextField txtDescricaoAdd;

    @FXML
    private TextField txtDescricaoEditar;

    @FXML
    private TextField txtIDAdd;

    @FXML
    private TextField txtIDEditar;

    @FXML
    private TextArea txtListaPatrimonios;

    @FXML
    private TextField txtNomeAdd;

    @FXML
    private TextField txtNomeEditar;

    @FXML
    private TextField txtNumeroDeTombamentoAdd;

    @FXML
    private TextField txtNumeroDeTombamentoEditar;

    @FXML
    private TextField txtTipoAdd;

    @FXML
    private TextField txtTipoEditar;

    public void initialize() {
        atualizarPatrimonios();
    }

    public void atualizarPatrimonios() {
        String patrimoniosListados = model.getAdminModel().listarPatrimonios(); // Chama a função que lista as reservas
        txtListaPatrimonios.setText(patrimoniosListados); // Atualiza o conteúdo da TextArea
    }

    @FXML
    void adicionarPatrimonio(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtIDAdd.getText());
            String nome = txtNomeAdd.getText();
            String descricao = txtDescricaoAdd.getText();
            double depreciacao = Double.parseDouble(txtDepressiacaoAdd.getText());
            String tipo = txtTipoAdd.getText();
            int numeroTombamento = Integer.parseInt(txtNumeroDeTombamentoAdd.getText());


            model.getAdminModel().adicionarPatrimonio(id, nome, descricao, depreciacao, tipo, numeroTombamento);

            txtIDAdd.clear();
            txtNomeAdd.clear();
            txtDescricaoAdd.clear();
            txtDepressiacaoAdd.clear();
            txtTipoAdd.clear();
            txtNumeroDeTombamentoAdd.clear();

            model.mostrarPopup("Sucesso", "Patrimônio adicionado com sucesso!", Alert.AlertType.INFORMATION);
            atualizarListaPatrimonios();
        } catch (NumberFormatException e) {
            model.mostrarPopup("Erro", "Por favor, insira valores válidos.", Alert.AlertType.ERROR);
        } catch (PatrimonioException e) {
            model.mostrarPopup("Erro", "Ocorreu um erro inesperado: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void editarPatrimonio(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtIDEditar.getText());
            String nome = txtNomeEditar.getText();
            String descricao = txtDescricaoEditar.getText();
            Double depreciacao = Double.parseDouble(txtDepressiacaoEditar.getText());
            String tipo = txtTipoEditar.getText();
            int numeroTombamento = Integer.parseInt(txtNumeroDeTombamentoEditar.getText());

            model.getAdminModel().editarPatrimonio(id, nome, descricao, depreciacao, tipo, numeroTombamento);

            txtIDEditar.clear();
            txtNomeEditar.clear();
            txtDescricaoEditar.clear();
            txtDepressiacaoEditar.clear();
            txtTipoEditar.clear();
            txtNumeroDeTombamentoEditar.clear();

            model.mostrarPopup("Sucesso", "Patrimônio editado com sucesso!", Alert.AlertType.INFORMATION);
            atualizarListaPatrimonios();
        } catch (NumberFormatException e) {
            model.mostrarPopup("Erro", "Por favor, insira valores válidos.", Alert.AlertType.ERROR);
        } catch (PatrimonioException e) {
            switch (e.getErroCode()) {
                case PatrimonioException.NAO_ENCONTRADO, PatrimonioException.ERRO ->
                        model.mostrarPopup("Erro", e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            model.mostrarPopup("Erro", "Ocorreu um erro inesperado: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void removerPatrimonio(ActionEvent event) {
        try {
            int id = Integer.parseInt(txtRemover.getText());

            model.getAdminModel().removerPatrimonio(id);

            txtRemover.clear();

            model.mostrarPopup("Sucesso", "Patrimônio removido com sucesso!", Alert.AlertType.INFORMATION);

            atualizarListaPatrimonios();
        } catch (NumberFormatException e) {
            model.mostrarPopup("Erro", "Por favor, insira um ID válido.", Alert.AlertType.ERROR);
        } catch (PatrimonioException e) {
            switch (e.getErroCode()) {
                case PatrimonioException.NAO_ENCONTRADO, PatrimonioException.ERRO ->
                        model.mostrarPopup("Erro", e.getMessage(), Alert.AlertType.ERROR);
            }
        } catch (Exception e) {
            model.mostrarPopup("Erro", "Ocorreu um erro inesperado: " + e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    public void atualizarListaPatrimonios() {
        txtListaPatrimonios.setText(model.getAdminModel().listarPatrimonios());
    }

    @FXML
    void irParaBens(ActionEvent event) throws IOException {
        // Implementar navegação para a tela de Bens
        ScreenController.activate("telaAdminBens");
    }

    @FXML
    void irParaRequisicoes(ActionEvent event) throws IOException {
        ScreenController.activate("telaAdminRequisicoes");
    }

    @FXML
    void sair(ActionEvent event) throws IOException {
        // Implementar a lógica para sair da tela
        ScreenController.activate("telaLogin");
        Model.deslogarUsuario();
    }

}