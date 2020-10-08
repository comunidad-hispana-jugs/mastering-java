# JDKFUNDAMENTALKS 
## Objetos Mutables e Imutables

- Mutable = que pueden ser modificados. (Literales).
- Inmutables = que  no pueden ser alterados.

#### Tipos Inmutables:
CHAR, STRING, BOOLEAN, FLOAT, DOUBLE, CHAR, ENUM  

STRING  (INMUTABLE)  CHAR(2/UNI):
 - STRINGBUILDER (Mutable)
 - STRINGBUFFER  (Mutable) (?)
 
'
 
  MODIFICADORES
 - FINAL
 

#### Cuando usar?

Ventajas:
- Aplicaciones concurrentes
- MultiHilo
- Memoria
- Contenido estatico
- Garbage Collector

### List.of and Arrays.asList 
- Arrays.asList return mutable
- Arrays.asList devuelve una lista mutable, mientras que la lista devuelta por List.of es inmutable:
- Arrays.asList permite elementos nulos, mientras que List.of no