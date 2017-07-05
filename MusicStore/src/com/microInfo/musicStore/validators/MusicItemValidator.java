package com.microInfo.musicStore.validators;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.microInfo.musicStore.domain.MusicItem;

@Component
public class MusicItemValidator implements Validator {

	@Override
	public boolean supports(Class<?> musicItem) {

		//Just compare method parameter object type with target form bean class. In our case it is MusicItem.
		boolean isMusicItem = MusicItem.class.equals(musicItem);
		return isMusicItem;
	}

	@Override
	public void validate(Object target, Errors errors) {

		System.out.println("In MusicValidator, validate() method ***");
		
		MusicItem musicItem = (MusicItem) target;
		
		System.out.println("Artist: " + musicItem.getArtist());
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.mandatory", "Title cannot be empty");
		
		
		if( musicItem.getTitle() == null || musicItem.getTitle().equals("")) {
			
			errors.rejectValue("title","","Please donot enter any special characters..");
		}
		
		if( musicItem.getArtist() == null || musicItem.getArtist().equals("") ) {
			
			errors.rejectValue("artist","","Please donot enter any special characters..");
		}
		

	}

}
