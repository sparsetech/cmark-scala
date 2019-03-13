# <img src="http://sparse.tech/icons/cmark.svg" width="50%">
cmark-scala provides [Scala Native](http://www.scala-native.org/) bindings for [cmark](https://github.com/jgm/cmark). cmark allows to parse, manipulate and render CommonMark documents.

The bindings were directly derived from [cmark.h](https://github.com/jgm/cmark/blob/master/src/cmark.h). Comments were retained and adapted if necessary. The naming of functions and their encapsulation follows Scala's conventions. Note that `*_new` functions were renamed to `create` as to prevent name collisions with the eponymous Scala keyword.

## Example
Please read the unit tests.

## Dependency
```scala
libraryDependencies += "tech.sparse" %%  "cmark-scala" % "0.1.0-SNAPSHOT"
```

## License
cmark-scala is licensed under the terms of the Apache v2.0 license. Its function interfaces and comments were derived from `cmark.h`, which is licensed under BSD-2-Clause.

## Authors
* Tim Nieradzik
