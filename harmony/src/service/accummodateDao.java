package service;

import java.util.List;

import model.accummodate;

public interface accummodateDao {
	boolean SaveorUpdate(accummodate R);
	boolean Delete(accummodate R);
    accummodate get(String id);
    accummodate getemail(String email);
	List<accummodate> Li();

}
