import org.sqlite.SQLiteDataSource

beans {
    dataSource(SQLiteDataSource) {
        url = 'jdbc:sqlite:db.sqlite'
    }
}