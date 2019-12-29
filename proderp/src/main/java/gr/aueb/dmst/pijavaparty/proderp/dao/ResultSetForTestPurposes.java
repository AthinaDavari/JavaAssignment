package gr.aueb.dmst.pijavaparty.proderp.dao;

import com.mysql.cj.jdbc.JdbcConnection;
import com.mysql.cj.jdbc.StatementImpl;
import com.mysql.cj.jdbc.result.ResultSetImpl;
import com.mysql.cj.protocol.a.result.OkPacket;

/**
 *
 * @author athina
 */
public class ResultSetForTestPurposes extends ResultSetImpl{
    
    public ResultSetForTestPurposes(OkPacket ok, JdbcConnection conn, StatementImpl creatorStmt) {
        super(ok, conn, creatorStmt);
    }
    
}
