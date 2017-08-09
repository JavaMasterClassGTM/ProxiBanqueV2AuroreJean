	************************************
*****      	   ProxibanqueSI  	       *****
	************************************

Concepteurs/développeurs:

	Aurore LIONS
	Jean DEGLAIRE

Date : 27/07/2017

Version : version 1


	************************************ 
*****      	     Livrables  	        *****
	************************************

Les documents livrés sont :


1) Le dossier "conception" contenant le diagrammes  de classes.

2) Le dossier "sources" contenant le dossier éclipse du projet.

3) Le dossier "javadoc".

4) Le fichier ProxibanqueSI.war

5) Le fichier Initialisation_de_la_base_de_données.sql

6) Le fichier readMe.txt



	************************************
*****  	    Description de l'application:   	*****
	************************************

ProxibanqueSI est une application bancaire.
Ce système permet au conseiller de clientèle d'afficher la liste
des clients de l'agence, de consulter les comptes de chaque client
et de réaliser des virements compte à compte. Si on tente de consulter
la liste de compte pour un client n'en ayant pas, un écran d'erreur
apparaît.

Réserves :
- Si un compte impliqué dans un virement n'existe pas, le virement
sera néanmoins réalisé pour le compte source.
- Les virements acceptent des montants négatifs.


	************************************
*****  	          Documentation:	        *****
	************************************

Pour avoir accès à la documentation veuillez suivre les indications suivantes :

1) Ouvrez le dossier 'javadoc'.

2) Double cliquez sur 'index.html'.

	
	************************************
***** 	     Execution de l'application:    	*****
	************************************

Veuillez suivre les indications suivantes:

1) Importez le script 'InitDB_proxibanque_db.sql' dans votre base de donnée MySQL.

2) Placer le fichier 'ProxibanqueSI.war' dans le dossier de déploiement de votre serveur TomCAT.

3) Démarrez votre serveur TomCAT.

4) A l'aide de votre navigateur, tapez dans le champ URL : http://localhost:8080/ProxiBanqueSI/
