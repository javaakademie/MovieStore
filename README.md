# MovieStore
JavaEE 8 MVC 1.0 - Beispielanwendung zum actionbasierten Framework von Java EE. Die Anwendung dient der Erfassung von Filmen unter Hinzunahme des entsprechenden YouTube-Links. Letzteres dient dem Zugriff auf ein Vorschaubild zum Film.
Verwendet wird die Referenzimplementierung Ozark und die Anwendung ist auf dem WildFly 10 lauffähig. 

<p align="center"><br/>
  <img src="https://github.com/javaakademie/MovieStore/blob/master/preview.png" border="0">
</p>

## Aufruf ##

http://localhost:8080/moviestore/mvc/movies

## Film anlegen ##

Wenn ein neuer Film über das Formular angelegt werden soll, wird nach der YouTube-Id gefragt. Diese Angabe ist optional.
Die YouTube-Id findet man hinter dem URL-Parameter v des vollständigen Links zum Video.

Beispiel:
https://www.youtube.com/watch?v=gGkYW_CFTJk

Die YouTube-Id für dieses Video lautet dann "gGkYW_CFTJk".


## Links ##

* [JSR 371: Model-View-Controller (MVC 1.0) Specification](https://jcp.org/en/jsr/detail?id=371)
* [Referenzimplementierung Ozark](https://ozark.java.net)
* [Blog: MVC Ozark mit WildFly und Tomcat](http://javaakademie.de/blog/java-ee-8-mvc-ozark-wildfly-tomcat)
