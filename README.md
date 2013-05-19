Tunes
=====

A musical web app written in clojure.

## Getting started

```
lein run -m tasks.create-db
lein migrate
lein ring-server
```

## Testing

Tunes uses [speclj](http://github.com/slagyr/speclj) and specljs for testing.
To run specs automatically as you change files:

```
lein spec -a
```
