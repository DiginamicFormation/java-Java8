package java17.ex01;

import java.util.List;


import org.junit.Test;



import java17.data.Data;
import java17.data.Person;


/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

    // tag::IDao[]
    interface IDao {
    	
        List<Person> findAll();
        
        // TODO créer une méthode int sumAge()
        // TODO Cette méthode retourne le résultat de l'addition des ages des personnes
        public default int sumAge() {
        	int result = 0;
        	for (Person personne :findAll()) {
        		result += personne.getAge();
        	}
        	return result;
        }

    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    
    @Test
    public void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        DaoA ex1 = new DaoA();
        int result = ex1.sumAge();
        
        

        assert result == 210;
    }

    @Test
    public void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        // TODO invoquer la méthode sumAge pour que le test soit passant
        DaoB ex1 = new DaoB();
        int result = ex1.sumAge();
        

        assert result == 5050;

    }
}