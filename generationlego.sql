-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Creato il: Mar 21, 2024 alle 12:04
-- Versione del server: 10.1.10-MariaDB
-- Versione PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `generationlego`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `brand`
--

CREATE TABLE `brand` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `brand`
--

INSERT INTO `brand` (`id`, `nome`) VALUES
(1, 'Architecture'),
(2, 'Disney'),
(3, 'Harry Potter'),
(4, 'Art'),
(5, 'Super Mario'),
(6, 'Marvel'),
(7, 'Star Wars'),
(8, 'Technic'),
(9, 'City'),
(10, 'Botanica');

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini`
--

CREATE TABLE `ordini` (
  `id` int(11) NOT NULL,
  `data` date NOT NULL,
  `importo` double NOT NULL,
  `id_utente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `ordini`
--

INSERT INTO `ordini` (`id`, `data`, `importo`, `id_utente`) VALUES
(1, '2024-03-19', 99.98999786376953, 2),
(2, '2024-03-20', 313.95999908447266, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `ordini_playset`
--

CREATE TABLE `ordini_playset` (
  `id_ordine` int(11) NOT NULL,
  `id_playset` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `ordini_playset`
--

INSERT INTO `ordini_playset` (`id_ordine`, `id_playset`) VALUES
(1, 1),
(2, 1),
(2, 2),
(2, 3),
(2, 5);

-- --------------------------------------------------------

--
-- Struttura della tabella `playset`
--

CREATE TABLE `playset` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `id_brand` int(11) NOT NULL,
  `eta` varchar(50) NOT NULL,
  `numero_pezzi` int(11) NOT NULL,
  `prezzo` float NOT NULL,
  `descrizione` longtext NOT NULL,
  `immagine` longtext NOT NULL,
  `scorte` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `playset`
--

INSERT INTO `playset` (`id`, `nome`, `id_brand`, `eta`, `numero_pezzi`, `prezzo`, `descrizione`, `immagine`, `scorte`) VALUES
(1, 'Statua della Liberta', 1, '16+', 1685, 99.99, 'Celebra un monumentale mix di architettura e scultura con questo set LEGO® Architecture 21042 Statua della Libertà. L’iconico simbolo di libertà americano, alto 93 m, è ubicato sulla Liberty Island, nel porto di New York, dalla quale dà il benvenuto alle imbarcazioni provenienti da tutto il mondo. Questa fantastica interpretazione LEGO riproduce l''armonioso mix di architettura e scultura dell''originale, con il suo basamento intricato dotato di scudi, dettagli in mattoncini e balconi colonnati. La statua, di splendida fattura, è dotata di toga, catene spezzate, corona a 7 punte, libro e braccio alzato che sorregge una fiaccola dorata. Con l’autentica livrea verde sabbia e beige e la targhetta decorativa, questo modello offre una esperienza di costruzione altamente gratificante a tutti gli appassionati di architettura, viaggi, storia e design, un set veramente simbolico da esporre sia a casa sia in ufficio.\r\nMisura 44 cm di altezza, 14 cm di larghezza e 14 cm di profondità.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\statualiberta.jpg', 10),
(2, 'Taj Mahal', 1, '18+', 2022, 119.99, 'Questa stimolante sfida pratica da vivere nel tempo libero permette di ricreare un simbolo dell''amore eterno e una meraviglia architettonica del mondo in stile LEGO. Ricrea dettagli realistici come la cripta con le tombe di Mumtaz e Shah Jahan, la camera centrale con 2 cenotafi, iwan monumentali, la cupola principale, 4 chhatri e 4 minareti slanciati. Un mattoncino LEGO con l’incisione “Taj Mahal” completa questo modello in scala che lascerà chiunque a bocca aperta, ovunque sia esposto.\r\nCon 20 cm di altezza, 23 cm di larghezza e 23 cm di profondità, questo modello architettonico costruibile è un pezzo da esposizione impressionante in casa o in ufficio.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\tajmahal.jpg', 10),
(3, 'Il Castello di ghiaccio di Elsa', 2, '4+', 163, 44.99, 'Un gioco illimitato nel palazzo attende i bambini dai 4 anni in su mentre imparano a costruire con il giocattolo Il Castello di ghiaccio di Elsa LEGO® | Disney (43238). All’interno troverai un castello con cucina, caminetto, area altalena e scivolo, falò, piccola canoa di ghiaccio e tanti story starter. Include le mini-doll di Elsa e Anna LEGO | Disney, oltre a Bruni e a una piccola renna LEGO | Disney.\r\nDimensioni: questo set da costruzione di 163 pezzi contiene un castello giocattolo che misura 26 cm di altezza, 21 cm di larghezza e 9 cm di profondità', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\castelloelsa.jpg', 10),
(4, 'Castello Disney', 2, '18+', 4837, 399.99, 'Il pezzo da collezione per eccellenza\r\nQuesto dettagliato set LEGO di alta qualità include 8 minifigure di noti personaggi degli amati film Disney: Cenerentola, il Principe Azzurro, Biancaneve, il Principe Florian, la Principessa Tiana, il Principe Naveen, Rapunzel e Flynn Ryder. Le minifigure incluse incoraggiano il gioco di ruolo dei bambini più piccoli, ma il set non è solo un giocattolo: questo castello da collezione unico nel suo genere presenta un look incredibilmente suggestivo anche quando viene esposto.\r\nUn regalo indimenticabile: il castello misura 80 cm di altezza, 59 cm di larghezza e 33 cm di profondità ed è un regalo per te o per chiunque sia appassionato dei film Disney', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\castellodisney.jpg', 10),
(5, 'Baule del Quidditch', 3, '9+', 599, 48.99, 'Un fantastico regalo per i fan di Harry Potter dai 9 anni in su, il set contiene le minifigure di Harry Potter, Draco Malfoy™, Cedric Diggory e Cho Chang, oltre a 10 teste aggiuntive (6 diverse tonalità di pelle) e 10 capigliature extra per creare giocatori unici. La scatola contiene anche l’equipaggiamento per organizzare 3 diverse partite di Quidditch: lancia la Pluffa attraverso gli anelli della porta, scaglia i Bolidi contro il battitore e conquista il Boccino d’Oro. Quando la partita è finita e la coppa della casa è stata presentata, riponi tutto nel baule, pronto per essere portato con sé dai bambini per giocare in viaggio.\r\nGioco portatile: questo baule giocabile può essere chiuso e misura 18 cm di altezza, 18 cm di larghezza e 11 cm di profondità ed è quindi facile da riporre o da mettere nello zaino pronto per giocare in movimento', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\quidditch.jpg', 10),
(6, 'Castello di Hogwarts', 3, '16+', 6020, 469.99, 'Porta in vita la magia nel Castello di Hogwarts™ LEGO® Harry Potter™ 71043! Questo set da collezione LEGO Harry Potter estremamente dettagliato contiene oltre 6.000 pezzi e offre un’esperienza di costruzione altamente gratificante. Contiene tanti iconici accessori e location dei film di Harry Potter, tra cui torri, torrette, sale, aule, creature, il Platano Picchiatore™ e la capanna di Hagrid™. E con 4 minifigure e 27 micro-personaggi, tra cui studenti, professori e statue, oltre a 5 Dissennatori™, questo set di costruzione avanzato è il regalo perfetto per i fan di Harry Potter.\r\nIl Castello di Hogwarts™ misura 58 cm di altezza, 69 cm di larghezza e 43 cm di profondità.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\hogwarts.jpg', 10),
(7, 'Hokusai - La Grande Onda', 4, '18+', 1810, 99.99, 'Gli amanti dell''arte e della pittura classica adoreranno questo incredibile set di costruzione LEGO® Art per adulti, che permette di realizzare una ricostruzione LEGO di una delle opere più ioniche del mondo dell''arte: La Grande Onda di Hokusai. Durante il processo di costruzione immersivo puoi rilassarti completamente, mentre ti godi con attenzione cosciente la vera gioia di creare qualcosa di bello.\r\nUn dono per gli artisti  - Questo set LEGO® Art, che misura più di 39 cm in altezza e 52 cm in larghezza, è un dono molto apprezzato da tutti gli appassionati delle opere d''arte famose', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\greatwave.jpg', 10),
(8, 'Il potente Bowser', 5, '18+', 2807, 269.99, 'Ti piacerà costruire ed esporre il re dei Koopa con Il potente Bowser LEGO® Super Mario™. Questo personaggio costruibile utilizza i nuovi elementi LEGO di ottobre 2022 per ricreare le cuspidi e le numerose caratteristiche di Bowser, tra cui un lanciafiamme e un pulsante per controllare i movimenti della testa e del collo di Bowser. Anche le braccia e le dita sono mobili!\r\nIl potente Bowser da esporre: questo modello di personaggio LEGO® Super Mario™, con relativo espositore, misura 32 cm di altezza, 41 cm di larghezza e 28 cm di profondità', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\bowser.jpg', 10),
(9, 'Torre ghiacciata', 5, '7+', 494, 41.99, 'LEGO® Super Mario™ Pack espansione Costume di Peach gatto e Torre ghiacciata permette ai bambini di creare un fantastico livello. Il Pack include un Costume di Peach gatto, che LEGO® Peach™ (personaggio non incluso) può indossare per arrampicarsi sulla torre in mattoncini, e 3 personaggi giocattolo LEGO: Kamek, Toad e un Goomba Gatto. I giocatori ottengono premi quando liberano il Blocco Moneta dal “ghiaccio” e saltano su di esso, afferrano il frutto giallo, fanno cadere Kamek dalla torre (dopo aver attivato il Blocco POW) e liberano Toad dalla sua prigione di ghiaccio.\r\nRicostruisci e combina: questo set modulare, che nella configurazione di base misura 35 cm di altezza, 32 cm di larghezza e 20 cm di profondità, è combinabile con altri playset LEGO® Super Mario™', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\torreghiacciata.jpg', 10),
(10, 'Guanto dell’Infinito', 6, '18+', 590, 89.99, 'Modello del film Marvel da collezione\r\nQuesta riproduzione in mattoncini LEGO dell''iconico Guanto dell’Infinito presente nei film Avengers: Infinity War e Avengers: Endgame di Marvel Studios attirerà sicuramente l''attenzione e l''interesse di tutti ovunque sia esposto. Con dita mobili, Gemme dell’Infinito dai colori vivaci e una targhetta descrittiva attaccata a una solida base, questo guanto d''oro offre una sfida di costruzione avvincente e un modello finito che affascinerà tutti coloro che lo vedono.\r\nQuesto incantevole modello, che misura 31 cm di altezza, 13 cm di larghezza e 11 cm di profondità, è perfetto da esporre sia a casa che al lavoro.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\guantoinfinito.jpg', 10),
(11, 'Groot in vaso', 6, '10+', 113, 9.99, 'I fan dei Guardiani della Galassia dei Marvel Studios e della serie TV Disney+ I am Groot adoreranno questo modello BrickHeadz™ costruibile del neonato alieno a forma di albero. Groot in vaso LEGO® BrickHeadz presenta Baby Groot in un vasoper piante. Groot, il vaso e la base BrickHeadz™ sono rimovibili. Perfetto come regalo per tutti i giovani supereroi dai 10 anni in su.\r\nGrande divertimento: questo accattivante modello da costruire ed esporre è composto da 113 pezzi ed è alto 9 cm su una robusta base.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\groot.jpg', 10),
(12, 'Torre degli Avengers', 6, '18+', 5201, 499.99, 'Ricrea l’edificio più iconico dell’universo dei Vendicatori con la Torre degli Avengers LEGO® Marvel. Questo monumentale progetto di costruzione ed esposizione per i fan adulti è ricco di scene memorabili e personaggi classici. Festeggia i Marvel Avengers su scala epica Alto 90 cm, questo modello di 5.201 pezzi contiene tante scene riconoscibili dell’MCU ed è popolato da un cast di personaggi davvero stellari. Un lato dell’edificio e il tetto si sollevano per consentire un facile accesso all’interno, dove numerosi dettagli e accessori premiano i fan con evocativi riferimenti cinematografici. Un Leviatano, un Quinjet e 2 veicoli volanti Chitauri sono pronti per la battaglia. Una comoda versione digitale delle istruzioni per la costruzione del set è disponibile nell’app LEGO Builder oltre a un opuscolo stampato. Modellismo immersivo I set LEGO per adulti sono un’esperienza gratificante e danno un senso di grande soddisfazione, che perdura ben oltre il completamento dell’opera.\r\nDimensioni: il modello completato misura 90 cm di altezza, 34 cm di larghezza e 25 cm di profondità. Un lato dell’edificio e il tetto si sollevano per consentire un facile accesso all’interno.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\torreavengers.jpg', 10),
(13, 'Casco di Darth Vader', 7, '18+', 834, 79.99, 'Rendi omaggio al Signore Oscuro dei Sith con il Casco di Darth Vader LEGO® Star Wars™ collezionabile. Immergiti in un’impegnativa esperienza di costruzione e rivivi le scene classiche della saga di Star Wars mentre riproduci in puro stile LEGO l’inconfondibile forma e i sinistri dettagli del casco.\r\nIl modello costruibile Casco di Darth Vader, che misura 20 cm di altezza, 15 cm di larghezza e 14 cm di profondità, non occupa un grande spazio di esposizione, ma ha un incredibile impatto visivo.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\darthvader.jpg', 10),
(14, 'Millennium Falcon', 7, '16+', 7541, 849.99, 'Ti presentiamo il modello più grande e più dettagliato del Millennium Falcon LEGO® Star Wars mai creato! E con 7.500 pezzi, è sicuramente uno dei modelli LEGO più grandi in assoluto! Questa fantastica interpretazione LEGO dell’indimenticabile nave da trasporto corelliana di Ian Solo ha tutti i dettagli che i fan di Star Wars di ogni età possono desiderare, tra cui intricati particolari esterni, parabole sensore intercambiabili, cannoni a quattro laser superiori e inferiori, gambe di atterraggio, rampa di imbarco abbassabile e una cabina di pilotaggio per 4 minifigure con tettuccio rimovibile. Rimuovi i pannelli individuali della fusoliera per rivelare la sezione principale, altamente dettagliata, il compartimento posteriore e la stazione di artiglieria. Questo fantastico modello è dotato di parabole sensore ed equipaggio intercambiabili per rivivere le classiche avventure LEGO Star Wars con Ian, Leia, Chewbecca e C-3PO o quelle degli Episodi VII e VIII con il vecchio Ian, Rey, Finn e BB-8!\r\nMisura 21 cm di altezza, 84 cm di lunghezza e 60 cm di larghezza.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\millenniumfalcon.jpg', 10),
(15, 'McLaren Formula 1', 8, '18+', 1434, 199.99, 'Elimina qualsiasi distrazione e concentrati. Incarna il focus del tuo rivale. È il momento di costruire un modello di Monoposto McLaren Formula 1™ LEGO® Technic 42141 estremamente dettagliato. Una volta tagliato il traguardo, potrai esporre con orgoglio un modello incredibile che premia tutta la tua dedizione.\r\nMisure: questo modello di McLaren F1 LEGO® Technic misura 13 cm di altezza, 65 cm di lunghezza e 27 cm di larghezza.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\meclaren.jpg', 10),
(16, 'Ferrari Daytona SP3', 8, '18+', 3778, 449.99, 'Questo modello altamente funzionale è una replica della Ferrari vera. Tra le caratteristiche sono incluse lo sterzo, un cambio sequenziale a 8 rapporti con palette e un motore V12 con pistoni mobili. Proprio come la supercar originale, questo modello di Ferrari da collezione è caratterizzato da portiere con apertura a farfalla. Nel cofano è riportato il numero di serie univoco con cui sbloccare i contenuti speciali online.\r\nDimensioni: questo modello di supercar in scala 1:8 misura 14 cm di altezza, 59 cm di lunghezza e 25 cm di larghezza.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\ferraridaytona.jpg', 10),
(17, 'Stazione spaziale modulare', 9, '7+', 1097, 99.99, 'Delizia un astronauta in erba con il playset del modello Stazione spaziale modulare LEGO® City 7+. Questo futuristico anello spaziale è un’ancora orbitante per l’attracco di veicoli spaziali e moduli di capsule spaziali, tra cui un satellite, una space bike, una navetta, un laboratorio di esplorazione scientifica, un’officina di riparazione, una cucina, una zona notte e una biocupola. I bambini possono scambiare i moduli per realizzare la loro stazione spaziale preferita e collegarli alla navetta per creare un fantastico treno spaziale. Il set contiene anche 6 minifigure dell’equipaggio spaziale per epiche avventure spaziali.\r\nDimensioni: la stazione spaziale completa in questo set da costruzione di 1.097 pezzi misura 9 cm di altezza, 40 cm di larghezza e 35 cm di profondità', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\stazionespaziale.jpg', 10),
(18, 'Treno merci', 9, '7+', 1153, 179.99, 'Un regalo davvero epico per tutti i bambini e gli appassionati di treni! Il playset LEGO® City Treno merci telecomandato è ricco di caratteristiche e funzioni autentiche e include una locomotiva con tecnologia LEGO Powered Up, un pianale con 2 container, un vagone aperto, un vagone bisarca a due piani e 33 pezzi di binari. Aggiungi una gru di sollevamento, 2 veicoli elettrici giocattolo, il carico e 6 minifigure e avrai infinite ore di gioco a tema ferroviario.\r\nDimensioni: una volta costruito, il treno merci LEGO® City misura 9 cm di altezza, 90 cm di lunghezza e 6 cm di larghezza.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\trenomerci.jpg', 10),
(19, 'Albero Bonsai', 10, '18+', 878, 49.99, 'L’arte bonsai cattura l’immaginazione degli amanti degli alberi da secoli. Ora anche tu puoi celebrare questa antica arte con il kit di costruzione dell’Albero bonsai LEGO®. Lasciati avvolgere da un impareggiabile senso di calma mentre realizzi il modello dell''albero bonsai con le foglie verdi o i fiori di ciliegio rosa. E quando sei pronto per cambiare, sostituisci le corone colorate per creare un look completamente nuovo. Dai un''occhiata più da vicino ai fiori rosa: vedi le piccole rane che compongono ogni bocciolo di fiore?\r\nMisura 18 cm di altezza, 21 cm di lunghezza e 20 cm di larghezza.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\bonsai.jpg', 10),
(20, 'Piante grasse', 10, '18+', 771, 49.99, 'Facili da curare, le piante grasse permettono anche a chi non ha il pollice verde di decorare la casa. Adesso puoi rilassarti con un progetto di costruzione per creare un’elegante composizione di piante da esporre nel tuo spazio abitativo con questo kit di costruzione per adulti Piante grasse LEGO® (10309). Prenditi tutto il tempo che vuoi per realizzare tutti i dettagli di 9 piante grasse diverse, ognuna delle quali è ispirata a una varietà reale. Quindi, metti in mostra la tua creatività con l’esclusiva composizione di piante a bassa manutenzione.\r\nDimensioni: questo modello costruibile misura 13 cm di altezza, 17 cm di larghezza e 17 cm di profondità.', 'C:\\Users\\ilmam\\Desktop\\workspace\\generationlego\\generationlego\\src\\main\\resources\\static\\image\\piantegrasse.jpg', 10);

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `id` int(11) NOT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `cognome` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `via` varchar(50) DEFAULT NULL,
  `citta` varchar(50) DEFAULT NULL,
  `provincia` varchar(2) DEFAULT NULL,
  `cap` varchar(5) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `telefono` varchar(12) DEFAULT NULL,
  `data_di_nascita` date DEFAULT NULL,
  `profilo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`id`, `nome`, `cognome`, `username`, `password`, `via`, `citta`, `provincia`, `cap`, `mail`, `telefono`, `data_di_nascita`, `profilo`) VALUES
(1, 'SuperAdmin', '', 'admin', 'Bello1$', '', '', '', '', '', '', '2024-03-12', 'admin'),
(2, 'Claudio', 'Rossi', 'user', 'Bello1$', 'Via Roma 13', 'Siniscola', 'NU', '08029', 'claudiorossi13@gmail.com', '3405631076', NULL, 'user'),
(4, 'Mario', 'Rossi', 'mario.rossi', 'password1', 'Via Roma 1', 'Roma', 'RM', '00100', 'mario.rossi@example.com', '1234567890', '1990-05-15', 'user'),
(5, 'Luigi', 'Verdi', 'luigi.verdi', 'password2', 'Via Garibaldi 2', 'Milano', 'MI', '20100', 'luigi.verdi@example.com', '0987654321', '1985-09-22', 'user'),
(6, 'Paolo', 'Bianchi', 'paolo.bianchi', 'password3', 'Corso Italia 3', 'Napoli', 'NA', '80100', 'paolo.bianchi@example.com', '1122334455', '1982-12-10', 'user'),
(7, 'Giuseppe', 'Russo', 'giuseppe.russo', 'password4', 'Via Dante 4', 'Palermo', 'PA', '90100', 'giuseppe.russo@example.com', '5544332211', '1978-07-30', 'user'),
(8, 'Maria', 'Ferrari', 'maria.ferrari', 'password5', 'Corso Vittorio Emanuele 5', 'Torino', 'TO', '10100', 'maria.ferrari@example.com', '6677889900', '1995-03-20', 'user'),
(9, 'Giovanni', 'Esposito', 'giovanni.esposito', 'password6', 'Via Mazzini 6', 'Bologna', 'BO', '40100', 'giovanni.esposito@example.com', '1122334455', '1998-08-05', 'user'),
(10, 'Anna', 'Romano', 'anna.romano', 'password7', 'Via Garibaldi 7', 'Firenze', 'FI', '50100', 'anna.romano@example.com', '3344556677', '1989-11-12', 'user'),
(11, 'Alessandro', 'Gallo', 'alessandro.gallo', 'password8', 'Corso Umberto I 8', 'Bari', 'BA', '70100', 'alessandro.gallo@example.com', '5566778899', '1980-04-25', 'user'),
(12, 'Laura', 'Conti', 'laura.conti', 'password9', 'Via Leopardi 9', 'Catania', 'CT', '95100', 'laura.conti@example.com', '9988776655', '1993-06-18', 'user'),
(13, 'Sara', 'Costa', 'sara.costa', 'password10', 'Via Amendola 10', 'Venizia', 'VE', '30100', 'sara.costa@example.com', '1122334455', '1996-09-08', 'user');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `brand`
--
ALTER TABLE `brand`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `ordini`
--
ALTER TABLE `ordini`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_utente` (`id_utente`);

--
-- Indici per le tabelle `ordini_playset`
--
ALTER TABLE `ordini_playset`
  ADD KEY `id_ordine` (`id_ordine`,`id_playset`),
  ADD KEY `playset` (`id_playset`);

--
-- Indici per le tabelle `playset`
--
ALTER TABLE `playset`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_brand` (`id_brand`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `brand`
--
ALTER TABLE `brand`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT per la tabella `ordini`
--
ALTER TABLE `ordini`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT per la tabella `playset`
--
ALTER TABLE `playset`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT per la tabella `utenti`
--
ALTER TABLE `utenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `ordini`
--
ALTER TABLE `ordini`
  ADD CONSTRAINT `utente` FOREIGN KEY (`id_utente`) REFERENCES `utenti` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `ordini_playset`
--
ALTER TABLE `ordini_playset`
  ADD CONSTRAINT `ordine` FOREIGN KEY (`id_ordine`) REFERENCES `ordini` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `playset` FOREIGN KEY (`id_playset`) REFERENCES `playset` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `playset`
--
ALTER TABLE `playset`
  ADD CONSTRAINT `brand` FOREIGN KEY (`id_brand`) REFERENCES `brand` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
