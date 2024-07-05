# Utiliser une image Java de base
FROM openjdk:21-slim

# Créer un répertoire pour l'application
#WORKDIR /app

# Copier le fichier jar de l'application
COPY ../build/libs/AppCuisine-backend-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application va tourner
EXPOSE 8080

# Commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "/app.jar"]