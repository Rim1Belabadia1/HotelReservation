# Utiliser une image de base pour Java
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier pom.xml et les fichiers source dans le conteneur
COPY pom.xml /app
COPY src /app/src

# Télécharger les dépendances Maven
RUN apt-get update && apt-get install -y maven && \
    mvn dependency:go-offline -B

# Construire le projet
RUN mvn clean package -DskipTests

# Copier le fichier JAR résultant



# Exposer le port sur lequel votre application s'exécute
EXPOSE 8080

# Définir la commande de démarrage
ENTRYPOINT ["java", "-jar", "app.jar"]