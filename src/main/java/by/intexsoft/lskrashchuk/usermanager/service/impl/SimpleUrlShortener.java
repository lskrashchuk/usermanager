package by.intexsoft.lskrashchuk.usermanager.service.impl;

import by.intexsoft.lskrashchuk.usermanager.model.Url;
import by.intexsoft.lskrashchuk.usermanager.repository.UrlRepository;
import by.intexsoft.lskrashchuk.usermanager.service.UrlShortener;
import org.springframework.stereotype.Service;

import javax.inject.Inject;


@Service
public class SimpleUrlShortener implements UrlShortener {

	@Inject
	private UrlRepository urlRepository;

	@Override
	public String getCode(Url url) {
		// random int 10000..99999
		String result;
		do {
			int i = 10000 + (int) (Math.random() * ((99999 - 10000) + 1));
			result = Integer.toString(i);
		} while (urlRepository.findByUrlCode(result) != null);

		return result;
	}

}
