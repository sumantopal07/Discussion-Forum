    package com.au.discussionforum;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.au.discussionforum.dao.CommentRepository;
import com.au.discussionforum.model.Answer;
import com.au.discussionforum.model.Comment;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.model.User;

import com.au.discussionforum.service.CommentService;

@SpringBootTest
class CommentServiceTest {

	@Autowired
	private CommentService commentService;
	
	@MockBean
	private CommentRepository commentRepository;
	
	
	
	@Test
	void getCommentsByAnswerIdTest() {
				
		User user1= new User();
		user1.setUserId(4);
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1234");
		user1.setUsername("Rupali");
		user1.setPhoto("img.jpg");
		
		Topic topic1= new Topic();
		topic1.setTopicId(1);
		topic1.setTopicName("country");
		
       Question ques1= new Question();
       ques1.setQuesId(1);
       ques1.setUser(user1);
       ques1.setTopic(topic1);
       ques1.setTitle("national game");
       ques1.setBody("Which is our national game?");
       ques1.setMarked(false);
       
		
		Answer ans= new Answer(1,user1,ques1,"hockey is our national game",true);
		Comment comment1 = new Comment(1,user1,ans,"it's a first comment");
			
        Comment comment2= new Comment();
		
		User user2= new User();
		user2.setUserId(5);
		user2.setEmail("abc@gmail.com");
		user2.setPassword("12");
		user2.setUsername("Rupali");
		user2.setPhoto("img.jpg");
		
		Topic topic2= new Topic();
		topic2.setTopicId(2);
		topic2.setTopicName("country");
		
       Question ques2= new Question();
       ques2.setQuesId(2);
       ques2.setUser(user2);
       ques2.setTopic(topic2);
       ques2.setTitle("national game");
       ques2.setBody("Which is our national game?");
       ques2.setMarked(false);
       
		int ans_id=1;
		
		Answer ans2= new Answer(1,user2,ques2,"hockey is our national game",true);
		comment2.setCommentId(2);
		comment2.setUser(user2);
		comment2.setAnswer(ans2);
		comment2.setCommentBody("it's second comment");
		
		String comment = "Comment [commentId=" + comment2.getCommentId() + ", user=" + comment2.getUser() + ", answer=" + comment2.getAnswer() + ", commentBody="
				+ comment2.getCommentBody() + "]";

		assertEquals(comment,comment2.toString());
		
		List<Comment> comm_list= new ArrayList<>();
		comm_list.add(comment1);
		comm_list.add(comment2);
		
		when(commentRepository.findByAnswerAnsId(ans_id)).thenReturn(Stream.of(comment1,comment2).collect(Collectors.toList()));
		assertEquals(2,commentService.getCommentsByAnswerId(ans_id).size());
		
	}
	
	@Test
	void addCommentTest() {
    Comment comment1= new Comment();
		
		User user1= new User();
		user1.setUserId(4);
		user1.setEmail("abc@gmail.com");
		user1.setPassword("1234");
		user1.setUsername("Rupali");
		user1.setPhoto("img.jpg");
		
		Topic topic1= new Topic();
		topic1.setTopicId(1);
		topic1.setTopicName("country");
		
       Question ques1= new Question();
       ques1.setQuesId(1);
       ques1.setUser(user1);
       ques1.setTopic(topic1);
       ques1.setTitle("national game");
       ques1.setBody("Which is our national game?");
       ques1.setMarked(false);
       
		
		Answer ans= new Answer(1,user1,ques1,"hockey is our national game",true);
		comment1.setCommentId(1);
		comment1.setUser(user1);
		comment1.setAnswer(ans);
		comment1.setCommentBody("it's a first comment");
		
		commentService.addComment(comment1);
		
		verify(commentRepository,times(1)).save(comment1);
	}
	
}