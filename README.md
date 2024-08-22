# Application Cuisine

Application de création de recette et de suivi de sa nourriture

## TODO
 - [X] Ajout flyway
 - [X] sécurité et auth
 - [ ] page inscription
 - [ ] erreur identifiant / mdp
 - [ ] modélisation bdd
 - [ ] création tables bdd
 - [ ] Lien webapp <-> api nutritionix / edamame
 - [ ] recherche ingrédient nutrionix
 - [ ] auto complete
 - [ ] CI back
 - [ ] CI front

## Features
utilisateur profil
ajouter une recette
    -> ingrédient
    -> ustensiles
    -> cuisson
    -> difficulté
tags recette
fork une recette
mettre à jour une recette -> versionning en mode git
Recette -> Ingrédient -> Action -> Complément
Rechercher ingrédient dans api nutritionix
bilan nutritionnel recette
génération liste course en fonction des recettes souhaitées
chercher une recette

## Set Up
### créer bdd
```
    CREATE DATABASE app_cuisine;
    CREATE SCHEMA app_cuisine;
```
