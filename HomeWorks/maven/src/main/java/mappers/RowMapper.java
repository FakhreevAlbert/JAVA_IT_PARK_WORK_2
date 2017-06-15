package mappers;


public interface RowMapper<T> {
    T mapRow(String row);

}
