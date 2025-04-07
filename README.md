# l2s4-projet-2024

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)
Un unique fork doit être réalisé par équipe.

Une fois cela réalisé, supprimer ces premières lignes et remplissez les noms des membres de votre équipe.
N'oubliez pas d'ajouter les autres membres de votre équipe aux membres du projet, ainsi que votre enseignant·e (statut Maintainer).

# Equipe

- Soufiane Derouich
- Ilias Boudi
- Maxime Boumbas
- Mohamed Attalah

# DIAPO
https://1drv.ms/p/s!AoVJc6K8nQzDbM1WULIv6huLcV4?e=vVovgT

# UML
[UML](https://lucid.app/lucidchart/2171d979-3fdf-4af7-bb4e-c3638112c36f/edit?existing=1&token=7638b64c2e6e9b186b4c4f6f4abb36e9e1cb5dbcc7773c1e87919be5dcadab09-eml%3Dderouichsoufiane1%2540gmail.com%26ts%3D1705649297%26uid%3D191126640&docId=2171d979-3fdf-4af7-bb4e-c3638112c36f&shared=true&invitationId=inv_c264cf54-c788-4e72-9603-4f7a8759a26e&page=0_0#)

# Sujet

[Le sujet 2024](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2024.pdf)

# Livrables
## Compilation des dossiers :
```javac -sourcepath src src/*/*.java -d classes```
## Execution :
```java -classpath classes Board.BoardMain arg arg ```
## Livrable 1

### Atteinte des objectifs
Tous les objectifs visés sont atteint.
### Difficultés restant à résoudre
Alors heureusement on trouve pas encore de difficultés à résoudre pour ce livrable 1.
### Evolution
Alors pour ce qui est modification pour ce livrable, on géré les portes qui sont tout le temps fermés et on peux pas les ouvrir(sur les extremités du plateau), et ceux qui sont ouverts qui s'étalent sur le carrefour.Et on a optimiser notre code en enlevant et en modifiant des méthodes pour mieux concevoir l'approche.

## Livrable 2


### Atteinte des objectifs
Executable qui affiche le bon fonctionnement des méthodes qu'on a implémenté pour ce livrable.
### Difficultés restant à résoudre
-spawn des zombies
-choix pour les survivants de prendre un équipement parmis une liste d'équipements.
-Affchage des acteurs dans le board et gérer leur déplacements
## Livrable 3

### Atteinte des objectifs
Executable qui créer bien le plateau avec les survivants, les rôles ,les zombies et les objets. Mais encore de nombreuses difficultés avec les actions.
### Difficultés restantes à résoudre
- Mieux gérer l'affichage
- Rendre l'éxécutable intéractif
- attaque et déplacement des zombies
- prendre un objet en main (débbugage)
- regarder autour de soi (débbugage)

## Livrable 4
Compilation des classes : make cls
Doc : make doc
Jar : make zombicide.jar
Execution : java -jar zombicide.jar `arg` `arg` `arg`

### Atteinte des objectifs
Pour ce dernier livrable du projet , les  objectifs d'une bonne finalisation du jeu Zombicide comme souhaité n'ont pas très bien été atteints.Sur les 3 premiers livrables on a bien gérer 
les classes et les fonctionnalités demandés, et pour ce dernier livrable on a eu une mauvaise approche au début pour réaliser le main final de manière interactive , mais on assez bien rattrapez le coup avec notre executable final qui gere bien le lien entre les 4 livrables (l'affichage du board , la mise en place des équipements , la modélistation des actions et leurs fonctionnements pour les acteurs et au final le systeme des tours).


### Difficultés restant à résoudre
- La phase des zombies pas bien fonctionnel
- Manque de tests pour des classes

# Journal de bord

## Semaine 1 
Afin de modéliser le plateaux de jeu,  on a consacré la séance à l'algorithme de création de ce dernier ainsi quà ses diagrammes UML. On s'est notamment préoccupés de la gestion des cases du plateau avec les pièces et les rues, et les différentes zones spéciales.
En dehors de la séance on a réfléchi à l’écriture de l’algorithme pour la construction du plateau avec les zones consacrées et comment s’y prendre.
Pour la semaine semaine prochaine on prévoit d’avancer sur l’UML et de commencer nos premières lignes de code pour la construction du plateau de jeu.



## Semaine 2
Au cours de la semaine, on a pris une toute autre direction pour définir l'algorithme.En effet, on imaginait parcourir chaque cases pour décider, selon certaines conditions, si celle-ci allait être une pièce, une rue et/ou une case spéciale. Notre professeur nous a redirigé vers un algorithme de division récursive.Ce qui s'est avéré plus simple.
On a également coder certaines classes de l'UML afin de ne pas prendre de retard pour le livrable 1 de la semaine prochaine.
Pour la semaine prochaine, on prévoit de finaliser la création de cet algorithme et de modéliser entièrement le plateau de jeu.

## Semaine 3
Au cours de la semaine , on a implémenté l'algo qu'on a proposé en java , adapter l'UML avec les nouvelles classes 
qu'on a ajouté (Continental,Pharmacy,Bouche d'égout), et les codes données .Cependant notre algorithme il affichait
que les Rooms et les Streets , alors on les a ajustés pour qu'ils affichent ces zones spéciales bien comme il faut.
On a ajouter des tests pour les classes définis et un gitignore pour ignorer les fichiers qui se produisait avant 
qu'on on compiler les classes et ça créer des dossiers non souhaitables.Normalement le livrable 1 est complet et bien fonctionnel.Il y'auras on suppose des modifications pour l'adapter pour les prochains livrables et évidemment  
ça ne vas influencer notre démarche qu'on a proposé.
## Semaine 4
Au cours de cette semaine ,on a commencer le livrable 2, avec la modélisation des UMl des différents acteurs du jeu,et les armes pour les équipements , et on a essayer de réflechir à la liason des équipements dissimulés dans la carte et les pièces avec l'algo de création de la carte qu'on a réalisé dans le livrable 2.
En ce qui concerne le code, on a commencé à en écrire pour les classes qu'on a modéliser dans l'UML 
mais pas encore de méthodes complexes pour l'instant.
Pour la semaine prochaine on prévoit d'écrire le code pour la dissimulation des équiquements dans les pièces, et la gestion de l'inventaire.
## Semaine 5
Au cours de cette semaine on a mis à jour notre UMl pour les nouvelles classes et liens d'héritage du livrable 2, on a réalisé des petites modifications pour le Board et les portes qui les rendent plus optimale, pour les codes des classes on s'est focalisé sur les équipements et les différents attributs et méthodes qu'on peut utiliser (on a laissé tout ce qui est action,effet sur les acteurs du jeu pour le livrable qui s'interesse aux actions), et des algo pour la géneration des équipementts dans le Board aléatoirement.
Pour la semaine prochaine on prévoit de se concentrer sur la gestion de prendre en main un équipement pour les survivant et la gestion de drop ou prendre un équipement.
## Semaine 6
Au cours de cette semaine on a réalisé les dernières modifications pour la finilisation du livrable 2,
Alors on a effectuer pour le survivor des méthodes pour récupérer le contenu de son sac à dos et les équipements qu'il possede et ce qu'il a en main. Pour les cases on s'est mis sur l'ajout des survivants et des zombies pour chaque case, effectivement pour le spawn des zombies on a nécessiter de modéliser les actions du coup on vas s'y intéresser au prochain livrable.Aussi les équipements et armes que contient chaque case du plateau. On a uni tous ces modification à l'executable du livrable 1
et accompagner avec l'affichage des acteurs et leurs attribuant des équipements et en récupérant le contenu des cases avec description.

