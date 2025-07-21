package projeto.calculadora.calculadorajava;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculadoraController {
    @FXML
    private TextField painelCalculadora;


    private double numero1;
    private double numero2;
    private String operador;
    private boolean novoNumero = true;


    public void numero(javafx.event.ActionEvent actionEvent) {
        Button botao = (Button) actionEvent.getSource();
        String valor = botao.getText();

        if (novoNumero) {
            painelCalculadora.setText(valor);
            novoNumero = false;
        } else {
            painelCalculadora.setText(painelCalculadora.getText() + valor);
        }
    }

    public void operador(javafx.event.ActionEvent actionEvent) {
        Button botao = (Button) actionEvent.getSource();
        operador = botao.getText();
        numero1 = Double.parseDouble(painelCalculadora.getText());
        novoNumero = true;
    }

    public void somarCalculo(javafx.event.ActionEvent actionEvent) {
        numero2 = Double.parseDouble(painelCalculadora.getText());

        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    painelCalculadora.setText("Erro");
                    return;
                }
                break;
        }
        painelCalculadora.setText(String.valueOf(resultado));
        novoNumero = true;
    }
}

