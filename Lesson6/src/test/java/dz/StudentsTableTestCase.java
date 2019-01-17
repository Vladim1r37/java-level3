package dz;

import dz.repo.StudentsDAO;
import dz.repo.StudentsDAOImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentsTableTestCase {

    private StudentsDAO dao;
    private SQLiteService service;

    @Before
    public void prepare() {
        this.service = new SQLiteService("sample.db");
        this.dao = new StudentsDAOImpl(service.getConnection());
    }

    @After
    public void tearDown() {
        try {
            service.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAddRecord1() {
        Assert.assertEquals(1, dao.addRecord("Ivanov", 5));
    }

    @Test
    public void testAddRecord2() {
        Assert.assertEquals(1, dao.addRecord("Petrov", 3));
    }

    @Test
    public void testUpdateScore1() {
        Assert.assertEquals(1, dao.updateScore("Petrov", 4));
    }

    @Test
    public void testUpdateScore2() {
        Assert.assertEquals(0, dao.updateScore("Sidorov", 4));
    }

    @Test
    public void testUpdateScore3() {
        Assert.assertEquals(1, dao.updateScore("Petrov", 4));
    }

    @Test
    public void testReadScore1() {
        Assert.assertEquals(3, dao.readScore("Petrov"));
    }

    @Test
    public void testReadScore2() {
        Assert.assertEquals(0, dao.readScore("Sidorov"));
    }
}
