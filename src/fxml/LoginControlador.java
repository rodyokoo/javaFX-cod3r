package fxml;

import org.controlsfx.control.Notifications;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControlador {
	
	@FXML
	private TextField emailField;
	
	@FXML
	private PasswordField senhaField;
	
	public void entrar() {
		boolean emailValido = emailField.getText().equals("aluno@email.com");
		boolean senhaValido = senhaField.getText().equals("senha1234");
		
		if(emailValido && senhaValido) {
			Notifications.create()
				.title("Login FXML")
				.text("Login efetuado com sucesso!")
				.showInformation();
		} else {
			Notifications.create()
				.title("Login FXML")
				.text("Usuário/senha inválido(s)")
				.showError();
		}
	}
}
