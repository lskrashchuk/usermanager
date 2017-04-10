package by.intexsoft.lskrashchuk.usermanager.service;

import by.intexsoft.lskrashchuk.usermanager.model.Url;

import java.util.List;


public interface UrlService {

	Url getUrl(Integer id);
	
	void saveOrUpdate(Url url);
	
	void delete(Url url);
	
    Url find(String urlCode);

    List<Url> getAll();
    
	String redirect(Url url);

	void checkIfClicksCountChangedBeforeUpdate(Url url);

}
