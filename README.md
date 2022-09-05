# AddressBook API with Spring Boot
 
This example app shows how to create a Spring Boot API and CRUD (create, read, update, and delete) its data with a React app.

**Prerequisites:** 
Install the following tools if you don't have them.
* [`sdkman`](https://sdkman.io/):
```bash
curl -s "https://get.sdkman.io" | bash
# or
curl -s "https://get.sdkman.io" | zsh
````
* [Java 17](http://sdkman.io)
```bash
$ sdk use java 17.0.3-zulu
````
* [Docker for Mac](https://docs.docker.com/docker-for-mac/install/)
* [`brew`](https://brew.sh/):
```bash
/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
````
* [`maven`](https://maven.apache.org/):
```bash
brew install maven 
````

* [Getting Started](#getting-started)
* [Links](#links)
* [Help](#help)
* [License](#license)

## Getting Started

To install this example application, run the following commands:

```bash
git clone git@github.com:CyberSpaceExplorer/address-book-api.git
cd address-book-api
```

This will get a copy of the project installed locally. To install all of its dependencies and start each app, follow the instructions below.

Start Docker desktop from your Mac or Windows.

To run the servers (including postgresql, application servers), run:
```bash
$ docker-compose up
````
 
```bash
$ mvn spring-boot:run -D spring-boot.run.profiles=local
```
Access available rest endpoints at `http://localhost:8080/api/userClaims` `http://localhost:8080/api/user`

## DB Queries
You can run the addressbook DB using [pgcli](https://www.pgcli.com/) with the following command:
```bash
addressbookdb

$ PGPASSWORD=addressadmin pgcli --user addressbookadmin --host localhost --dbname addressbookdb --port 5008
```

## Keycloak
[Keycloak](https://www.keycloak.org/) is the default OpenID Connect server.
To log into your application, you’ll need to have [Keycloak](https://www.keycloak.org/) up and running. You need to create the realm, client and user with Keycloak admin.

**Note:**
For KeyCloak 16.1.0 on Apple Silicon (M1)
KeyCloak may misbehave on Apple Silicon in Compatability Mode and the solution is not obvious. You may want to build the KeyCloak image locally to address. The following steps have been shown to work:
1. Clone Keycloak containers repository:
```bash 
git clone git@github.com:keycloak/keycloak-containers.git
```   
2. Open server directory:
```bash
cd keycloak-containers/server
```
3. Checkout at desired version:
```bash
git checkout 16.1.0
```
4. Build docker image:
```bash
docker build -t jboss/keycloak:16.1.0 .
```
Run Keycloak:
```bash
$ docker run --rm -p 8081:8080 -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin jboss/keycloak:16.1.0
```

## Links

This example uses the following open source libraries:

* [Spring Boot](https://spring.io/projects/spring-boot)

## Help

Please send any questions to email: xinyizhou1999@hotmail.com.

## License

MIT License, see [LICENSE](LICENSE).
