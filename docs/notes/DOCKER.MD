### Inicializando os containers (PostgreSQL como banco de dados e PGAdmin como ferramenta de administração) e conectando-os via network (Localmente).

##### Criando uma network
```
$ docker network create <nome_da_network>
# Vou nomear a network como booksearch-network
```

#### Conectando os containers na network
##### PGAdmin
```
docker run -p 1542:80 \
  --name pgadmin4 \
  -e PGADMIN_DEFAULT_EMAIL=admin@admin.com \
  -e PGADMIN_DEFAULT_PASSWORD=admin \
  --network booksearch-network \
  dpage/pgadmin4
```

##### Banco de dados PostgreSQL
```
docker run --name booksearchdb \
  -p 5432:5432 \
  -e POSTGRES_PASSWORD=postgres \
  -e POSTGRES_USER=postgres \
  -e POSTGRES_DB=booksearch \
  --network booksearch-network \
  postgres:16.3
```

### Entendendo alguns comandos Docker
##### É necessário compreender que:
##### -> 1. Uma imagem é uma receita do container, 
##### -> 2. Um container é uma instância em execução da imagem.
```
$ docker start <nome_do_container> # Vai inicializar o container docker caso exista
$ docker stop <nome_do_container> # Vai pausar a instância do container docker
$ docker run <imagem> # Inicializará um container Docker a partir de uma imagem. Baixará a imagem caso não exista.
$ docker ps # Listará todos os containers em execução
$ docker ps -a # A flag -a trás um diferencial, nessa instrução trará listado todos os containers pausados
```