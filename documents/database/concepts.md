
## WITH clause
https://www.geeksforgeeks.org/sql-with-clause/?ref=lbp

The SQL WITH clause allows you to give a sub-query block a name (a process also called sub-query refactoring), which can be referenced in several places within the main SQL query. 

Syntax:

```
WITH temporaryTable (averageValue) as (SELECT avg(Attr1) FROM Table)
    SELECT Attr1 FROM Table, temporaryTable WHERE Table.Attr1 > temporaryTable.averageValue;
```