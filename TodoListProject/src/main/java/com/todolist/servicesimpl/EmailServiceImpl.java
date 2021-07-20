package com.todolist.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.todolist.dao.TaskDao;
import com.todolist.dao.UserDao;
import com.todolist.models.Task;
import com.todolist.models.User;
import com.todolist.services.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private UserDao userDao;

	@Autowired
	private TaskDao taskDao;

	@Scheduled(fixedRate = 86400000)
	public boolean runScheduler() {
		List<User> userEntities = userDao.findAll();
		for (User user : userEntities) {
			List<Task> taskEntities = taskDao.findByUsername(user.getEmail());
			int count = 1;
			StringBuilder sb = new StringBuilder(
					String.format("%-5s | %-20s | %-10s | %-2s | %n", "S.No.", "Task Name", "Due Date", "P."));
			for (Task task : taskEntities) {
				String[] dueDateStr = String.valueOf(task.getDueDate()).split(" ");
				sb.append(String.format("%-5s | %-20s | %-10s | %-2s | %n", count, (task.getName()), dueDateStr[0],
						(task.getPriority())));
				count = count + 1;
			}
			sendMail(user.getEmail(),
					"Hi , Your \"to do list\" is here : \n\n" + sb.toString() + "\nThank You \nYour to-do-list",
					"Your daily briefing");
		}
		return true;
	}

	@Override
	public void sendMail(String toEmail, String body, String subject) {

		if (toEmail != null && body != null && subject != null) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(toEmail);
			message.setFrom("silkchannel2@gmail.com");
			message.setSubject(subject);
			message.setText(body);
			mailSender.send(message);
		}
	}

}
