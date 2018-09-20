package service;
import java.util.List;

import model.Registration;



public interface RegistrationDao
{
	boolean SaveorUpdate(Registration R);
	boolean Delete(Registration R);
    Registration get(int id);
    Registration getemail(String email);
	List<Registration> Li();
}