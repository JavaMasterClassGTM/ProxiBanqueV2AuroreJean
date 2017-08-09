	************************************
*****      	   ProxibanqueSI  	       *****
	************************************

Concepteurs/d�veloppeurs:

	Aurore LIONS
	Jean DEGLAIRE

Date : 27/07/2017

Version : version 1


	************************************ 
*****      	     Livrables  	        *****
	************************************

Les documents livr�s sont :


1) Le dossier "conception" contenant le diagrammes  de classes.

2) Le dossier "sources" contenant le dossier �clipse du projet.

3) Le dossier "javadoc".

4) Le fichier ProxibanqueSI.war

5) Le fichier Initialisation_de_la_base_de_donn�es.sql

6) Le fichier readMe.txt



	************************************
*****  	    Description de l'application:   	*****
	************************************

ProxibanqueSI est une application bancaire.
Ce syst�me permet au conseiller de client�le d'afficher la liste
des clients de l'agence, de consulter les comptes de chaque client
et de r�aliser des virements compte � compte. Si on tente de consulter
la liste de compte pour un client n'en ayant pas, un �cran d'erreur
appara�t.

R�serves :
- Si un compte impliqu� dans un virement n'existe pas, le virement
sera n�anmoins r�alis� pour le compte source.
- Les virements acceptent des montants n�gatifs.


	************************************
*****  	          Documentation:	        *****
	************************************

Pour avoir acc�s � la documentation veuillez suivre les indications suivantes :

1) Ouvrez le dossier 'javadoc'.

2) Double cliquez sur 'index.html'.

	
	************************************
***** 	     Execution de l'application:    	*****
	************************************

Veuillez suivre les indications suivantes:

1) Importez le script 'InitDB_proxibanque_db.sql' dans votre base de donn�e MySQL.

2) Placer le fichier 'ProxibanqueSI.war' dans le dossier de d�ploiement de votre serveur TomCAT.

3) D�marrez votre serveur TomCAT.

4) A l'aide de votre navigateur, tapez dans le champ URL : http://localhost:8080/ProxiBanqueSI/
