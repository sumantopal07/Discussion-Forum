<h1> Steps to run the project: </h1> <br>
<h2> 1) Clone the repository </h2> <br>
<h2> 2) Open MySQL and run query <i>'create database auproject;'</i> </h2> <br>
<h2> 3) Import Backend from Eclipse as Maven project </h2> <br>
<h2> 4) Update application.properties file located in 'Backend/src/main/resources/' with your MySql credentials and run <i>DiscussionforumApplication.java</i> as Java application </h2> <br>
<h2> 5) Open MySql again and paste the following queries:</h2><br>
<ul>
<h3><i>use auproject; <br><br>
insert into topic(topic_id, topic_name) values (1, 'badminton'); <br><br>
insert into topic(topic_id, topic_name) values (2, 'algorithm'); <br><br>
insert into topic(topic_id, topic_name) values (3, 'technology'); <br><br>
insert into topic(topic_id, topic_name) values (4, 'framework'); <br><br>
insert into topic(topic_id, topic_name) values (5, 'psychiatry'); <br><br>
insert into topic(topic_id, topic_name) values (6, 'chess'); <br> </i><br>
 </ul>
<h2> 6) Go to Frontend, open terminal and run the following commands: </h2> <br>
 <ul>
  <h3>  a) <i>npm install</i> </h3> <br>
  <h3>  b) <i>ng serve --proxy-config=proxyconfig.json</i> <h3> <br> 
 </ul>
    <h2> 7) Visit <i><a href="http://localhost:4200/">http://localhost:4200/</a> </i> in your browser </h2> <br>
