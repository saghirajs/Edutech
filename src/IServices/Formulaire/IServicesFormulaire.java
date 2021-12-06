/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IServices.Formulaire;

import Entities.Formulaire.Formulaire;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Ahmed
 */
public interface IServicesFormulaire<F> {
    
    public void ajouter(Formulaire f) throws SQLException;
    public void delete(int i) throws SQLException;
    public boolean update(Formulaire f) throws SQLException;
    public List<F>readall() throws SQLException;
    public void confirmerValidation(int idFormulaire)throws SQLException;
    public List<Formulaire> getSimpleFormulairesNonConfirmes()throws SQLException;
    public List<Formulaire> getSimpleFormulairesConfirmes() throws SQLException;
    public List<Formulaire> search(String t) throws SQLException;

    
}
