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

Tunes uses the lovely [speclj](http://github.com/slagyr/speclj) for testing.
To run specs automatically as you change files:

```
lein spec -a
```
