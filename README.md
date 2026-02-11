# graphql-demo

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: <https://quarkus.io/>.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./gradlew quarkusDev
```

Open Quarkus Dev UI for GraphQL at <http://localhost:8080/q/dev-ui/quarkus-smallrye-graphql/graphql-ui>.

## Example queries

```shell script
{
  allPersons {
    name
    favoriteLocation
    address {
      city
      fullAddress
    }
  }
}
```

```shell script
{
  person(personId: 3) {
    id
    name
  }
}
```

## Related Guides

- SmallRye GraphQL ([guide](https://quarkus.io/guides/smallrye-graphql)): Create GraphQL Endpoints using the code-first approach from MicroProfile GraphQL
