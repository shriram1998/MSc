package ed.inf.adbs.lightdb.core.parser;

import ed.inf.adbs.lightdb.core.executor.ExpressionEvaluator;
import ed.inf.adbs.lightdb.core.executor.operators.Operator;
import ed.inf.adbs.lightdb.core.executor.operators.ProjectOperator;
import ed.inf.adbs.lightdb.core.executor.operators.ScanOperator;
import ed.inf.adbs.lightdb.core.executor.operators.SelectOperator;
import ed.inf.adbs.lightdb.metadata.Catalog;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExpressionVisitorAdapter;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitorAdapter;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.SelectVisitorAdapter;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.io.IOException;
import java.util.Map;

public class SQLParser {
    // Define a select visitor that invokes the expression visitor
    public SelectVisitorAdapter selectVisitor = new SelectVisitorAdapter() {
        private final Catalog catalog=Catalog.getInstance();
        public void visit(PlainSelect plainSelect) {
            // Visit the select items
            String tableName = plainSelect.getFromItem().toString();
            Operator scanOperator = null;
            try {
                scanOperator = new ScanOperator(tableName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Operator rootOperator = scanOperator;

//            ExpressionVisitorAdapter expressionVisitorAdapter=new ExpressionEvaluator(catalog.getColumnMapping(tableName));
//            for (SelectItem item : plainSelect.getSelectItems()) {
//                item.accept(expressionVisitorAdapter);
//            }

            if (plainSelect.getSelectItems()!=null) {
                if(plainSelect.getWhere() != null){
                    SelectOperator selectOperator=new SelectOperator(rootOperator,plainSelect.getWhere(),catalog.getColumnMapping(tableName));
                    rootOperator=new ProjectOperator(selectOperator,plainSelect.getSelectItems(),catalog.getColumnMapping(tableName));
                }else{
                    rootOperator=new ProjectOperator(rootOperator,plainSelect.getSelectItems(),catalog.getColumnMapping(tableName));
                }
            }
            else if (plainSelect.getWhere() != null) {
                rootOperator=new SelectOperator(rootOperator,plainSelect.getWhere(),catalog.getColumnMapping(tableName));
            }

            // Assuming Operator class has an execute or similar method
            try {
                rootOperator.dump(System.out);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    };

    // Define a statement visitor that invokes the select visitor
    public StatementVisitorAdapter statementVisitor = new StatementVisitorAdapter() {
        public void visit(Select select) {
            select.getSelectBody().accept(selectVisitor);
//            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
//            String tableName = tablesNamesFinder.getTableList((Statement) select).get(0); // Assuming one table
        }
    };
}
