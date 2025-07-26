Adrien Jaufre
# Projet Aventurier

## OBJECTIF
Concevoir et écrire un programme java s'exécutant sur une JVM ≥ 1.8 implémentant la spécification ci-dessous.
Le code écrit permettra d’identifier différents critères de qualité :
- Conception objet
- Qualité de nommage
- Qualité et concision de la documentation
- Tests
- …
 
Un héros s'aventurait dans un monde dangereux,  
Frayant son passage dans les bois obscurs.

## Description
Il s'agit de modéliser les déplacements d'un personnage sur une carte.
 
## Carte
La carte est modélisée à l'aide de caractères dans un fichier texte au format UTF-8 (voir pièce jointe)
 
Exemple :
```txt
### ###### ###
### ## ###
## ## ## ##
# ## ## #
## ##
##### #####
###### ## ## #####
# ###### #
########
############
############
######## #
# ###### ##
###### ## ## ######
##### #####
## ##
# ## # # ## #
## ## ## ##
### # # ###
### ###### ###
```
 
 
## Légende
```txt
# bois impénétrables
[ ] (caractère espace) : case où le personnage peut se déplacer
```
 
## Déplacement du personnage
Les déplacements du personnage sont définis par un fichier avec les caractéristiques suivantes :
- encodage: UTF-8
- Première ligne :
    - Contient les coordonnées initiales du personnage sous la forme "x,y"
    - Les coordonnées (0,0) correspondent au coin supérieur gauche de la carte
- Deuxième ligne :
    - Les déplacements du personnage définis sous la forme d'une succession de caractère représentant les directions cardinale (N,S,E,O)
    - Chaque caractère correspond au déplacement d'une case

## Interaction avec les éléments de la carte
Le personnage ne peut pas aller au-delà des bords de la carte.
Le personnage ne peut pas aller sur les cases occupées par les bois impénétrables.
 
## Test
### Premier test
Le fichier suivant est fourni en entrée :
3,0
SSSSEEEEEENN
 
Résultat attendu :
Le personnage doit se trouver en (9,2)
 
### Deuxième test
Le fichier suivant est fourni en entrée :
6,7
OONOOOSSO
 
Résultat attendu :
Le personnage doit se trouver en (1,9)