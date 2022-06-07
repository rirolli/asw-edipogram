# compila il progetto e crea i vari JDK
echo Building project
gradle build

# avvia il docker compose
echo Starting docker compose
docker compose build
docker compose push
docker compose up -d