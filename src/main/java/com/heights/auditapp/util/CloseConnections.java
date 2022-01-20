package com.heights.auditapp.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CloseConnections {

    private static final Logger log = LoggerFactory.getLogger(CloseConnections.class);

    public static void closeFinally(Connection conn, CallableStatement cll) {
        try {
            if (cll != null && !cll.isClosed())
                cll.close();

            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    public static void closeFinally(Connection conn, CallableStatement cll, ResultSet rs) {
        try {
            if (rs != null && !rs.isClosed())
                rs.close();

            if (cll != null && !cll.isClosed())
                cll.close();

            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
