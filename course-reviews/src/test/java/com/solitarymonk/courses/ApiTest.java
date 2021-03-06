package com.solitarymonk.courses;

import com.google.gson.Gson;
import com.solitarymonk.courses.Api;
import com.solitarymonk.courses.dao.Sql2oCourseDao;
import com.solitarymonk.courses.dao.Sql2oReviewDao;
import com.solitarymonk.courses.model.Course;
import com.solitarymonk.courses.model.Review;
import com.solitarymonk.testing.ApiClient;
import com.solitarymonk.testing.ApiResponse;
import org.junit.*;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import spark.Spark;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ApiTest {

    private static final String PORT = "4568";
    private static final String TEST_DATASOURCE = "jdbc:h2:mem:testing";
    private static final String INITIALIZE = ";INIT=RUNSCRIPT from 'classpath:db/init.sql'";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    private Connection conn;
    private ApiClient client;
    private Gson gson;
    private Sql2oCourseDao courseDao;
    private Sql2oReviewDao reviewDao;

    @BeforeClass
    public static void startServer() {
        String[] args = {PORT, TEST_DATASOURCE};
        Api.main(args);
    }

    @AfterClass
    public static void stopServer() {
        Spark.stop();
    }

    @Before
    public void setUp() throws Exception {
        Sql2o sql2o = new Sql2o(TEST_DATASOURCE + INITIALIZE, USERNAME, PASSWORD);
        courseDao = new Sql2oCourseDao(sql2o);
        reviewDao = new Sql2oReviewDao(sql2o);
        conn = sql2o.open();
        client = new ApiClient("http://localhost:" + PORT);
        gson = new Gson();
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingCoursesReturnsCreatedStatus() throws Exception {
        Map<String, String> values = new HashMap<>();
        values.put("name", "Test");
        values.put("url", "http://test.com");

        ApiResponse response = client.request("POST", "/courses", gson.toJson(values));
        assertEquals(201, response.getStatus());
    }

    @Test
    public void coursesCanBeAccessedById() throws Exception {
        Course course = newTestCourse();
        courseDao.add(course);

        ApiResponse response = client.request("GET", "/courses/" + course.getId());
        Course retrieved = gson.fromJson(response.getBody(), Course.class);

        assertEquals(course, retrieved);
    }

    @Test
    public void missingCoursesReturnNotFoundStatus() throws Exception {
        ApiResponse response = client.request("GET", "/courses/42");

        assertEquals(404, response.getStatus());
    }

    @Test
    public void addingReviewGivesCreatedStatus() throws Exception {
        Course course = newTestCourse();
        courseDao.add(course);
        Map<String, Object> values = new HashMap<>();
        values.put("rating", 5);
        values.put("comment", "Test comment");

        ApiResponse response = client.request("POST", String.format("/courses/%d/reviews", course.getId()), gson.toJson(values));

        assertEquals(201, response.getStatus());
    }

    @Test
    public void addingReviewToUnknownCourseThrowsError() throws Exception {
        Map<String, Object> values = new HashMap<>();
        values.put("rating", 5);
        values.put("comment", "Test comment");

        ApiResponse response = client.request("POST", "/courses/42/reviews", gson.toJson(values));

        assertEquals(500, response.getStatus());
    }

    @Test
    public void multipleReviewsReturnedForCourse() throws Exception {
        Course course = newTestCourse();
        courseDao.add(course);
        reviewDao.add(new Review(course.getId(), 5, "Test comment 1"));
        reviewDao.add(new Review(course.getId(), 1, "Test comment 2"));

        ApiResponse response = client.request("GET", String.format("/courses/%d/reviews", course.getId()));
        Review[] reviews = gson.fromJson(response.getBody(), Review[].class);

        assertEquals(2, reviews.length);
    }

    private Course newTestCourse() { return new Course("Test", "http://test.com"); }
}