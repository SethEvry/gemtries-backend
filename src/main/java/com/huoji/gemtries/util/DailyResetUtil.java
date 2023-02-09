package com.huoji.gemtries.util;

import com.huoji.gemtries.models.User;
import com.huoji.gemtries.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyResetUtil {
	private final UserRepository userRepository;

	public DailyResetUtil(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Scheduled(cron = "0 0 7 * * *")
	public void resetHasSubmitted(){
		int pageSize = 1000;
		int pageNumber = 0;
		boolean hasMoreDate = true;
		while(hasMoreDate) {
			Page<User> page = userRepository.findAll(PageRequest.of(pageNumber, pageSize));
			for (User user: page) {
				user.setHasSubmitted(false);
			}
			userRepository.saveAll(page);
			hasMoreDate = page.hasNext();
			pageNumber++;
		}
	}

}
