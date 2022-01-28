package basico;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Contador extends Application{
	
	private int contador = 0;
	
	private void atualizarLabelNumero(Label label) {
		
		label.setText(Integer.toString(contador));
		
		label.getStyleClass().remove("varde");
		label.getStyleClass().remove("vermelha");
		label.getStyleClass().remove("branco");
		
		if(contador > 0) {
			label.getStyleClass().add("verde");
		}
		
		if(contador < 0) {
			label.getStyleClass().add("vermelha");
		}
		
		if(contador == 0) {
			label.getStyleClass().add("branco");
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Label labelTitulo = new Label("Contador");
		labelTitulo.getStyleClass().add("titulo");
		Label labelNumero = new Label("0");
		labelNumero.getStyleClass().add("numero");
		
		Button botaoIncremento = new Button("+");
		botaoIncremento.setOnAction(e -> {
			contador++;
			atualizarLabelNumero(labelNumero);
		});
		botaoIncremento.getStyleClass().add("botoes");
		
		Button botaoDecremento = new Button("-");
		botaoDecremento.setOnAction(e -> {
			contador--;
			atualizarLabelNumero(labelNumero);
		});
		botaoDecremento.getStyleClass().add("botoes");
		
		HBox boxBotoes = new HBox();
		boxBotoes.setAlignment(Pos.CENTER);
		boxBotoes.setSpacing(10);
		boxBotoes.getChildren().add(botaoIncremento);
		boxBotoes.getChildren().add(botaoDecremento);
		
		VBox boxConteudo = new VBox();
		boxConteudo.getStyleClass().add("conteudo");
		boxConteudo.setAlignment(Pos.CENTER);
		boxConteudo.setSpacing(10);
		boxConteudo.getChildren().add(labelTitulo);
		boxConteudo.getChildren().add(labelNumero);
		boxConteudo.getChildren().add(boxBotoes);
		
		String caminhoDoCss = getClass().getResource("/basico/Contador.css").toExternalForm();

		Scene cenaPrincipal = new Scene(boxConteudo, 200, 200);
		cenaPrincipal.getStylesheets().add(caminhoDoCss);
		cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald&display=swap");
		
		primaryStage.setScene(cenaPrincipal);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
