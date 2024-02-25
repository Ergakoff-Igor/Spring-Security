package ru.ergakov.gb.repositories;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ergakov.gb.config.DbScripts;
import ru.ergakov.gb.model.Act;

import java.lang.reflect.Field;
import java.util.List;

@Repository
@AllArgsConstructor
public class ActRepository {

    private final JdbcTemplate jdbc;
    private final DbScripts dbScripts;


    /**
     * Метод получения списка всех актов из БД H2
     *
     * @return список актов
     */
    public List<Act> findAll() {
        return jdbc.query(dbScripts.getFindAll(), newActRowMapper());
    }

    /**
     * Метод сохранения акта в БД H2
     *
     * @param act акт
     * @return слхраненный акт
     */
    public Act save(Act act) {
        jdbc.update(dbScripts.getSave(), act.getReportingPeriod(), act.getProjectSection(), act.getPrice(), act.getStatus());
        return act;
    }

    /**
     * Метод удаления акта по id из БД H2
     *
     * @param id id акта
     */
    public void deleteById(int id) {
        jdbc.update(dbScripts.getDeleteById(), id);
    }

    /**
     * Метод нахождения акта по id в БД H2
     *
     * @param id id акта
     * @return акт
     */
    public Act getOne(int id) {
        return jdbc.queryForObject(dbScripts.getGetOne(), newActRowMapper(), id);
    }

    /**
     * Метод изменения акта в БД H2
     *
     * @param act акт, найденный через метод "getOne"
     * @return измененный акт
     */
    public Act updateAct(Act act) {
        jdbc.update(dbScripts.getUpdateAct(), act.getReportingPeriod(), act.getProjectSection(), act.getPrice(), act.getStatus(), act.getId());
        return act;
    }

    /**
     * Метод создания словаря Актов КС-2
     *
     * @return Словарь пользователей
     */
    private RowMapper<Act> newActRowMapper() {

        return (r, i) -> {
            Act rowObject = new Act();
            Class<? extends Act> act = rowObject.getClass();
            Field[] fields = act.getDeclaredFields();
            rowObject.setId(r.getInt(fields[0].getName()));
            rowObject.setReportingPeriod(r.getString(fields[1].getName()));
            rowObject.setProjectSection(r.getString(fields[2].getName()));
            rowObject.setPrice(r.getDouble(fields[3].getName()));
            rowObject.setStatus(r.getString(fields[4].getName()));
            return rowObject;
        };
    }
}
