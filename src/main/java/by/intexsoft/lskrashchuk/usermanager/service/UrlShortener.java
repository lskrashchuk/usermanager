package by.intexsoft.lskrashchuk.usermanager.service;


import by.intexsoft.lskrashchuk.usermanager.model.Url;

public interface UrlShortener {
	
	String getCode (Url url);
}
