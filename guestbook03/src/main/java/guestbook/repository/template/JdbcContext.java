package guestbook.repository.template;

import guestbook.vo.GuestbookVo;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcContext {
    private DataSource dataSource;
    public JdbcContext(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public <E> List<E> queryForList(String query, RowMapper<GuestbookVo> rowMapper){
        return queryForListWithStatementStrategy((StatementStrategy) new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection conn) throws SQLException{

                return conn.prepareStatement(query);
            }
        }, rowMapper);
    }

    private <E> List<E> queryForListWithStatementStrategy(StatementStrategy statementStrategy, RowMapper<GuestbookVo> rowMapper) throws RuntimeException{
        List<E> result = new ArrayList<>();

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = statementStrategy.makeStatement(conn);
                ResultSet rs = pstmt.executeQuery();
        ) {

            while(rs.next()){
                E e = (E) rowMapper.mapRow(rs, rs.getRow());
                result.add(e);
            }
        } catch (SQLException e) {
            System.out.println("error:" + e);
            throw new RuntimeException(e);
        }

        return result;
    }


    public int executeUpdate(String query, Object[] params){
        return executeUpdateWithStatementStrategy(new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection conn) throws SQLException{

                PreparedStatement pstmt =  conn.prepareStatement(query);

                for(int i = 0; i < params.length; i++){
                    pstmt.setObject(i+1,params[i]);
                }

                return pstmt;
            }
        });
    }

    private int executeUpdateWithStatementStrategy(StatementStrategy statementStrategy)throws RuntimeException{

        int count = 0;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = statementStrategy.makeStatement(conn);
        ) {

            count = pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("error:" + e);
            throw new RuntimeException(e);
        }

        return count;
    }


}
