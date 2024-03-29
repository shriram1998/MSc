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

### Query optimization

1. Selection Pushdown:
If Selections are pushed as close as possible to the data source (scan operators), the number of tuples processed in subsequent operations is reduced. While generating a query plan using the executeQuery function in the SelectStatement class, selections are applied before joins or aggregations to minimize the size of the data that needs to be joined or aggregated.

2. Hash-based SUM or GROUP BY:
In the SumOperator class, a hash table is used to aggregate values by key efficiently. This is particularly effective for operations like SUM when combined with GROUP BY. For queries with only GROUP BY, hashset is used to store a set of unique GROUP BY values for the table. For queries with SUM without GROUP BY, the result is aggregated in a single integer.

3. Sum operator optimization:
On initialization, the SumOperator class extracts tuples from its child operator one by one and calculates the GROUP BY and SUM for the query. Thus, the operator builds the SUM and GROUP BY results efficiently without the bottleneck of large intermediate results that may be produced by possible join operations.

4. ORDER BY or DISTINCT after SUM or GROUP BY:
Since the output of SUM or GROUP BY is usually small, the operations that follow such as project, order by and distinct are called in memory to reduce function call overhead.

5. Projection pushdown:
If Projections are pushed as close as possible to the data source, the number of columns processed in subsequent operations is reduced. While generating a query plan using the executeQuery function in SelectStatement classes, projections are applied before ORDER BY or DISTINCT to minimize the size of the data that needs to be processed for sorting or duplicate elimination.

Other optimization

1. Tuple data type:
Even though, JSQLParser provides data as LongValue (long), the fields are cast to integer before processing. This makes query execution faster since since the input database only has integer values and the memory occupied by an integer is half that of a long value.