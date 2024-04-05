Requisiti:
Java Development Kit (JDK) installato sul sistema
XAMPP per avviare il server MySQL e Apache
Visual Studio Code (o qualsiasi altro editor di testo) per modificare il codice sorgente

Passaggi per l'avvio:

1. Preparazione dell'ambiente
Assicurati di avere XAMPP installato sul tuo sistema e avvia i servizi Apache e MySQL da XAMPP Control Panel.

2. Importazione del database
Avvia il server MySQL di XAMPP.
Utilizzando un browser web, accedi a http://localhost/phpmyadmin.
Accedi utilizzando le credenziali predefinite (solitamente username: root, password: vuota).
Crea un nuovo database chiamato generationlego.
Importa il dump del database generationlego nel database appena creato.(genereationlego.sql)

3. C. Configurazione della Web App
Scarica il codice sorgente della web application Java.
Apri il progetto in Visual Studio Code o nell'editor di tua scelta.
Aggiungi le seguenti proprietà nel file application.properties situato nella cartella src/main/resources:
properties:
-----------------------------------------------------------------------
|spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver	      |
|spring.datasource.url=jdbc:mysql://localhost/generationlego	      |
|spring.datasource.username=root			              |
|spring.datasource.password=					      |
|spring.jpa.show-sql=true					      |
-----------------------------------------------------------------------
Assicurati che le credenziali (username e password) corrispondano a quelle di accesso al database di XAMPP.

4. Avvio della Web App
Avvia il progetto.
La web app dovrebbe ora essere disponibile all'indirizzo http://localhost:8080.