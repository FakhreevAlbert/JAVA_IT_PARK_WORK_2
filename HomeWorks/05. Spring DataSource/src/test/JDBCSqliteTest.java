import org.junit.jupiter.api.*;

import java.sql.*;

@Disabled
@DisplayName("Sqlite Test")
public class JDBCSqliteTest {
    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite");
        Assertions.assertNotNull(connection);
        return connection;
    }

    @Nested
    public class TestStatements {
        private Connection conn;

        @BeforeEach
        public void setUp() throws SQLException {
            conn = getConnection();

            Statement stmt = conn.createStatement();
            try (stmt) { // Java 9 требует только effectively final или final
                stmt.execute("DROP TABLE IF EXISTS managers");
                stmt.execute("CREATE TABLE managers(" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT NOT NULL, " +
                        "department TEXT NOT NULL);"
                );
            }
        }

        @AfterEach
        public void tearDown() throws SQLException {
            conn.close();
        }

        @Test
        public void testStatementExecute() throws SQLException {
            {
                try (Statement stmt = conn.createStatement();) {
                    boolean result = stmt.execute("INSERT INTO managers(name, department) " +
                            "VALUES ('Petya', 'IT')");
                    Assertions.assertFalse(result);
                    Assertions.assertEquals(1, stmt.getUpdateCount());
                    ResultSet rs = stmt.getResultSet();
                    try (rs) {
                        Assertions.assertNull(rs);
                    }
                }
            }

            {
                try (Statement stmt = conn.createStatement()) {
                    boolean result = stmt.execute("SELECT name FROM managers");

                    Assertions.assertTrue(result);
                    Assertions.assertEquals(-1, stmt.getUpdateCount());

                    ResultSet rs = stmt.getResultSet();
                    try (rs) {
                        Assertions.assertNotNull(rs);

                        Assertions.assertThrows(
                                SQLException.class,
                                rs::first
                        );

                        int count = 0;
                        while (rs.next()) {
                            Assertions.assertEquals(
                                    "Petya",
                                    rs.getString("name")
                            );
                            count++;
                        }
                        Assertions.assertEquals(1, count);
                    }
                }
            }
        }

        @Test
        public void testStatementAdvanced() throws SQLException {
            try (Statement stmt = conn.createStatement();) {

                stmt.execute(
                        "SELECT * FROM managers;" +
                                "INSERT INTO managers(name, department) VALUES ('Vasya', 'IT');" +
                                "SELECT * FROM managers;"
                );

                ResultSet first = stmt.getResultSet();
                try (first) {
                    int count = 0;
                    while (first.next()) {
                        count++;
                    }
                    Assertions.assertEquals(0, count);
                }

                stmt.getMoreResults(); // не поддерживается в SQLite

                Assertions.assertEquals(-1, stmt.getUpdateCount());
            }
        }
    }
}

