package ru.ergakov.gb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ergakov.gb.model.Act;
import ru.ergakov.gb.repositories.ActRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ActService {
    private final ActRepository actRepository;

    /**
     * Метод получения списка всех актов
     *
     * @return список актов
     */
    public List<Act> findAll(){
        return actRepository.findAll();
    }

    /**
     * Метод сохранения акта
     *
     * @param act акт
     * @return слхраненный акт
     */
    public Act saveAct(Act act){
        return actRepository.save(act);
    }

    /**
     * Метод удаления акта по id
     *
     * @param id id акта
     */
    public void deleteById(int id){
        actRepository.deleteById(id);
    }

    /**
     * Метод нахождения акта по id
     *
     * @param id id акта
     * @return акт
     */
    public Act getOneActByID(int id)  {
       return actRepository.getOne(id);
    }

    /**
     * Метод изменения акта
     *
     * @param act акт, найденный через метод "getOne"
     * @return измененный акт
     */
    public Act updateAct(Act act){
        return actRepository.updateAct(act);
    }
}
