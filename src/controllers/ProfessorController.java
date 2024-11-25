package controllers;

import dao.ProfessorDAO;
import models.Professor;

import java.util.List;

public class ProfessorController {

    // Método para salvar o professor (delegando ao DAO)
    public boolean salvarProfessor(Professor professor) {
        return ProfessorDAO.salvarProfessor(professor);
    }

    // Método para obter disciplinas disponíveis (delegando ao DAO)
    public List<String> getDisciplinas() {
        return ProfessorDAO.getDisciplinas();
    }
}
