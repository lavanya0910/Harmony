package service;

import java.util.List;

import model.PaperUplode;

public interface PaperUplodeDao {
	boolean SaveorUpdate(PaperUplode R);
	boolean Delete(PaperUplode R);
    PaperUplode get(int id);
    
	List<PaperUplode> Li();
	List<PaperUplode> Lis();
    List<PaperUplode> Liss();

}
