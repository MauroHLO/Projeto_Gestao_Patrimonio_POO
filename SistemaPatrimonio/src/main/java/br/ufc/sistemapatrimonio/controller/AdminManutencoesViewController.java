package br.ufc.sistemapatrimonio.controller;

import br.ufc.sistemapatrimonio.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.io.IOException;

public class AdminManutencoesViewController {

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
    private RadioButton radioBemAdd;

    @FXML
    private RadioButton radioBemEditar;

    @FXML
    private ToggleGroup radioOpcoesAdd;

    @FXML
    private ToggleGroup radioOpcoesEditar;

    @FXML
    private RadioButton radioPatrimonioAdd;

    @FXML
    private RadioButton radioPatrimonioEditar;

    @FXML
    private TextField txtDefeitoAdd;

    @FXML
    private TextField txtIDAdd;

    @FXML
    private TextField txtIDEditar;

    @FXML
    private TextArea txtListaManutencao;

    @FXML
    private TextField txtNomeAdd;

    @FXML
    private TextField txtNomeEditar;

    @FXML
    private TextField txtRemover;

    @FXML
    private TextField txtTipoEditar;

    @FXML
    void adicionarManutencao(ActionEvent event) {

    }

    @FXML
    void editarManutencao(ActionEvent event) {

    }

    @FXML
    void removerManutencao(ActionEvent event) {

    }

    @FXML
    void irParaBens(ActionEvent event) throws IOException {
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
