#README
##Chaques dependances utilisées
###Spring Web
Spring Web Flow (SWF) est le sous-projet de Spring Framework qui se concentre sur la fourniture de l'infrastructure nécessaire à la création et à l'exécution d'applications web riches.
###JPA
Spring Data est un projet Spring qui a pour objectif de simplifier l’interaction avec différents systèmes de stockage de données : qu’il s’agisse d’une base de données relationnelle, d’une base de données NoSQL, d’un système Big Data ou encore d’une API Web.
###Hibernate
Hibernate est une solution open source de type ORM (Object Relational Mapping) qui permet de faciliter le développement de la couche persistance d'une application. Hibernate permet donc de représenter une base de données en objets Java et vice versa.

Hibernate facilite la persistence et la recherche de données dans une base de données en réalisant lui-même la création des objets et les traitements de remplissage de ceux-ci en accédant à la base de données. La quantité de code ainsi épargnée est très importante d'autant que ce code est généralement fastidieux et redondant.
###H2
H2 est une base de données SQL que nous pouvons créer en JAVA.
###DevTools
L'objectif de ce module est d'essayer d'améliorer le temps de développement tout en travaillant avec l'application Spring Boot. Les DevTools de Spring Boot récupèrent les modifications et redémarrent l'application.
###Thymeleaf
Thymeleaf est un Java XML/XHTML/HTML5 Template Engine qui peut travailler à la fois dans des environnements Web (Servlet) et celui de non Web. Il est mieux adapté pour diffuser XHTML/HTML5 sur View (View Layer) des applications Web basées sur MVC. Mais il peut traiter n'importe quel fichier XML même dans des environnements hors ligne (offline). Il fournit une intégration complète de Spring Framework.
##Réponses étape 13
- 1 - Avec les getMapping.
- 2 - Sur le fichier "greeting.html".
- 3 - Avec @requestParam.
##Réponse étape 17
- L'apparition d'une table address
##Réponse étape 18
- Cette classe doit respecter le standard des Javabeans, notamment, encapsuler les propriétés dans ses champs private avec des getters et setters et avoir un constructeur par défaut.
Les types utilisables pour les propriétés sont : les types primitifs, les classes String et Dates, les wrappers, et n'importe quelle classe qui encapsule une autre table ou une partie de la table.
##Réponse étape 20
- Nous pouvons voir les infos de la table mais après ajout de la ligne la : "spring.jpa.defer-datasource-initialization=true" dans applicationProperties.
##Réponse étape 23
- L'annotation @Autowired vous évite de devoir effectuer le câblage vous-même dans le fichier XML (ou tout autre moyen) et trouve pour vous ce qui doit être injecté où et le fait pour vous.
##Réponse étape 30
- Téléchargement de la dernière version sur le site officiel puis intégration dans mon fichier. Ensuite nous utilisons la balise link pour l'intégrer dans un fichier html.
- ajout de la dépendance "org.webjars"

#TP4

###Faut-il une clé API?
- Oui nous devons utiliser un token pour accéder à la base de données Météo
###Quelle URL appeler?
- "String uri = "https://api.meteo-concept.com/api/forecast/daily?" +
  "token=dfc7933b44562fa04f04b0fa8a47485dffaa91309b6453e5d2171a4aa633a5ed&" +
  "latlng="+ lat +","+ lon;"
###Quelle méthode HTTP utiliser?
- Il faut utiliser la méthode GET pour passer en paramètre les informations.
###Comment passer les paramètres d'appels?
- Il faut concaténer les éléments. Ensuite nous ajoute latlng pour avoir la latitude et longitude.
###Ou est l'information dont j'ai besoin : 
##Pour la température
- Dans le déroulant feature de l'API nous avons une balise "weather" avec dedans les balises min et max. Min et max correspondent aux températures max et min.
##Pour afficher la prévision météo
- Architecture : response>forecast>item[0]>tmin et response>forecast>item[0]>tmax
- Sélection de item[0] car c'est un tableau d'items.