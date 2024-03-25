### 3.5 Implement Join: Strategy for extracting join conditions
In the _SelectStatement_ class, the where expression extracted using _getWhere_ is split into a
list of constituent expressions using the _splitWhereExpression_ function. Then, we find the number of tables involved in each expression
using the _parseTablesInvolved_ function which splits the expression string and checks if the
left and right hand side of the expression is a table. If two tables are involved in the expression, 
it indicates that the condition is a join condition, else it is a selection condition. For example,
tables involved is 2 for the condition, S.A=R.A, 1 for S.A=1 and 0 for 1<2. 

Using tables involved check, we create two intermediate hashmaps, _whereSelectOnly_ 
and _whereJoinOnly_ for storing the individual select and join conditions of all 
the tables involved in the query. These conditions are finally joined using the
_joinWhereExpression_ function and the results are stored in the final hashmaps, _selectConditionsMap_ and
_joinConditionsMap_, which are used during the process of generating the operators in the
query plan. For example, _selectConditionsMap_ could be {'Sailors':Expression object of "Sailors.A=1"} and
_joinConditionsMap_ could be {'Sailors':Expression object of "Sailors.A=Reserves.A"}
