/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pijavaparty.proderp.dao;

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
