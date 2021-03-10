  package com.au.discussionforum;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.au.discussionforum.controller.CommentController;
import com.au.discussionforum.model.Answer;
import com.au.discussionforum.model.Comment;
import com.au.discussionforum.model.Question;
import com.au.discussionforum.model.Topic;
import com.au.discussionforum.model.User;
import com.au.discussionforum.model.dto.CommentDTO;
import com.au.discussionforum.service.AnswerService;
import com.au.discussionforum.service.CommentService;
import com.au.discussionforum.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
class CommentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	CommentService commentService;
	
	@MockBean
    private UserService userService;
	
	@MockBean
	private AnswerService answerService;
	
	
	@Test
	void getCommentsTest() throws JsonProcessingException, Exception {
		
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
		
		List<Comment> comm_list= new ArrayList<>();
		comm_list.add(comment1);
		comm_list.add(comment2);
		
      when(commentService.getCommentsByAnswerId(ans_id)).thenReturn(comm_list);
		
		String url = "/api/comment/{ansid}";
		MvcResult mvcResult = mockMvc.perform(
											get(url,1)
											.contentType("application/json")
											.content(objectMapper.writeValueAsString(comm_list))
										).andExpect(status().isOk()).andReturn();
		
		String actualJsonResponse = mvcResult.getResponse().getContentAsString();
		String expectedJsonResponse = objectMapper.writeValueAsString(comm_list);
		assertEquals(actualJsonResponse,expectedJsonResponse);
	}
	
	@Test
    void addCommentTest() throws JsonProcessingException, Exception {
		
	       CommentDTO comm= new CommentDTO();
		   comm.setUserId(1);
		   comm.setAnsId(1);
		   comm.setCommentBody("this is a comment for testing");
			
		   User user= new User();
		   user.setUserId(1);
		   user.setEmail("abc@gmail.com");
		   user.setPassword("123");
		   user.setPhoto("img");
		   user.setUsername("sakshi");			 
			
		   Topic topic1= new Topic();
		   topic1.setTopicId(1);
		   topic1.setTopicName("country");
			
		   Question ques1= new Question();
		   ques1.setQuesId(1);
		   ques1.setUser(user);
		   ques1.setTopic(topic1);
		   ques1.setTitle("national game");
		   ques1.setBody("Which is our national game?");
		   ques1.setMarked(true);
		   
		  Answer ans= new Answer(1,user,ques1,"hockey is our national game",true);
			
		  Comment comment= new Comment();
		  comment.setUser(user);
		  comment.setCommentBody(comm.getCommentBody());
		  comment.setAnswer(ans);
				 
		  when(commentService.addComment(comment)).thenReturn(true);
		  assertEquals(1,ques1.getQuesId());
			
    	  String url="/api/addcomment";
		  mockMvc.perform(
						 post(url)
						.contentType("application/json")
					    .content(objectMapper.writeValueAsString(comment)))
        			    .andReturn();
			
	}
}
