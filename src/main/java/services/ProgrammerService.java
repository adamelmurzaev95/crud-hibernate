package services;

import dao.ProgrammerDAO;
import model.Programmer;

import java.util.List;

public class ProgrammerService {
    private ProgrammerDAO programmerDAO = new ProgrammerDAO();

    public ProgrammerService(){

    }

    public Programmer findProgrammerById(int id){
        return programmerDAO.findById(id);
    }

    public void saveProgrammer(Programmer programmer){
        programmerDAO.save(programmer);
    }

    public void updateProgrammer(Programmer programmer){
        programmerDAO.update(programmer);
    }

    public void deleteProgrammer(Programmer programmer){
        programmerDAO.delete(programmer);
    }

    public List<Programmer> findAllProgrammers(){
        return programmerDAO.findAllProgrammers();
    }
}
