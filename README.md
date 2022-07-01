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

To run the server, run:
 
```bash
./mvnw spring-boot:run
```

## DB Queries
You can run the addressbook DB using `pgcli` with the following command:
```bash
addressbookdb

PGPASSWORD=addressadmin pgcli --user addressbookadmin --host localhost --dbname addressbookdb --port 5008
```


## Links

This example uses the following open source libraries:

* [Spring Boot](https://spring.io/projects/spring-boot)

## Help

Please send any questions to email: xinyizhou1999@hotmail.com.

## License

Apache 2.0, see [LICENSE](LICENSE).
