package log_v1;

import java.util.ArrayList;
import java.util.List;

public class Bonjour {

	// le type de log
	int typeLog;

	// constante de log
	static final int LOG_NORMAL = 0;
	static final int LOG_TEMPS = 1;
	static final int LOG_VIDE = 2;
	
	// static final int LOG_NUM=3; 
	//COMMENT AJOUTER (numerotation des messages) ?

	// construit une application et stocke le type de log
	public Bonjour(int typeLog) {
		this.typeLog = typeLog;
	}

	// lancer application
	public void lancer() {
		List<String> messages = new ArrayList<>();
		messages.add("Bonjour");
		messages.add("Ceci est un test");
		messages.add("D'affichage de logs");

		for (String message : messages) {

			// log les messages
			switch (this.typeLog) {
			
			// log normal => affiche message
			case LOG_NORMAL:
				System.out.println(message);
				break;
				
			// log temps => ajoute le temps
			case LOG_TEMPS:
				System.out.println(System.currentTimeMillis() + ":" + message);
				break;
				
			// log vide=> pas d'affichage
			case LOG_VIDE:
				break;
			
			// probleme
			default:
				throw new Error("Log inexistant");
			}

		}

	}

}
