# Générateur de Plateau de Jeu

Ce programme génère un plateau de jeu , avec des bâtiments et des rues. L'algorithme utilise une approche récursive pour diviser le plateau en sections de manière à créer une disposition complexe de bâtiments et de rues.

## Algorithme de Génération de Plateau

L'algorithme fonctionne de la manière suivante :

**Paramètres:**
   - int x: la coordonnée en largeur du point de départ
   - int y: la cooronnée en longueur du point de départ
   - int width: la largeur
   - int height: la longueur

**Initialisation**

Lors de l'initialisation de la classe Board, on apellera le fonction avec les paramètres suivants:
   createBoard(x:0,y:0,Board.getWidth(),Board.getHeight())

**Division Récursive :**
   - Le plateau est divisé en quatre sections de manière récursive. Chaque section peut être divisée ou non en fonction de sa taille.

   - L'algorithme continue à diviser chaque section jusqu'à ce qu'il ne trouve plus de sections suffisamment grandes pour être divisées.

**Taille Minimale des Bâtiments :**
   - Une taille minimale est définie pour les bâtiments (au moins 2 cellules dans les axes x et y) pour garantir une taille raisonnable.

**Pseudo-code & Algorithme**

void createBoard(x:int,y:int,width:int,height:int){\
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Integer a= 0;\
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Integer b = 0;\
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;if (width>=5 & height >=5){\
     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;a= math.randomInt(x+2,(width-1)+ x-2); //+2 et -2 pour la taille &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;minimale des bâtiments sur les côtés\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;b= math.randomInt(x+2, (height-1)+y-2);\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int w = |a-x|; //permet de définir la largeur des cellules par la suite\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;int h= |b-y|; //permet de définir la hauteur des cellules par la suite\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Board.theCells.getCell(a,b) -> transformer la cellule(a,b) en CellStreet\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for(int i=x;i<= width; i++){\
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Board.theCells(a+i,b) -> transformer en CellStreet\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;for(int j=y;j<= height; i++){\
         &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Board.theCells.getCell(a,b+j) -> transformer en CellStreet\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.createBoard(a-w,b-h,w,h);\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.createBoard(a+1,b-h,width-a,b-1);\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.createBoard(a+1,b+1, width-a,height-b);\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;this.createBoard(a-w,b+1,a-1, height-b);\

   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;} else {\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;On peut plus diviser mon frérot\
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;//Comment savoir où la fonction s'est terminée et donc ce qu'elle a pu changer ?\
   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}\
}\

Pour les questions: 06 58 90 98 89\