## Semaine 7
Cette semaine, nous avons implémenté la méthode use dans la classe abstraite Equipement, héritée par les sous-classes d'équipements. Nous avons ensuite utilisé cette méthode dans la classe Survivor pour permettre aux survivants d'interagir avec leurs équipements. Chaque sous-classe d'équipement a été adaptée avec une substitution de la méthode use pour garantir un comportement approprié.
## Semaine 8
Cette semaine , on a mis en évidence le lien entre les super classes Action et Survivant et comment un survivant peut executer une action , et les actions possibles qu'il peut executer ou non, et l'ajout de ces actions à l'initialisation, et la gestion d'execution pour chaque role de type survivant prècis.On a ajouté des classes d'actions et on les a adaptés aux autre classes qu'on a prècedement définis.Pour la semaine prochaine on prévois de faire l'executable pour le livrable 3 et essayer de le finaliser.
## Semaine 9
Cette semaine, on a revu le système de portes. En effet, le précédant créé deux portes entre chaque cases. On a continué le débuggage des actions en procédant d'autres manières. Puis on a tenté de terminer le livrable 3 malgré un débuggage non concluant dans le temps imparti de certaines actions. Pour la semaine prochaine, on prévoit de corriger toutes les actions, d'avoir un bon affichage et de commencer à mettre en place le système de tours.
## Semaine 10
Cette semaine on est revenu sur le livrable 3 pour corriger des mauvaises implémentation de méthodes et ajouter des nouvelles qui manquait et était essentiel pour ce livrable des actions.On avait quelques doutes et des questionnement , et même une mauvaise approche du sujet au niveau des actions et quel genre d'action peut un survivor executer ou non , on a surtout revu ça et ajouter des modification pour le bon fonctionnement des phases des jeu et les tours ,qu'on vas aborder pour le rendu final
## Semaine 11

## Semaine 12
