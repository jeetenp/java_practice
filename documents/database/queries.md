## Queries

## Select Nth maximum salary from a Table or Select maximum N salaries from EMP Table

[Reference](https://www.geeksforgeeks.org/find-nth-highest-salary-table)

* DENSE_RANK computes the rank of a row in an ordered group of rows and returns the rank as a NUMBER.
* This function accepts arguments as any numeric data type and returns NUMBER.

```
select * from(
        select ename, sal, dense_rank() over(order by sal desc)r from Employee
) where r=&n;

To find to the 2nd highest sal set n = 2
To find 3rd highest sal set n = 3 and so on.

```

```
select * from (
    (select * from Employee ORDER BY `sal` DESC limit 6 ) AS T
) ORDER BY T.`sal` ASC limit 1;

Alternate use of Limit:

select * from Employee ORDER BY `sal` ASC limit 5,1; // will return 6th highest

```

## Select maximum N salaries from each Department of EMP table
[Reference](https://www.geeksforgeeks.org/sql-query-to-find-the-highest-salary-of-each-department)

```
SELECT DEPT_ID, MAX(SALARY) FROM department GROUP BY DEPT_ID;
```

## Select/Delete duplicate rows from EMP table

```
DELETE FROM DETAILS WHERE SN NOT IN (
    SELECT MAX(SN) FROM DETAILS GROUP BY EMPNAME,DEPT,CONTACTNO,CITY
)
```

```
DELETE FROM fruits WHERE
  rowid NOT IN
  (
    SELECT
      MIN(rowid)
    FROM
      fruits
    GROUP BY
      fruit_id,
      fruit_name,
      color
  );
```